package by.miaskor.report

import by.miaskor.report.ReportType.INCOME_EXPENSES_ACCOUNT
import by.miaskor.style.StyleCreator
import by.miaskor.style.sheet.SheetAdjuster

class IncomeExpensesAccountReport(
  private val styleCreator: StyleCreator,
  private val sheetAdjuster: SheetAdjuster
) : Report(
  styleCreator = styleCreator,
  sheetAdjuster = sheetAdjuster
) {

  override fun typeReport() = INCOME_EXPENSES_ACCOUNT

  override fun sheetName() = INCOME_EXPENSES_ACCOUNT.sheetName

  override fun cellValues() = mapOf<Int, List<String>>()

  override fun headers() = mapOf(
    Pair(
      0, listOf(
        "Номер счета бухгалтерского учета ",
        "Валюта, руб.",
        "Собственные операции",
        "Символы ОФР",
        "Произвольный сегмент",
        "Лицевой счет",
        "Наименование ",
        "Статья ОФР"
      )
    )
  )
}
