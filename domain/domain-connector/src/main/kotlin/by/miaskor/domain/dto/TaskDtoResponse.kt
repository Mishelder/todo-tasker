package by.miaskor.domain.dto

data class TaskDtoResponse(
  val id: Int = 0,
  val done: Boolean = false,
  val taskName: String = "",
  val taskState: TaskState = TaskState.UPCOMING
)
