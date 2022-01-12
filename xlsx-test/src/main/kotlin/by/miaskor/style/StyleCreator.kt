package by.miaskor.style

import org.apache.poi.xssf.usermodel.XSSFCellStyle
import org.apache.poi.xssf.usermodel.XSSFWorkbook

interface StyleCreator {
  fun createStyle(workbook: XSSFWorkbook): XSSFCellStyle
}
