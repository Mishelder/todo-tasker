package by.miaskor.style.sheet

import org.apache.poi.ss.util.CellRangeAddress
import org.apache.poi.xssf.usermodel.XSSFRow
import org.apache.poi.xssf.usermodel.XSSFSheet
import org.apache.poi.xssf.usermodel.XSSFWorkbook

class StatementPersonalAccountSheetAdjuster : SheetAdjuster {
  override fun adjustColumns(workbook: XSSFWorkbook, sheetName: String): XSSFSheet {

    val sheet = workbook.createSheet(sheetName)

    sheet.addMergedRegion(CellRangeAddress(0, 0, 0, 9))
    return sheet.apply {
      setColumnWidth(0, 256 * 20)
      setColumnWidth(1, 256 * 20)
      setColumnWidth(2, 256 * 50)
      setColumnWidth(3, 256 * 55)
      setColumnWidth(4, 256 * 30)
      setColumnWidth(5, 256 * 50)
      setColumnWidth(6, 256 * 55)
      setColumnWidth(7, 256 * 55)
      setColumnWidth(8, 256 * 35)
      setColumnWidth(9, 256 * 40)
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
