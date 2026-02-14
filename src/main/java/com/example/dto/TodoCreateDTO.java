package com.example.dto;

import lombok.Data;

@Data
public class TodoCreateDTO {

    private String title;

    private String description;

    private Integer completed;
}
