package by.miaskor.generator

import com.itextpdf.text.Document
import com.itextpdf.text.FontFactory
import com.itextpdf.text.Phrase
import com.itextpdf.text.pdf.PdfPCell
import com.itextpdf.text.pdf.PdfPTable
import com.itextpdf.text.pdf.PdfWriter
import org.apache.poi.ss.usermodel.Cell
import org.apache.poi.ss.usermodel.CellType
import org.apache.poi.ss.usermodel.Row
import org.apache.poi.xssf.usermodel.XSSFWorkbook
import java.io.OutputStream

class ExcelToPdfConverter(
  private val workbook: XSSFWorkbook
) {

  fun convert(outputStream: OutputStream) {
    val sheetAt = workbook.getSheetAt(0)
    val rowIterator: Iterator<Row> = sheetAt.iterator()
    val itextXls2Pdf = Document()
    val font = FontFactory.getFont("Times New Roman", Charsets.US_ASCII.name())
    PdfWriter.getInstance(itextXls2Pdf, outputStream)
    itextXls2Pdf.open()
    val myTable = PdfPTable(8)
    var tableCell: PdfPCell
    while (rowIterator.hasNext()) {
      val row: Row = rowIterator.next()
      val cellIterator: Iterator<Cell> = row.cellIterator()
      while (cellIterator.hasNext()) {
        val cell: Cell = cellIterator.next()
        when (cell.cellType) {
          CellType.STRING -> {
            tableCell = PdfPCell(Phrase(cell.stringCellValue, font))
            myTable.addCell(tableCell)
          }
        }
      }
    }
    itextXls2Pdf.add(myTable)
    itextXls2Pdf.close()
  }
}
