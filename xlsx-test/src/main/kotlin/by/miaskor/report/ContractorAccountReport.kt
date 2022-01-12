package by.miaskor.report

import by.miaskor.report.ReportType.CONTRACTOR_ACCOUNT
import by.miaskor.style.StyleCreator
import by.miaskor.style.sheet.SheetAdjuster

class ContractorAccountReport(
  private val styleCreator: StyleCreator,
  private val sheetAdjuster: SheetAdjuster
) : Report(
  styleCreator = styleCreator,
  sheetAdjuster = sheetAdjuster
) {

  override fun typeReport() = CONTRACTOR_ACCOUNT

  override fun sheetName() = CONTRACTOR_ACCOUNT.sheetName

  override fun cellValues() = mapOf<Int, List<String>>()

  override fun headers() = mapOf(
    Pair(0, listOf("Открытые лицевые счета по Контрагентам")),
    Pair(
      1, listOf(
        "Наименование",
        "Код",
        "Вид",
        "Договор",
        "ЛС 47422",
        "ЛС 47423",
        "Формы оплаты в 1с",
        "код"
      )
    )
  )
}
