package by.miaskor.rest.api.dto

import by.miaskor.rest.store.entities.TaskState
import java.time.LocalDate

class TaskDtoRequest(
  val clientId: Int,
  val done: Boolean,
  val date: LocalDate,
  val taskName: String,
  val taskState: TaskState
)
