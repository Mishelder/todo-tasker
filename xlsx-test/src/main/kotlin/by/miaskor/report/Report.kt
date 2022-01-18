package by.miaskor.report

import by.miaskor.style.StyleCreator
import by.miaskor.style.sheet.SheetAdjuster
import org.apache.poi.xssf.usermodel.XSSFSheet
import org.apache.poi.xssf.usermodel.XSSFWorkbook

abstract class Report(
  private val styleCreator: StyleCreator,
  private val sheetAdjuster: SheetAdjuster
) {

  fun createReport(): XSSFWorkbook {
    val workbook = XSSFWorkbook()
    val sheet = sheetAdjuster.adjustColumns(workbook, sheetName())
    headers().forEach { entry ->
      createCellValues(sheetAdjuster, styleCreator, sheet, entry, workbook)
    }
    cellValues().forEach { entry ->
      createCellValues(sheetAdjuster, styleCreator, sheet, entry, workbook)
    }
    return workbook
  }

  private fun createCellValues(
    sheetAdjuster: SheetAdjuster,
    styleCreator: StyleCreator,
    sheet: XSSFSheet,
    entry: Map.Entry<Int, List<String>>,
    workbook: XSSFWorkbook
  ) {
    val row = sheetAdjuster.adjustRow(sheet, entry.key)
    val cellStyle = styleCreator.createStyle(workbook)
    entry.value.forEachIndexed { index, value ->
      val cell = row.createCell(index)
      cell.setCellValue(value)
      cell.cellStyle = cellStyle
    }
  }

  abstract fun typeReport(): ReportType

  protected abstract fun sheetName(): String

  protected abstract fun cellValues(): Map<Int, List<String>>

  protected abstract fun headers(): Map<Int, List<String>>
}
