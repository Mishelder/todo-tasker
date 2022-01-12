package by.miaskor.style.sheet

import org.apache.poi.xssf.usermodel.XSSFRow
import org.apache.poi.xssf.usermodel.XSSFSheet
import org.apache.poi.xssf.usermodel.XSSFWorkbook

interface SheetAdjuster {

  fun adjustRow(sheet: XSSFSheet, rowNum: Int): XSSFRow
  fun adjustColumns(workbook: XSSFWorkbook, sheetName: String): XSSFSheet
}
