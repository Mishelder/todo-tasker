package by.miaskor.rest.store.repositories

import by.miaskor.rest.store.entities.ClientEntity
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface ClientRepository : JpaRepository<ClientEntity, Int> {
  fun findByEmailOrLogin(email: String, login: String): Optional<ClientEntity>
  fun findByLogin(login: String): Optional<ClientEntity>
  fun findByEmail(email: String): Optional<ClientEntity>
  fun findByLoginAndPassword(email: String, password: String): Optional<ClientEntity>
}
