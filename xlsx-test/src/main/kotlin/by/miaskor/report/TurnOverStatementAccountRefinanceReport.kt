package by.miaskor.report

import by.miaskor.generator.ExcelGenerator
import by.miaskor.report.ReportType.TURNOVER_STATEMENT_ACCOUNT_488_REFINANCE
import by.miaskor.style.StyleCreator
import org.apache.poi.xssf.usermodel.XSSFWorkbook

class TurnOverStatementAccountRefinanceReport(
  private val excelGenerator: ExcelGenerator,
  private val styleCreator: StyleCreator,
  private val workbook: XSSFWorkbook
) : Report(excelGenerator, styleCreator, workbook) {
  override fun typeReport() = TURNOVER_STATEMENT_ACCOUNT_488_REFINANCE

  override fun sheetName() = TURNOVER_STATEMENT_ACCOUNT_488_REFINANCE.sheetName

  override fun headers() = listOf(
    "Период",
    "Документ",
    "Аналитика Дт",
    "Аналитика Кт",
    "Показатель",
    "Дебет",
    "Счет",
    "Кредит",
    "Счет",
    "Текущее сальдо",
    "Сальдо на начало"
  )

  override fun cellValues() = mapOf<Int, List<String>>()
}
