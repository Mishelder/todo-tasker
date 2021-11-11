package by.miaskor.rest.api.controllers

import by.miaskor.rest.api.dto.ClientDtoRequest
import by.miaskor.rest.api.dto.ClientDtoResponse
import by.miaskor.rest.api.exceptions.BadRequestException
import by.miaskor.rest.api.exceptions.NotFoundException
import by.miaskor.rest.factories.ClientDtoResponseFactory
import by.miaskor.rest.store.entities.ClientEntity
import by.miaskor.rest.store.repositories.ClientRepository
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
@RequestMapping("/api")
open class ClientController(
  private val clientRepository: ClientRepository,
  private val clientDtoResponseFactory: ClientDtoResponseFactory
) {

  @PostMapping(CREATE_CLIENT)
  fun createClient(@RequestBody clientDtoRequest: ClientDtoRequest): ResponseEntity<ClientDtoResponse> {
    checkValueBlank("Login", clientDtoRequest.login)
    checkValueBlank("Password", clientDtoRequest.password)
    checkValueBlank("Email", clientDtoRequest.email)

    clientRepository.findByEmailOrLogin(clientDtoRequest.email, clientDtoRequest.login)
      .ifPresent {
        throw BadRequestException(
          "Client with email = ${clientDtoRequest.email} or login = ${
            clientDtoRequest.login
          } already exists"
        )
      }
    val clientEntity = clientRepository.saveAndFlush(
      ClientEntity(
        email = clientDtoRequest.email,
        login = clientDtoRequest.login,
        password = clientDtoRequest.password
      )
    )
    return ResponseEntity.ok(clientDtoResponseFactory.makeClientDtoResponse(clientEntity))
  }

  @GetMapping(GET_CLIENT)
  fun getClient(@PathVariable id: Int): ResponseEntity<ClientEntity> {
    return ResponseEntity.ok(clientRepository.findById(id)
      .orElseThrow { NotFoundException("Client with id $id not exists") })
  }

  @GetMapping(GET_CLIENT_BY_LOGIN_OR_EMAIL)
  fun getClientByLoginOrEmail(
    @RequestParam("login") login: Optional<String>, @RequestParam("email") email:
    Optional<String>
  ):
      ResponseEntity<ClientEntity> {
    var clientEntity: ClientEntity? = null
    login.ifPresent {
      checkValueBlank("Login", it)
      clientEntity = clientRepository.findByLogin(it)
        .orElseThrow { NotFoundException("Client with login $it not exists") }
    }
    if (clientEntity != null) {
      return ResponseEntity.ok(clientEntity)
    }
    email.ifPresent {
      checkValueBlank("Email", it)
      clientEntity = clientRepository.findByEmail(it)
        .orElseThrow { NotFoundException("Client with email $it not exists") }
    }
    return ResponseEntity.ok(clientEntity ?: ClientEntity())
  }

  @GetMapping(GET_CLIENT_BY_LOGIN_AND_PASSWORD)
  fun getClientByLoginAndPassword(@RequestParam("login") login: String, @RequestParam("password") password: String):
      ResponseEntity<ClientEntity> {
    checkValueBlank("Login", login)
    checkValueBlank("Password", password)
    clientRepository.findByLogin(login)
      .orElseThrow { NotFoundException("Client with login $login not exists") }
    return ResponseEntity.ok(
      clientRepository.findByLoginAndPassword(login, password)
        .orElseThrow { NotFoundException("Client with login $login and password $password not exists") })
  }

  @DeleteMapping(DELETE_CLIENT)
  fun delete(@PathVariable("id") clientId: Int) {
    clientRepository.findById(clientId)
      .orElseThrow { NotFoundException("Client with id $clientId not exists") }
    clientRepository.deleteById(clientId)
  }

  private fun checkValueBlank(nameField: String, field: String) {
    if (field.trim().isBlank()) {
      throw BadRequestException("$nameField $field is can not be empty")
    }
  }

  companion object {
    private const val CREATE_CLIENT = "/clients"
    private const val GET_CLIENT = "/clients/{id}"
    private const val DELETE_CLIENT = "/clients/{id}"
    private const val GET_CLIENT_BY_LOGIN_OR_EMAIL = "/clients"
    private const val GET_CLIENT_BY_LOGIN_AND_PASSWORD = "/clients/auth"
  }
}
