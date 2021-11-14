package by.miaskor.rest.factories

import by.miaskor.rest.dto.ClientDtoResponse
import by.miaskor.rest.store.entities.ClientEntity
import org.springframework.stereotype.Component

@Component
class ClientDtoResponseFactory {

  fun makeClientDtoResponse(clientEntity: ClientEntity): ClientDtoResponse {
    return ClientDtoResponse(
      id = clientEntity.id,
      email = clientEntity.email,
      login = clientEntity.login,
      password = clientEntity.password
    )
  }
}
