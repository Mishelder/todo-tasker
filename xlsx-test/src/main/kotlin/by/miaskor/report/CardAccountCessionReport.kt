package by.miaskor.report

import by.miaskor.generator.ExcelGenerator
import by.miaskor.report.ReportType.CARD_ACCOUNT_61217_CESSION
import by.miaskor.style.StyleCreator
import org.apache.poi.xssf.usermodel.XSSFWorkbook

class CardAccountCessionReport(
  private val excelGenerator: ExcelGenerator,
  private val styleCreator: StyleCreator,
  private val workbook: XSSFWorkbook
) : Report(excelGenerator, styleCreator, workbook) {
  override fun typeReport() = CARD_ACCOUNT_61217_CESSION

  override fun sheetName() = CARD_ACCOUNT_61217_CESSION.sheetName

  override fun headers() = listOf(
    "Период",
    "Документ",
    "Аналитика Дт",
    "Аналитика Кт",
    "Дебет",
    "Счет",
    "Кредит",
    "Счет",
    "Текущее сальдо",
    "Сальдо на начало"
  )

  override fun cellValues() = mapOf<Int, List<String>>()
}
