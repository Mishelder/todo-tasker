package by.miaskor.domain.connector

import by.miaskor.domain.dto.ClientDtoRequest
import by.miaskor.domain.dto.ClientDtoResponse
import feign.Headers
import feign.Param
import feign.RequestLine

interface ClientConnector {

  @RequestLine("GET /auth?login={login}&password={password}")
  @Headers("Content-Type: application/json")
  fun getClientByLoginAndPassword(@Param("login") login: String, @Param("password") password: String):
      ClientDtoResponse?

  @RequestLine("GET ?login={login}")
  @Headers("Content-Type: application/json")
  fun getClientByLogin(@Param("login") login: String): ClientDtoResponse?

  @RequestLine("POST /")
  @Headers("Content-Type: application/json")
  fun createClient(clientDtoRequest: ClientDtoRequest): ClientDtoResponse?
}
