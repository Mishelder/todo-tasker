package by.miaskor.rest.api.controllers

import by.miaskor.rest.api.dto.TaskDtoRequest
import by.miaskor.rest.api.dto.TaskDtoResponse
import by.miaskor.rest.api.exceptions.BadRequestException
import by.miaskor.rest.api.exceptions.NotFoundException
import by.miaskor.rest.factories.TaskDtoResponseFactory
import by.miaskor.rest.store.entities.TaskEntity
import by.miaskor.rest.store.repositories.ClientRepository
import by.miaskor.rest.store.repositories.TaskRepository
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDate
import java.time.format.DateTimeParseException
import kotlin.streams.toList

@RestController
@RequestMapping("/api")
open class TaskController(
  private val taskRepository: TaskRepository,
  private val clientRepository: ClientRepository,
  private val taskDtoResponseFactory: TaskDtoResponseFactory
) {

  @PostMapping(CREATE_TASK)
  fun create(@RequestBody taskDtoRequest: TaskDtoRequest): ResponseEntity<TaskDtoResponse> {
    if (taskDtoRequest.taskName.trim().isEmpty()) {
      throw BadRequestException("Task name can't be empty")
    }
    clientRepository.findById(taskDtoRequest.clientId)
      .orElseThrow { NotFoundException("Client with id = ${taskDtoRequest.clientId} doesn't exists") }
    val taskEntity = taskRepository.saveAndFlush(
      TaskEntity(
        clientId = taskDtoRequest.clientId,
        taskName = taskDtoRequest.taskName,
        done = taskDtoRequest.done,
        date = taskDtoRequest.date,
        taskState = taskDtoRequest.taskState
      )
    )
    return ResponseEntity.ok(taskDtoResponseFactory.makeTaskDtoResponse(taskEntity))
  }

  @PatchMapping(UPDATE_TASK)
  fun update(@PathVariable("id") taskId: Int, @RequestBody taskDtoRequest: TaskDtoRequest)
      : ResponseEntity<TaskDtoResponse> {
    if (taskDtoRequest.taskName.trim().isEmpty()) {
      throw BadRequestException("Task name can't be empty")
    }
    clientRepository.findById(taskDtoRequest.clientId)
      .orElseThrow { NotFoundException("Client with id = ${taskDtoRequest.clientId} doesn't exists") }
    taskRepository.findByIdAndClientId(taskId, taskDtoRequest.clientId)
      .orElseThrow { NotFoundException("Task with id = $taskId doesn't exists") }
    val taskEntity = taskRepository.saveAndFlush(
      TaskEntity(
        id = taskId,
        clientId = taskDtoRequest.clientId,
        taskName = taskDtoRequest.taskName,
        done = taskDtoRequest.done,
        date = taskDtoRequest.date,
        taskState = taskDtoRequest.taskState
      )
    )
    return ResponseEntity.ok(taskDtoResponseFactory.makeTaskDtoResponse(taskEntity))
  }

  @GetMapping(GET_ALL_BY_CLIENT_ID_IN_RANGE)
  fun getAllByClientIdAndDateBetween(
    @RequestParam("client_id") clientId: Int,
    @RequestParam("date_from") dateFrom: String,
    @RequestParam("date_to") dateTo: String
  ): ResponseEntity<Map<LocalDate, List<TaskEntity>>> {
    var parseDateFrom: LocalDate
    val parseDateTo: LocalDate
    try {
      parseDateFrom = LocalDate.parse(dateFrom)
      try {
        parseDateTo = LocalDate.parse(dateTo)
      } catch (ex: DateTimeParseException) {
        throw BadRequestException("DateTo = $dateTo can't be parsed, bad format")
      }
      if (dateFrom > dateTo) {
        throw BadRequestException("DateFrom = $dateFrom is bigger than DateTo = $dateTo")
      }
    } catch (ex: DateTimeParseException) {
      throw BadRequestException("DateFrom = $dateFrom can't be parsed, bad format")
    }
    val taskList =
      taskRepository.findByDateBetweenAndClientId(parseDateFrom, parseDateTo, clientId)
    val mapTasks = taskList.associate { it1 ->
      Pair(it1.date, taskList.stream().filter { it.date == it1.date }.toList())
    }
    return ResponseEntity.ok(mapTasks)
  }

  @GetMapping(GET_ALL_BY_CLIENT_ID_AND_DATE)
  fun getAllByClientIdAndDate(@RequestParam("client_id") clientId: Int, @RequestParam date: String):
      ResponseEntity<List<TaskEntity>> {
    val parseDate: LocalDate
    try {
      parseDate = LocalDate.parse(date)
    } catch (ex: DateTimeParseException) {
      throw BadRequestException("DateTo = $date can't be parsed, bad format")
    }
    clientRepository.findById(clientId)
      .orElseThrow { NotFoundException("Client with id = $clientId doesn't exists") }
    return ResponseEntity.ok(
      taskRepository.findByDateAndClientId(parseDate, clientId)
    )
  }

  @DeleteMapping(DELETE_TASK)
  fun delete(@PathVariable("id") taskId: Int) {
    taskRepository.findById(taskId)
      .orElseThrow { NotFoundException("Task with id $taskId doesn't not exists") }
    taskRepository.deleteById(taskId)
  }

  companion object {
    private const val CREATE_TASK = "/tasks"
    private const val UPDATE_TASK = "/tasks/{id}"
    private const val DELETE_TASK = "/tasks/{id}"
    private const val GET_ALL_BY_CLIENT_ID_IN_RANGE = "/tasks/range"
    private const val GET_ALL_BY_CLIENT_ID_AND_DATE = "/tasks/date"
  }
}
