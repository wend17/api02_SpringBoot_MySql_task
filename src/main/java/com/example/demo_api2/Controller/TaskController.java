package com.example.demo_api2.Controller;

import com.example.demo_api2.Persistence.Entity.Task;
import com.example.demo_api2.Persistence.Entity.TaskStatus;
import com.example.demo_api2.Service.Dto.TaskInDTO;
import com.example.demo_api2.Service.TaskService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    private  final TaskService taskService;
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping
    public Task createTask (@RequestBody TaskInDTO taskInDTO){
     return this.taskService.createTask(taskInDTO);
    }

    @GetMapping
    public List<Task>findAll(){
        return  this.taskService.findAll();
    }

    /*obtener tareas por estado*/
    @GetMapping(value = "/status/{status}")
    public List<Task>findAllbyStatus(@PathVariable("status") TaskStatus status){
        return this.taskService.findAllByTaskStatus(status);
    }

    /*
    Marcar una tarea como cumplida
    */
     @PatchMapping("/mark_as_finished/{id}")
    public ResponseEntity<Void> markAsFinished(@PathVariable("id") Long id){
        this.taskService.updateTaskAsFinished(id);
        return ResponseEntity.noContent().build(); // para que retorne al 204
     }

     @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id){
        this.taskService.deleteById(id);
        return ResponseEntity.noContent().build();
    }


}
