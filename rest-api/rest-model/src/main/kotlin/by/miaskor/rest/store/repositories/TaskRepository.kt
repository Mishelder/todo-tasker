package by.miaskor.rest.store.repositories

import by.miaskor.rest.store.entities.TaskEntity
import org.springframework.data.jpa.repository.JpaRepository
import java.time.LocalDate
import java.util.*

interface TaskRepository : JpaRepository<TaskEntity, Int> {
  fun findByIdAndClientId(id: Int, clientId: Int): Optional<TaskEntity>
  fun findByDateBetweenAndClientId(dateFrom: LocalDate, dateTo: LocalDate, clientId: Int): List<TaskEntity>
  fun findByDateAndClientId(date: LocalDate, clientId: Int): List<TaskEntity>
}
