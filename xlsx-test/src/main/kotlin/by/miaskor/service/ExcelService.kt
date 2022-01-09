package by.miaskor.service

import by.miaskor.generator.ExcelGenerator
import by.miaskor.generator.ExcelToPdfConverter
import by.miaskor.report.CompositeReport
import org.springframework.stereotype.Service
import java.io.OutputStream

@Service
class ExcelService(
  private val compositeReport: CompositeReport,
  private val excelGenerator: ExcelGenerator,
  private val excelToPdfConverter: ExcelToPdfConverter
) {

  fun getExcelFile(outputStream: OutputStream) {
    compositeReport.createReport()
    excelGenerator.writeXlsx(outputStream)
  }

  fun getPdfFile(outputStream: OutputStream) {
    compositeReport.createReport()
    excelToPdfConverter.convert(outputStream)
  }
}
