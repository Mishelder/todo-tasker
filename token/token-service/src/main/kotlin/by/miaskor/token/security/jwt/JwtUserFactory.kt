package by.miaskor.token.security.jwt

import by.miaskor.domain.dto.ClientDtoResponse

class JwtUserFactory {

  fun create(clientDtoResponse: ClientDtoResponse): JwtUser {
    return JwtUser(
      id = clientDtoResponse.id,
      login = clientDtoResponse.login,
      email = clientDtoResponse.email,
      user_password = clientDtoResponse.password
    )
  }
}
