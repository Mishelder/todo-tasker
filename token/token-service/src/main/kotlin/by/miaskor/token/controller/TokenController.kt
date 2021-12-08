package by.miaskor.token.controller

import by.miaskor.domain.connector.ClientConnector
import by.miaskor.token.connector.domain.ClientAuthDtoRequest
import by.miaskor.token.security.jwt.JwtTokenProvider
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class TokenController(
  private val jwtTokenProvider: JwtTokenProvider,
  private val clientConnector: ClientConnector
) {
  @PostMapping("/create/token")
  fun createToken(@RequestBody clientAuthDtoRequest: ClientAuthDtoRequest): ResponseEntity<Map<String, String>> {
    val client = clientConnector.getClientByLoginAndPassword(
      clientAuthDtoRequest.login,
      clientAuthDtoRequest.password
    )
    val accessToken = jwtTokenProvider.createToken(clientAuthDtoRequest)
    return ResponseEntity.ok(
      mapOf(
        Pair("name", clientAuthDtoRequest.login),
        Pair("token", accessToken),
        Pair("clientId", client.id.toString())
      )
    )
  }

  @PostMapping("/validate/token/{accessToken}")
  fun validateToken(@PathVariable accessToken: String): ResponseEntity<Boolean> {
    jwtTokenProvider.getAuthentication(accessToken)
    return if (jwtTokenProvider.validateToken(accessToken)) {
      ResponseEntity.ok(true)
    } else {
      ResponseEntity.status(HttpStatus.FORBIDDEN).build()
    }
  }
}
