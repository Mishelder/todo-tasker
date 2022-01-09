package by.miaskor.report

import by.miaskor.generator.ExcelGenerator
import by.miaskor.report.ReportType.TURNOVER_STATEMENT_ACCOUNT_61217_CESSION
import by.miaskor.style.StyleCreator
import org.apache.poi.xssf.usermodel.XSSFWorkbook

class TurnOverStatementAccountCessionReport(
  private val excelGenerator: ExcelGenerator,
  private val styleCreator: StyleCreator,
  private val workbook: XSSFWorkbook
) : Report(excelGenerator, styleCreator, workbook) {
  override fun typeReport() = TURNOVER_STATEMENT_ACCOUNT_61217_CESSION

  override fun sheetName() = TURNOVER_STATEMENT_ACCOUNT_61217_CESSION.sheetName

  override fun headers() = listOf(
    "Счет",
    "Структура аналитического счета",
    "Контрагенты",
    "Договоры",
    "Показатели",
    "Сальдо на начало периода",
    "Дебет",
    "Кредит",
    "Обороты за период",
    "Дебет",
    "Кредит",
    "Сальдо на конец периода",
    "Дебет",
    "Кредит"
  )

  override fun cellValues() = mapOf<Int, List<String>>()
}
