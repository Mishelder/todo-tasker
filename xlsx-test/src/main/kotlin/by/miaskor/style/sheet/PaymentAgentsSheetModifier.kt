package by.miaskor.style.sheet

import by.miaskor.report.ReportType.PAYMENT_AGENTS_ACCOUNT
import org.apache.poi.xssf.usermodel.XSSFRow
import org.apache.poi.xssf.usermodel.XSSFSheet

class PaymentAgentsSheetModifier : SheetModifier {
  override fun modifyColumn(sheet: XSSFSheet) {
    sheet.apply {
      setColumnWidth(0, 256 * 20)
      setColumnWidth(1, 256 * 20)
      setColumnWidth(2, 256 * 20)
      setColumnWidth(3, 256 * 20)
      setColumnWidth(4, 256 * 35)
      setColumnWidth(5, 256 * 50)
      setColumnWidth(6, 256 * 50)
    }
  }

  override fun modifyRow(row: XSSFRow) {
    row.heightInPoints = 55F
  }

  override fun sheetName() = PAYMENT_AGENTS_ACCOUNT.sheetName
}
