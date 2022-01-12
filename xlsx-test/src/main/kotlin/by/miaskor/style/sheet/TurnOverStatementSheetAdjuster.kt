package by.miaskor.style.sheet

import org.apache.poi.ss.util.CellRangeAddress
import org.apache.poi.xssf.usermodel.XSSFRow
import org.apache.poi.xssf.usermodel.XSSFSheet
import org.apache.poi.xssf.usermodel.XSSFWorkbook

class TurnOverStatementSheetAdjuster : SheetAdjuster {

  override fun adjustColumns(workbook: XSSFWorkbook, sheetName: String): XSSFSheet {

    val s = workbook.createSheet(sheetName)
    s.addMergedRegion(CellRangeAddress(0, 0, 0, 7))
    s.addMergedRegion(CellRangeAddress(1, 1, 0, 7))

    s.addMergedRegion(CellRangeAddress(2, 5, 1, 1))

    s.addMergedRegion(CellRangeAddress(2, 2, 2, 3))
    s.addMergedRegion(CellRangeAddress(2, 2, 4, 5))
    s.addMergedRegion(CellRangeAddress(2, 2, 6, 7))

    for (index in 2..7) {
      s.addMergedRegion(CellRangeAddress(3, 5, index, index))
    }

    return s.apply {
      setColumnWidth(0, 256 * 45)
      setColumnWidth(1, 256 * 35)
      setColumnWidth(2, 256 * 30)
      setColumnWidth(3, 256 * 30)
      setColumnWidth(4, 256 * 30)
      setColumnWidth(5, 256 * 30)
      setColumnWidth(6, 256 * 30)
      setColumnWidth(7, 256 * 30)
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
