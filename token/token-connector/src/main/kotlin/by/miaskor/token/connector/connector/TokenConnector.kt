package by.miaskor.token.connector.connector

import by.miaskor.token.connector.domain.ClientAuthDtoRequest
import feign.Headers
import feign.Param
import feign.RequestLine

@Headers(value = ["Content-type: application/json"])
interface TokenConnector {

  @RequestLine("POST /create/token")
  fun createToken(clientAuthDtoRequest: ClientAuthDtoRequest): Map<String, String>

  @RequestLine("POST /validate/token/{accessToken}")
  fun validateToken(@Param accessToken: String): Boolean
}
