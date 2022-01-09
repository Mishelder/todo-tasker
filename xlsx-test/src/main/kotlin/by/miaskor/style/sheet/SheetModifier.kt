package by.miaskor.style.sheet

import org.apache.poi.xssf.usermodel.XSSFRow
import org.apache.poi.xssf.usermodel.XSSFSheet

interface SheetModifier {

  fun modifyColumn(sheet: XSSFSheet)
  fun modifyRow(row: XSSFRow)

  fun sheetName(): String
}
