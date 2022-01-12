package by.miaskor.style

import by.miaskor.builder.FontBuilder
import org.apache.poi.ss.usermodel.HorizontalAlignment
import org.apache.poi.ss.usermodel.VerticalAlignment
import org.apache.poi.xssf.usermodel.XSSFCellStyle
import org.apache.poi.xssf.usermodel.XSSFWorkbook

class DefaultStyleCreator : StyleCreator {
  override fun createStyle(workbook: XSSFWorkbook): XSSFCellStyle {
    return workbook.createCellStyle().apply {
      alignment = HorizontalAlignment.CENTER
      verticalAlignment = VerticalAlignment.CENTER
      wrapText = true
      setFont(FontBuilder().createFont(workbook).fontSize(14).fontName("Times New Roman").bold(true).build())
    }
  }
}
