package by.miaskor.rest.connector

import by.miaskor.rest.dto.TaskDtoRequest
import by.miaskor.rest.dto.TaskDtoResponse
import feign.Headers
import feign.Param
import feign.RequestLine
import java.time.LocalDate

interface TaskConnector {

  @RequestLine("POST")
  @Headers("Content-type: application/json")
  fun create(task: TaskDtoRequest): TaskDtoResponse

  @RequestLine("GET /range?date_from={date_from}&date_to={date_to}&client_id={client_id}")
  @Headers("Content-type: application/json")
  fun getAllByClientIdAndDateBetween(
    @Param("date_from") dateFrom: String,
    @Param("date_to") dateTo: String,
    @Param("client_id") clientId: Int
  ): Map<LocalDate, List<TaskDtoResponse>>

  @RequestLine("GET /date?date={date}&client_id{client_id}")
  @Headers("Content-type: application/json")
  fun getAllByClientIdAndDate(
    @Param("date") date: String,
    @Param("client_id") clientId: Int
  ): List<TaskDtoResponse>

  @RequestLine("PATCH /{id}")
  @Headers("Content-type: application/json")
  fun update(@Param("id") taskId: Int, task: TaskDtoRequest): TaskDtoResponse

  @RequestLine("DELETE /{id}")
  @Headers("Content-type: application/json")
  fun delete(@Param("id") taskId: Int)
}
