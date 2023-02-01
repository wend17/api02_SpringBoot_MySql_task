package com.example.demo_api2.Persistence.Repository;

import com.example.demo_api2.Persistence.Entity.Task;
import com.example.demo_api2.Persistence.Entity.TaskStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TaskRespository extends JpaRepository <Task,Long> {
    public List<Task> findAllByTaskStatus(TaskStatus status);

    @Modifying
    @Query(value = "update Task set finished = true where id =:id") // el finished atributo coincide con la tabla
    /*@Query(value = "update demoapi2 set finished = true where id =:id",nativeQuery = true)*/

    public  void markTaskAsFinished(@Param("id") Long id);
}
