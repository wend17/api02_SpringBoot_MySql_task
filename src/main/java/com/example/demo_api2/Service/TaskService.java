package com.example.demo_api2.Service;

import com.example.demo_api2.Exceptions.ToDoExceptions;
import com.example.demo_api2.Mapper.TaskInDTOToTask;
import com.example.demo_api2.Persistence.Entity.Task;
import com.example.demo_api2.Persistence.Entity.TaskStatus;
import com.example.demo_api2.Persistence.Repository.TaskRespository;
import com.example.demo_api2.Service.Dto.TaskInDTO;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    private  final TaskRespository respository;
    private final TaskInDTOToTask mapper;

    public TaskService(TaskRespository respository, TaskInDTOToTask mapper) {
        this.respository = respository;
        this.mapper = mapper;
    }

    /* Crea una tarea , ingresa un DTO y debe salir un Task*/
    public Task createTask(TaskInDTO taskInDTO){
        Task task = mapper.map(taskInDTO);
        return this.respository.save(task);
    }

    public List<Task> findAll(){
        return  this.respository.findAll();
    }

    public List<Task>findAllByTaskStatus(TaskStatus status){
        return this.respository.findAllByTaskStatus(status);
    }

    @Transactional
    public void updateTaskAsFinished(Long id){
        Optional<Task>optionalTask=this.respository.findById(id);
        if(optionalTask.isEmpty()){
            throw new ToDoExceptions("Task not found", HttpStatus.NOT_FOUND);
        }

        this.respository.markTaskAsFinished(id);
    }

    public void deleteById(Long id){
        Optional<Task>optionalTask=this.respository.findById(id);
        if(optionalTask.isEmpty()){
            throw new ToDoExceptions("Task not found", HttpStatus.NOT_FOUND);
        }

        this.respository.deleteById(id);
    }
}
