package com.example.dto;

import lombok.Data;

@Data
public class TodoUpdateDTO {

    private Long id;

    private String title;

    private String description;

    private Integer completed;
}
