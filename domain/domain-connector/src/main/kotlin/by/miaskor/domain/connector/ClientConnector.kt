package by.miaskor.domain.connector

import by.miaskor.domain.dto.ClientDtoRequest
import by.miaskor.domain.dto.ClientDtoResponse
import feign.Headers
import feign.Param
import feign.RequestLine

@Headers(value = ["Content-type: application/json"])
interface ClientConnector {

  @RequestLine("GET /auth?login={login}&password={password}")
  fun getClientByLoginAndPassword(@Param("login") login: String, @Param("password") password: String):
      ClientDtoResponse

  @RequestLine("GET ?login={login}")
  fun getClientByLogin(@Param("login") login: String): ClientDtoResponse

  @RequestLine("POST /")
  fun createClient(clientDtoRequest: ClientDtoRequest): ClientDtoResponse
}
