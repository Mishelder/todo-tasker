package by.miaskor.token

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
open class JwtApplication

fun main(args: Array<String>) {
  runApplication<JwtApplication>(*args)
}
