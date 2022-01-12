package by.miaskor.controller

import by.miaskor.service.ReportService
import org.springframework.core.io.InputStreamResource
import org.springframework.http.HttpHeaders
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/dev")
class AppController(
  private val service: ReportService
) {

  @GetMapping("/excel/{type}")
  fun loadExcel(@PathVariable("type") type: String): ResponseEntity<InputStreamResource>? {
    val inputStream = service.createExcel(type)
    return ResponseEntity.ok()
      .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=$type.xlsx")
      .contentType(MediaType.APPLICATION_OCTET_STREAM)
      .body(InputStreamResource(inputStream))
  }
}
