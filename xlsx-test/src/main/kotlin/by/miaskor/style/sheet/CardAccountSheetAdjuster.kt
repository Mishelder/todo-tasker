package by.miaskor.style.sheet

import org.apache.poi.ss.util.CellRangeAddress
import org.apache.poi.xssf.usermodel.XSSFRow
import org.apache.poi.xssf.usermodel.XSSFSheet
import org.apache.poi.xssf.usermodel.XSSFWorkbook

class CardAccountSheetAdjuster : SheetAdjuster {
  override fun adjustColumns(workbook: XSSFWorkbook, sheetName: String): XSSFSheet {

    val s = workbook.createSheet(sheetName)
    for (index in 0..4) {
      s.addMergedRegion(CellRangeAddress(2, 3, index, index))
    }
    s.addMergedRegion(CellRangeAddress(2, 2, 5, 7))
    s.addMergedRegion(CellRangeAddress(2, 2, 8, 10))
    s.addMergedRegion(CellRangeAddress(2, 3, 11, 12))


    return s.apply {
      setColumnWidth(0, 256 * 35)
      setColumnWidth(1, 256 * 35)
      setColumnWidth(2, 256 * 35)
      setColumnWidth(3, 256 * 35)
      setColumnWidth(4, 256 * 30)
      setColumnWidth(5, 256 * 30)
      setColumnWidth(6, 256 * 30)
      setColumnWidth(7, 256 * 25)
      setColumnWidth(8, 256 * 25)
      setColumnWidth(9, 256 * 25)
      setColumnWidth(10, 256 * 25)
      setColumnWidth(11, 256 * 25)
      setColumnWidth(12, 256 * 25)
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
