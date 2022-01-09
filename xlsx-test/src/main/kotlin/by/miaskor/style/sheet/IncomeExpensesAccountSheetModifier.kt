package by.miaskor.style.sheet

import by.miaskor.report.ReportType.INCOME_EXPENSES_ACCOUNT
import org.apache.poi.xssf.usermodel.XSSFRow
import org.apache.poi.xssf.usermodel.XSSFSheet

class IncomeExpensesAccountSheetModifier : SheetModifier {
  override fun modifyColumn(sheet: XSSFSheet) {
    sheet.apply {
      setColumnWidth(0, 256 * 35)
      setColumnWidth(1, 256 * 25)
      setColumnWidth(2, 256 * 35)
      setColumnWidth(3, 256 * 40)
      setColumnWidth(4, 256 * 50)
      setColumnWidth(5, 256 * 60)
      setColumnWidth(5, 256 * 60)
    }
  }

  override fun modifyRow(row: XSSFRow) {
    row.heightInPoints = 40F
  }

  override fun sheetName() = INCOME_EXPENSES_ACCOUNT.sheetName
}
