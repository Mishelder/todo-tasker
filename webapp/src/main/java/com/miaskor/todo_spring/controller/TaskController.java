package com.miaskor.todo_spring.controller;

import by.miaskor.domain.rest.api.ClientResponseDto;
import by.miaskor.domain.rest.api.DateRange;
import by.miaskor.domain.rest.api.TaskRequestDto;
import by.miaskor.domain.rest.api.TaskResponseDto;
import com.miaskor.todo_spring.connectors.rest.api.TaskConnector;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController(value = "taskJsController")
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
  public TaskResponseDto save(@RequestBody TaskRequestDto task) {
    Integer clientId = ((ClientResponseDto) httpSession.getAttribute("client")).getId();
    task.setClientId(clientId);
    return taskConnector.create(task);
  }

  @PostMapping("/range")
  public @ResponseBody
  Map<LocalDate, List<TaskResponseDto>> getAllByClientIdAndDateBetween(@RequestBody DateRange range) {
    Integer clientId = ((ClientResponseDto) httpSession.getAttribute("client")).getId();
    return taskConnector.getAllByClientIdAndDateBetween(
        range.getFrom().toString(),
        range.getTo().toString(),
        clientId
    );
  }

  @PutMapping("/update/{id}")
  public TaskResponseDto update(@PathVariable("id") Integer taskId, @RequestBody TaskRequestDto task) {
    return taskConnector.update(taskId, task);
  }

  @DeleteMapping("/{id}")
  public void delete(@PathVariable("id") Integer taskId) {
    taskConnector.delete(taskId);
  }
}
