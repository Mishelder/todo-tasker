package by.miaskor.report

import by.miaskor.report.ReportType.TURNOVER_STATEMENT_ACCOUNT_60322_PENALTY
import by.miaskor.style.StyleCreator
import by.miaskor.style.sheet.SheetAdjuster

class TurnOverStatementAccountPenaltyReport(
  private val styleCreator: StyleCreator,
  private val sheetAdjuster: SheetAdjuster
) : Report(
  styleCreator = styleCreator,
  sheetAdjuster = sheetAdjuster
) {
  override fun typeReport() = TURNOVER_STATEMENT_ACCOUNT_60322_PENALTY

  override fun sheetName() = TURNOVER_STATEMENT_ACCOUNT_60322_PENALTY.sheetName

  override fun headers() = mapOf(
    Pair(0, listOf("ООО МФК \"Мани Мен\"")),
    Pair(1, listOf("Оборотно-сальдовая ведомость по счетам 60322, 60323 за 2021 г. (ПЕНИ)")),
    Pair(
      2, listOf(
        "Счет",
        "Показатели",
        "Сальдо на начало периода",
        "",
        "Обороты за период",
        "",
        "Сальдо на конец периода"
      )
    ),
    Pair(
      3, listOf(
        "Счет аналитического учета",
        "",
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
        "Контрагенты",
      )
    ),
    Pair(
      5, listOf(
        "Договоры",
      )
    ),
  )

  override fun cellValues() = mapOf<Int, List<String>>()
}
