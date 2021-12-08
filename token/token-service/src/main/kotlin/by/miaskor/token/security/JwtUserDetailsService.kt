package by.miaskor.token.security

import by.miaskor.domain.connector.ClientConnector
import by.miaskor.token.security.jwt.JwtUserFactory
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService

class JwtUserDetailsService(
  private val clientConnector: ClientConnector,
  private val jwtUserFactory: JwtUserFactory
) : UserDetailsService {

  override fun loadUserByUsername(login: String): UserDetails {
    val client = clientConnector.getClientByLogin(login)
    return jwtUserFactory.create(client)
  }
}
