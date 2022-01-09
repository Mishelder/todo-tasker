package by.miaskor.report

import by.miaskor.generator.ExcelGenerator
import by.miaskor.report.ReportType.PERSONAL_ACCOUNT
import by.miaskor.style.StyleCreator
import org.apache.poi.xssf.usermodel.XSSFWorkbook

class PersonalAccountReport(
  private val excelGenerator: ExcelGenerator,
  private val styleCreator: StyleCreator,
  private val workbook: XSSFWorkbook
) : Report(excelGenerator, styleCreator, workbook) {

  override fun typeReport(): ReportType {
    return PERSONAL_ACCOUNT
  }

  override fun sheetName(): String {
    return PERSONAL_ACCOUNT.sheetName
  }

  override fun headers() = listOf(
    "Счет первого порядка ",
    "Счет второго порядка",
    "Валюта, руб.",
    "Собственные операции",
    "Произвольный сегмент",
    "Пример лицевого счета",
    "Наименование",
    "Примечание"
  )

  override fun cellValues() = mapOf(
    Pair(
      1, listOf(
        "488",
        "01",
        "810",
        "0",
        "00000000001",
        "488 01 810 0 0000000000 1",
        "Основной долг",
        ""
      )
    ),
    Pair(
      2, listOf(
        "488",
        "02",
        "810",
        "0",
        "00000000001",
        "488 02 810 0 0000000000 1",
        "Проценты (начисления)",
        ""
      )
    ),
    Pair(
      3, listOf(
        "488",
        "09",
        "810",
        "0",
        "00000000001",
        "488 09 810 0 0000000000 1",
        "Проценты (расчеты)",
        ""
      )
    ),
    Pair(
      4, listOf(
        "612",
        "17",
        "810",
        "0",
        "00000000001",
        "612 17 810 0 0000000000 1\n",
        "Выбытие (реализация)",
        ""
      )
    ),
  )
}
