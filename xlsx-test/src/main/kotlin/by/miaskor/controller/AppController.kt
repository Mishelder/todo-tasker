package by.miaskor.controller

import by.miaskor.service.ExcelService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.servlet.http.HttpServletResponse

@RestController
@RequestMapping("/dev")
class AppController(
  private val service: ExcelService
) {

  @GetMapping("/excel", produces = ["application/vnd.ms-excel"])
  fun loadExcel(response: HttpServletResponse) {
    response.setHeader("Content-disposition", "attachment;filename=\"123.xlsx\"")
    service.getExcelFile(response.outputStream)
  }

  @GetMapping("/pdf", produces = ["application/vnd.ms-excel"])
  fun loadPdf(response: HttpServletResponse) {
    response.setHeader("Content-disposition", "attachment;filename=\"123.pdf\"")
    service.getPdfFile(response.outputStream)
  }
}
