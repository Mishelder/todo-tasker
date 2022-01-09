package by.miaskor.report

import by.miaskor.generator.ExcelGenerator
import by.miaskor.report.ReportType.TRANSACTIONS_ACCOUNT
import by.miaskor.style.StyleCreator
import org.apache.poi.xssf.usermodel.XSSFWorkbook

class TransactionsAccountReport(
  private val excelGenerator: ExcelGenerator,
  private val styleCreator: StyleCreator,
  private val workbook: XSSFWorkbook
) : Report(excelGenerator, styleCreator, workbook) {
  override fun typeReport() = TRANSACTIONS_ACCOUNT

  override fun sheetName() = TRANSACTIONS_ACCOUNT.sheetName

  override fun headers() = listOf(
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

  override fun cellValues() = mapOf<Int, List<String>>()
}
