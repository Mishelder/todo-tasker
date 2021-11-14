package by.miaskor.rest.dto

import java.time.LocalDate

class TaskDtoRequest(
  val clientId: Int,
  val done: Boolean,
  val date: LocalDate,
  val taskName: String,
  val taskState: TaskState
)
