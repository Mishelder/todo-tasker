package by.miaskor.rest.store.entities

import java.time.LocalDate
import javax.persistence.Entity
import javax.persistence.EnumType
import javax.persistence.Enumerated
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "task")
data class TaskEntity(
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  val id: Int = -1,
  val clientId: Int = -1,
  val date: LocalDate = LocalDate.now(),
  val done: Boolean = false,
  val taskName: String = "",
  @Enumerated(EnumType.STRING)
  val taskState: TaskState = TaskState.UPCOMING
)
