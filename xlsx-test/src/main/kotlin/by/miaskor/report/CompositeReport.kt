package by.miaskor.report

class CompositeReport(
  private vararg val reports: Report
) {

  fun createReport() {
    reports.forEach { it.createReport() }
  }
}
