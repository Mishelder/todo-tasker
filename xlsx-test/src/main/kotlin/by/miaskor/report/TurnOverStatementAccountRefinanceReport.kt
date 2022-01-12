package by.miaskor.report

import by.miaskor.report.ReportType.TURNOVER_STATEMENT_ACCOUNT_488_REFINANCE
import by.miaskor.style.StyleCreator
import by.miaskor.style.sheet.SheetAdjuster

class TurnOverStatementAccountRefinanceReport(
  private val styleCreator: StyleCreator,
  private val sheetAdjuster: SheetAdjuster
) : Report(
  styleCreator = styleCreator,
  sheetAdjuster = sheetAdjuster
) {
  override fun typeReport() = TURNOVER_STATEMENT_ACCOUNT_488_REFINANCE

  override fun sheetName() = TURNOVER_STATEMENT_ACCOUNT_488_REFINANCE.sheetName

  override fun headers() = mapOf(
    Pair(0, listOf("ООО МФК \"Мани Мен\"")),
    Pair(1, listOf("Оборотно-сальдовая ведомость по счетам 488 за Июль 2021 г. (СТРАХОВАНИЕ)")),
    Pair(
      2, listOf(
        "Период",
        "Документ",
        "Аналитика Дт",
        "Аналитика Кт",
        "Показатель",
        "Дебет",
        "Кредит",
        "Текущее сальдо",
      )
    ),
    Pair(
      3, listOf(
        "Сальдо на начало",
        "Счет",
        "Счет",
      )
    )
  )

  override fun cellValues() = mapOf<Int, List<String>>()
}
