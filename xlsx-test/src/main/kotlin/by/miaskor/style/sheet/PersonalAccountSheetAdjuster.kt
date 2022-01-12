package by.miaskor.style.sheet

import org.apache.poi.xssf.usermodel.XSSFRow
import org.apache.poi.xssf.usermodel.XSSFSheet
import org.apache.poi.xssf.usermodel.XSSFWorkbook

class PersonalAccountSheetAdjuster : SheetAdjuster {

  override fun adjustColumns(workbook: XSSFWorkbook, sheetName: String): XSSFSheet {
    return workbook.createSheet(sheetName).apply {
      setColumnWidth(0, 256 * 20)
      setColumnWidth(1, 256 * 20)
      setColumnWidth(2, 256 * 20)
      setColumnWidth(3, 256 * 20)
      setColumnWidth(4, 256 * 20)
      setColumnWidth(5, 256 * 30)
      setColumnWidth(6, 256 * 23)
      setColumnWidth(7, 256 * 25)
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
