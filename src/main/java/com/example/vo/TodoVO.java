package com.example.vo;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TodoVO {
    private Long id;
    private String title;
    private String description;
    private Integer completed;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
