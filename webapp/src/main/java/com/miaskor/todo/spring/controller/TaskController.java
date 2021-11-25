package com.miaskor.todo.spring.controller;

import by.miaskor.domain.connector.TaskConnector;
import by.miaskor.domain.dto.ClientDtoResponse;
import by.miaskor.domain.dto.TaskDtoRequest;
import by.miaskor.domain.dto.TaskDtoResponse;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

  @GetMapping("/range")
  public Map<String, List<TaskDtoResponse>> getAllByClientIdAndDateBetween(
      @RequestParam("date_from") String dateFrom,
      @RequestParam("date_to") String dateTo) {
    int clientId = ((ClientDtoResponse) httpSession.getAttribute("client")).getId();
    return taskConnector.getAllByClientIdAndDateBetween(
        dateFrom,
        dateTo,
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
}
