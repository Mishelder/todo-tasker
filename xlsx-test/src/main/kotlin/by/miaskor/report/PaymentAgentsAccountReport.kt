package by.miaskor.report

import by.miaskor.generator.ExcelGenerator
import by.miaskor.report.ReportType.PAYMENT_AGENTS_ACCOUNT
import by.miaskor.style.StyleCreator
import org.apache.poi.xssf.usermodel.XSSFWorkbook

class PaymentAgentsAccountReport(
  private val excelGenerator: ExcelGenerator,
  private val styleCreator: StyleCreator,
  private val workbook: XSSFWorkbook
) : Report(excelGenerator, styleCreator, workbook) {

  override fun typeReport(): ReportType {
    return PAYMENT_AGENTS_ACCOUNT
  }

  override fun sheetName(): String {
    return PAYMENT_AGENTS_ACCOUNT.sheetName
  }

  override fun headers() = listOf(
    "Номер счета бухгалтерского учета",
    "Валюта, руб.",
    "Собственные операции ",
    "Произвольный сегмент",
    "Лицевой счет",
    "Наименование",
    "Примечание"
  )

  override fun cellValues() = mapOf(
    Pair(
      1, listOf(
        "47422",
        "810",
        "0",
        "\"00000000001",
        "47422810000000000001",
        "Обязательства по прочим финансовым " +
            "операциям",
        "счет учета Платежного агента по договору операций поступления денежных средств по договорам " +
            "займов выданных"
      )
    ),
    Pair(
      2, listOf(
        "47423", "810", "0", "\"00000000001", "47423810000000000001", "Требования по прочим финансовым операциям",
        "счет учета Платежного агента по договору операций, связанных с выдачей займов"
      )
    )
  )
}
