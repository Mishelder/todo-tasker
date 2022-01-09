package by.miaskor.report

import by.miaskor.generator.ExcelGenerator
import by.miaskor.report.ReportType.CESSION_ACCOUNT
import by.miaskor.style.StyleCreator
import org.apache.poi.xssf.usermodel.XSSFWorkbook

class CessionAccountReport(
  private val excelGenerator: ExcelGenerator,
  private val styleCreator: StyleCreator,
  private val workbook: XSSFWorkbook
) : Report(excelGenerator, styleCreator, workbook) {
  override fun typeReport() = CESSION_ACCOUNT

  override fun sheetName() = CESSION_ACCOUNT.sheetName

  override fun headers() = listOf(
    "Номер счета бухгалтерского учета",
    "Валюта, руб.",
    "Собственные операции ",
    "Произвольный сегмент",
    "Лицевой счет",
    "Наименование",
    "Примечание"
  )

  override fun cellValues() = mapOf<Int, List<String>>()
}
