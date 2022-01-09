package by.miaskor.style.sheet

import by.miaskor.report.ReportType.TURNOVER_STATEMENT_ACCOUNT_60322_PENALTY
import org.apache.poi.xssf.usermodel.XSSFRow
import org.apache.poi.xssf.usermodel.XSSFSheet

class AccountSZTTTSheetModifier : SheetModifier {
  override fun modifyColumn(sheet: XSSFSheet) {
    sheet.apply {
      setColumnWidth(0, 256 * 20)
      setColumnWidth(1, 256 * 40)
      setColumnWidth(2, 256 * 35)
      setColumnWidth(3, 256 * 35)
      setColumnWidth(4, 256 * 20)
      setColumnWidth(5, 256 * 30)
    }
  }

  override fun modifyRow(row: XSSFRow) {
    row.heightInPoints = 40F
  }

  override fun sheetName() = TURNOVER_STATEMENT_ACCOUNT_60322_PENALTY.sheetName
}

