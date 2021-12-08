package by.miaskor.token.config

import by.miaskor.domain.connector.ClientConnector
import by.miaskor.token.security.JwtUserDetailsService
import by.miaskor.token.security.jwt.JwtTokenProvider
import by.miaskor.token.security.jwt.JwtUserFactory
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder

@Configuration
open class SecurityConfig(
  private val clientConnector: ClientConnector
) : WebSecurityConfigurerAdapter() {

  @Bean
  override fun authenticationManagerBean(): AuthenticationManager {
    return super.authenticationManagerBean()
  }

  override fun configure(auth: AuthenticationManagerBuilder) {
    auth.userDetailsService(jwtUserDetailsService()).passwordEncoder(bCryptPasswordEncoder())
  }

  @Bean
  open fun bCryptPasswordEncoder(): BCryptPasswordEncoder {
    return BCryptPasswordEncoder()
  }

  @Bean
  open fun jwtUserFactory(): JwtUserFactory {
    return JwtUserFactory()
  }

  @Bean
  open fun jwtUserDetailsService(): JwtUserDetailsService {
    return JwtUserDetailsService(clientConnector, jwtUserFactory())
  }

  @Bean
  open fun jwtTokenProvider(): JwtTokenProvider {
    return JwtTokenProvider(jwtUserDetailsService())
  }

  override fun configure(http: HttpSecurity) {
    http
      .httpBasic().disable()
      .csrf().disable()
      .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
      .and()
      .authorizeRequests().anyRequest().permitAll()
  }
}
