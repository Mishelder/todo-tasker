package by.miaskor.report

import by.miaskor.generator.ExcelGenerator
import by.miaskor.report.ReportType.INCOME_EXPENSES_ACCOUNT
import by.miaskor.style.StyleCreator
import org.apache.poi.xssf.usermodel.XSSFWorkbook

class IncomeExpensesAccountReport(
  private val excelGenerator: ExcelGenerator,
  private val styleCreator: StyleCreator,
  private val workbook: XSSFWorkbook
) : Report(excelGenerator, styleCreator, workbook) {
  override fun typeReport() = INCOME_EXPENSES_ACCOUNT

  override fun sheetName() = INCOME_EXPENSES_ACCOUNT.sheetName

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
