package com.miaskor.todo.spring.controller;

import by.miaskor.rest.connector.TaskConnector;
import by.miaskor.rest.dto.ClientDtoResponse;
import by.miaskor.rest.dto.TaskDtoRequest;
import by.miaskor.rest.dto.TaskDtoResponse;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpSession;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController(value = "taskController")
@RequestMapping("/tasks")
public class TaskController {

  private final TaskConnector taskConnector;
  private final HttpSession httpSession;

  @Autowired
  public TaskController(TaskConnector taskConnector, HttpSession httpSession) {
    this.taskConnector = taskConnector;
    this.httpSession = httpSession;
  }

  @PostMapping("/save")
  public TaskDtoResponse save(@RequestBody TaskDtoRequest task) {
    return taskConnector.create(task);
  }

  @PostMapping("/range")
  public @ResponseBody
  Map<LocalDate, List<TaskDtoResponse>> getAllByClientIdAndDateBetween(@RequestBody DateRange range) {
    int clientId = ((ClientDtoResponse) httpSession.getAttribute("client")).getId();
    return taskConnector.getAllByClientIdAndDateBetween(
        range.getFrom(),
        range.getTo(),
        clientId
    );
  }

  @PutMapping("/update/{id}")
  public TaskDtoResponse update(@PathVariable("id") Integer taskId, @RequestBody TaskDtoRequest task) {
    return taskConnector.update(taskId, task);
  }

  @DeleteMapping("/{id}")
  public void delete(@PathVariable("id") Integer taskId) {
    taskConnector.delete(taskId);
  }

  @Getter
  @Setter
  @Builder
  @FieldDefaults(level = AccessLevel.PRIVATE)
  @NoArgsConstructor
  @AllArgsConstructor
  private static class DateRange {

    String from;
    String to;
  }
}
