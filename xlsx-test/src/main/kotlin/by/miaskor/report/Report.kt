package by.miaskor.report

import by.miaskor.generator.ExcelGenerator
import by.miaskor.style.StyleCreator
import org.apache.poi.xssf.usermodel.XSSFWorkbook

abstract class Report(
  private val excelGenerator: ExcelGenerator,
  private val styleCreator: StyleCreator,
  private val workbook: XSSFWorkbook
) {

  fun createReport() {
    excelGenerator
      .row(
        sheetName = sheetName(), cellValues = headers(),
        cellStyle = styleCreator.headerStyle(workbook)
      )
      .cells(
        sheetName = sheetName(), cellValues = cellValues(),
        cellStyle = styleCreator.valueStyle(workbook)
      )
  }

  abstract fun typeReport(): ReportType

  abstract fun sheetName(): String

  abstract fun headers(): List<String>

  abstract fun cellValues(): Map<Int, List<String>>
}
