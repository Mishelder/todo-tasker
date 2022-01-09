package by.miaskor.style.sheet

import by.miaskor.report.ReportType.PERSONAL_ACCOUNT
import org.apache.poi.xssf.usermodel.XSSFRow
import org.apache.poi.xssf.usermodel.XSSFSheet

class PersonalAccountSheetModifier : SheetModifier {
  override fun modifyColumn(sheet: XSSFSheet) {
    sheet.apply {
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

  override fun modifyRow(row: XSSFRow) {
    row.heightInPoints = 40F
  }

  override fun sheetName() = PERSONAL_ACCOUNT.sheetName
}
