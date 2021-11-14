package by.miaskor.rest.dto

import java.time.LocalDate

class TaskDtoResponse(
  val id: Int,
  val clientId: Int,
  val done: Boolean,
  val taskName: String,
  val date: LocalDate,
  val taskState: TaskState
)
