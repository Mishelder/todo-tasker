package by.miaskor.generator

import by.miaskor.report.ReportType
import by.miaskor.style.sheet.CompositeSheetModifier
import org.apache.poi.xssf.usermodel.XSSFCellStyle
import org.apache.poi.xssf.usermodel.XSSFWorkbook
import java.io.OutputStream

class ExcelGenerator(
  private val compositeSheetModifier: CompositeSheetModifier,
  private val workbook: XSSFWorkbook
) {
  private val sheets = namesSheet.associateWith { name -> workbook.createSheet(name) }

  fun row(sheetName: String, numRow: Int = 0, cellValues: List<String>, cellStyle: XSSFCellStyle):
      ExcelGenerator {
    val sheetModifier = compositeSheetModifier.resolveBy(sheetName)
    val sheet = sheets[sheetName]
    val row = sheet!!.createRow(numRow)
    sheetModifier.modifyColumn(sheet)
    sheetModifier.modifyRow(row)
    cellValues.forEachIndexed { index, value ->
      val cell = row.createCell(index)
      cell.setCellValue(value)
      cell.cellStyle = cellStyle
    }
    return this
  }

  fun cells(sheetName: String, numRow: Int = 0, cellValues: Map<Int, List<String>>, cellStyle: XSSFCellStyle):
      ExcelGenerator {
    cellValues.map { entry ->
      val row = sheets[sheetName]!!.createRow(entry.key + numRow)
      entry.value.forEachIndexed { index, value ->
        val cell = row.createCell(index)
        row.createCell(index).setCellValue(value)
        cell.cellStyle = cellStyle
      }
    }
    return this
  }

  fun writeXlsx(outputStream: OutputStream) {
    workbook.write(outputStream)
  }

  private companion object {
    private val namesSheet = ReportType.values().map { it.sheetName }.distinct()
  }
}


