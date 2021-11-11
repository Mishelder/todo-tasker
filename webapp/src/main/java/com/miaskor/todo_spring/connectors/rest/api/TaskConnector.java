package com.miaskor.todo_spring.connectors.rest.api;

import by.miaskor.domain.rest.api.TaskRequestDto;
import by.miaskor.domain.rest.api.TaskResponseDto;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "rest-api-task", url = "${connector.rest-api.url}")
public interface TaskConnector {

  @RequestMapping(value = "/tasks", method = RequestMethod.POST)
  TaskResponseDto create(@RequestBody TaskRequestDto task);

  @RequestMapping(value = "/tasks/range", method = RequestMethod.GET)
  Map<LocalDate, List<TaskResponseDto>> getAllByClientIdAndDateBetween(
      @RequestParam("date_from") String dateFrom,
      @RequestParam("date_to") String dateTo,
      @RequestParam("client_id") Integer clientId);

  @RequestMapping(value = "/tasks/date", method = RequestMethod.GET)
  List<TaskResponseDto> getAllByClientIdAndDate(
      @RequestParam String date,
      @RequestParam("client_id") Integer clientId);

  @RequestMapping(value = "/tasks/{id}", method = RequestMethod.PATCH)
  TaskResponseDto update(@PathVariable("id") Integer taskId, @RequestBody TaskRequestDto task);

  @RequestMapping(value = "/tasks/{id}", method = RequestMethod.DELETE)
  void delete(@PathVariable("id") Integer taskId);
}
