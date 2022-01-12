package by.miaskor.report

class ReportRegistry(
  private val mapReports: Map<ReportType, Report>
) {

  fun lookUp(reportType: ReportType): Report {
    return mapReports[reportType] ?: throw IllegalArgumentException("Report $reportType is not exist")
  }
}
