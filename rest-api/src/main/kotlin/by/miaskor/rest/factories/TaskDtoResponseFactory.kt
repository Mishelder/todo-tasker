package by.miaskor.rest.factories

import by.miaskor.rest.api.dto.TaskDtoResponse
import by.miaskor.rest.store.entities.TaskEntity
import org.springframework.stereotype.Component

@Component
class TaskDtoResponseFactory {

  fun makeTaskDtoResponse(taskEntity: TaskEntity): TaskDtoResponse {
    return TaskDtoResponse(
      id = taskEntity.id,
      clientId = taskEntity.clientId,
      taskName = taskEntity.taskName,
      date = taskEntity.date,
      done = taskEntity.done,
      taskState = taskEntity.taskState
    )
  }
}
