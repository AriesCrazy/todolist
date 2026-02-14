package com.example.dto;

import lombok.Data;

@Data
public class TodoQueryDTO {
    /**
     * 标题模糊查询
     */
    private String title;

    /**
     * 完成状态：0-未完成，1-已完成，null-全部
     */
    private Integer completed;

    /**
     * 当前页码（分页用，可选）
     */
    private Integer page = 1;

    /**
     * 每页条数（分页用，可选）
     */
    private Integer size = 10;
}
