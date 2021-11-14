package by.miaskor.rest.connector

import by.miaskor.rest.dto.ClientDtoRequest
import by.miaskor.rest.dto.ClientDtoResponse
import feign.Headers
import feign.Param
import feign.RequestLine

interface ClientConnector {

  @RequestLine("GET /auth?login={login}&password={password}")
  fun getClientByLoginAndPassword(@Param("login") login: String, @Param("password") password: String): ClientDtoResponse

  @RequestLine("POST")
  @Headers("Content-Type: application/json")
  fun createClient(clientDtoRequest: ClientDtoRequest): ClientDtoResponse
}
