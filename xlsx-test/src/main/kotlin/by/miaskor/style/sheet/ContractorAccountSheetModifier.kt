package by.miaskor.style.sheet

import by.miaskor.report.ReportType.CONTRACTOR_ACCOUNT
import org.apache.poi.xssf.usermodel.XSSFRow
import org.apache.poi.xssf.usermodel.XSSFSheet

class ContractorAccountSheetModifier : SheetModifier {
  override fun modifyColumn(sheet: XSSFSheet) {
    sheet.apply {
      setColumnWidth(0, 256 * 45)
      setColumnWidth(1, 256 * 30)
      setColumnWidth(2, 256 * 30)
      setColumnWidth(3, 256 * 50)
      setColumnWidth(4, 256 * 50)
      setColumnWidth(5, 256 * 50)
      setColumnWidth(6, 256 * 45)
      setColumnWidth(7, 256 * 20)
    }
  }

  override fun modifyRow(row: XSSFRow) {
    row.heightInPoints = 40F
  }

  override fun sheetName() = CONTRACTOR_ACCOUNT.sheetName
}
