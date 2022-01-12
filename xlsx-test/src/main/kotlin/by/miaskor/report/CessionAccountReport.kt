package by.miaskor.report

import by.miaskor.report.ReportType.CESSION_ACCOUNT
import by.miaskor.style.StyleCreator
import by.miaskor.style.sheet.SheetAdjuster

class CessionAccountReport(
  private val styleCreator: StyleCreator,
  private val sheetAdjuster: SheetAdjuster
) : Report(
  styleCreator = styleCreator,
  sheetAdjuster = sheetAdjuster
) {
  override fun typeReport() = CESSION_ACCOUNT

  override fun sheetName() = CESSION_ACCOUNT.sheetName

  override fun headers() = mapOf(
    Pair(
      0, listOf(
        "Номер счета бухгалтерского учета",
        "Валюта, руб.",
        "Собственные операции ",
        "Произвольный сегмент",
        "Лицевой счет",
        "Наименование",
        "Примечание"
      )
    )
  )

  override fun cellValues() = mapOf<Int, List<String>>()
}
