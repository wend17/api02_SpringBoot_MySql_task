package com.example.demo_api2.Service.Dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TaskInDTO {

    private  String title;
    private  String description;
    private  LocalDateTime eta;
}
