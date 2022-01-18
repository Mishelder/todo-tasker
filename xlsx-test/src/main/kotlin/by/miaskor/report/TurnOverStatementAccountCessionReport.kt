package by.miaskor.report

import by.miaskor.report.ReportType.TURNOVER_STATEMENT_ACCOUNT_61217_CESSION
import by.miaskor.style.StyleCreator
import by.miaskor.style.sheet.SheetAdjuster

class TurnOverStatementAccountCessionReport(
  private val styleCreator: StyleCreator,
  private val sheetAdjuster: SheetAdjuster
) : Report(
  styleCreator = styleCreator,
  sheetAdjuster = sheetAdjuster
) {
  override fun typeReport() = TURNOVER_STATEMENT_ACCOUNT_61217_CESSION

  override fun sheetName() = TURNOVER_STATEMENT_ACCOUNT_61217_CESSION.sheetName

  override fun headers() = mapOf(
    Pair(0, listOf("ООО МФК \"Мани Мен\"")),
    Pair(1, listOf("Оборотно-сальдовая ведомость по счетам 61217 за Июль 2021 г. (ЦЕССИЯ)")),

    Pair(
      2, listOf(
        "Счет",
        "Показатели",
        "Сальдо на начало периода",
        "Обороты за период",
        "Сальдо на конец периода"
      )
    ),
    Pair(
      3, listOf(
        "Подразделение",
        "Дебет",
        "Кредит",
        "Дебет",
        "Кредит",
        "Дебет",
        "Кредит"
      )
    ),
    Pair(
      4, listOf(
        "Структура аналитического учета",
      )
    ),
    Pair(
      5, listOf(
        "Контрагенты",
      )
    ),
  )

  override fun cellValues() = mapOf<Int, List<String>>()
}
