package by.miaskor

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
open class ExcelGeneratorApp

fun main(args: Array<String>) {
  runApplication<ExcelGeneratorApp>(*args)
}
