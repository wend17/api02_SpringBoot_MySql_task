package com.example.demo_api2.Mapper;

import com.example.demo_api2.Persistence.Entity.Task;
import com.example.demo_api2.Persistence.Entity.TaskStatus;
import com.example.demo_api2.Service.Dto.TaskInDTO;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class TaskInDTOToTask implements  IMapper<TaskInDTO, Task>{
    @Override
    public Task map(TaskInDTO input) {
        Task task = new Task();
        task.setTitle(input.getTitle());
        task.setDescription(input.getDescription());
        task.setEta(input.getEta());
        task.setCreatedDaate(LocalDateTime.now()); // lo creo automatico
        task.setFinished(false); // le digo que no está finalizado
        task.setTaskStatus(TaskStatus. ON_TIME); // lo pongo por defecto
        task.setEta(LocalDateTime.now()); // lo pongo por defecto, está arriba
        return task;
    }
}
