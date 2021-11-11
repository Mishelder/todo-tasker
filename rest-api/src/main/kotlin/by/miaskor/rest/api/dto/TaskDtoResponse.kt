package by.miaskor.rest.api.dto

import by.miaskor.rest.store.entities.TaskState
import java.time.LocalDate

class TaskDtoResponse(
  val id: Int,
  val clientId: Int,
  val done: Boolean,
  val taskName: String,
  val date: LocalDate,
  val taskState: TaskState
)
