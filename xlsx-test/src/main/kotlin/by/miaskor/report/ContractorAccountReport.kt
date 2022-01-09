package by.miaskor.report

import by.miaskor.generator.ExcelGenerator
import by.miaskor.report.ReportType.CONTRACTOR_ACCOUNT
import by.miaskor.style.StyleCreator
import org.apache.poi.xssf.usermodel.XSSFWorkbook

class ContractorAccountReport(
  private val excelGenerator: ExcelGenerator,
  private val styleCreator: StyleCreator,
  private val workbook: XSSFWorkbook
) : Report(excelGenerator, styleCreator, workbook) {
  override fun typeReport() = CONTRACTOR_ACCOUNT

  override fun sheetName() = CONTRACTOR_ACCOUNT.sheetName

  override fun headers() = listOf(
    "Наименование",
    "Код",
    "Вид",
    "Договор",
    "ЛС 47422",
    "ЛС 47423",
    "Формы оплаты в 1с",
    "код"
  )

  override fun cellValues() = mapOf<Int, List<String>>()
}
