package by.miaskor.service

import by.miaskor.report.ReportRegistry
import by.miaskor.report.ReportType
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.io.InputStream

class ReportService(
  private val reportRegistry: ReportRegistry
) {

  fun createExcel(type: String): InputStream {
    val outputStream = ByteArrayOutputStream()
    reportRegistry.lookUp(ReportType.valueOf(type)).createReport().write(outputStream)
    return ByteArrayInputStream(outputStream.toByteArray())
  }
}
