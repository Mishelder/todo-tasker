package by.miaskor.style.sheet

import org.apache.poi.xssf.usermodel.XSSFRow
import org.apache.poi.xssf.usermodel.XSSFSheet
import org.apache.poi.xssf.usermodel.XSSFWorkbook

class CalculationAnalyticalAccountingSheetAdjuster : SheetAdjuster {

  override fun adjustColumns(workbook: XSSFWorkbook, sheetName: String): XSSFSheet {
    return workbook.createSheet(sheetName).apply {
      setColumnWidth(0, 256 * 30)
      setColumnWidth(1, 256 * 20)
      setColumnWidth(2, 256 * 30)
      setColumnWidth(3, 256 * 30)
      setColumnWidth(4, 256 * 55)
      setColumnWidth(5, 256 * 55)
      setColumnWidth(6, 256 * 35)
    }
  }

  override fun adjustRow(sheet: XSSFSheet, rowNum: Int): XSSFRow {
    return sheet.createRow(rowNum).apply {
      heightInPoints = HEIGHT_ROW
    }
  }

  private companion object {
    private const val HEIGHT_ROW = 40F
  }
}
