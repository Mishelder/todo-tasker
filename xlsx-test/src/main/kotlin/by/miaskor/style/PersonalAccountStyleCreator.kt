package by.miaskor.style

import org.apache.poi.xssf.usermodel.XSSFCellStyle
import org.apache.poi.xssf.usermodel.XSSFWorkbook
import org.springframework.stereotype.Component

@Component
class PersonalAccountStyleCreator : StyleCreator {
  override fun headerStyle(workbook: XSSFWorkbook): XSSFCellStyle {
    TODO("Not yet implemented")
  }

  override fun valueStyle(workbook: XSSFWorkbook): XSSFCellStyle {
    TODO("Not yet implemented")
  }
}
