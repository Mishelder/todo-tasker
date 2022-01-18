package by.miaskor.report

import by.miaskor.report.ReportType.TRANSACTIONS_ACCOUNT
import by.miaskor.style.StyleCreator
import by.miaskor.style.sheet.SheetAdjuster

class TransactionsAccountReport(
  private val styleCreator: StyleCreator,
  private val sheetAdjuster: SheetAdjuster
) : Report(
  styleCreator = styleCreator,
  sheetAdjuster = sheetAdjuster
) {
  override fun typeReport() = TRANSACTIONS_ACCOUNT

  override fun sheetName() = TRANSACTIONS_ACCOUNT.sheetName

  override fun cellValues() = mapOf<Int, List<String>>()

  override fun headers() = mapOf(
    Pair(
      0,
      listOf("Выписка по лицевому счету Заемщика")
    ),
    Pair(
      1, listOf(
        "Дата операции",
        "Счет бухгалтерского учета",
        "Лицевой счет",
        "Структура аналитики счета",
        "Счет бухгалтерского учета",
        "Лицевой счет",
        "Структура аналитики счета",
        "Содержание операция",
        "Сумма, руб.",
        "Примечание"
      )
    )
  )
}
