package by.miaskor.report

import by.miaskor.report.ReportType.TURNOVER_STATEMENT_ACCOUNT_488_INSURANCE
import by.miaskor.style.StyleCreator
import by.miaskor.style.sheet.SheetAdjuster

class TurnOverStatementAccountInsuranceReport(
  private val styleCreator: StyleCreator,
  private val sheetAdjuster: SheetAdjuster
) : Report(
  styleCreator = styleCreator,
  sheetAdjuster = sheetAdjuster
) {
  override fun typeReport() = TURNOVER_STATEMENT_ACCOUNT_488_INSURANCE

  override fun sheetName() = TURNOVER_STATEMENT_ACCOUNT_488_INSURANCE.sheetName

  override fun headers() = mapOf(
    Pair(
      0, listOf(
        "Счет",
        "Показатели",
        "Сальдо на начало периода",
        "Обороты за период",
        "Сальдо на конец периода"
      )
    ),
    Pair(
      1, listOf(
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
      2, listOf(
        "Счет аналитического учета",
      )
    ),
    Pair(
      3, listOf(
        "Контрагенты",
      )
    ),
  )

  override fun cellValues() = mapOf<Int, List<String>>()
}
