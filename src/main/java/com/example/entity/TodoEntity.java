package com.example.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TableName("todos")
public class TodoEntity {
    @TableId(type = IdType.AUTO)
    private Long id;

    private String title;

    private String description;

    private Boolean completed = false;

    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createdAt;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updatedAt;

    // 如果要用逻辑删除，可加
    // @TableLogic
    // private Integer deleted = 0;
}
