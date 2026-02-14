package com.example.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.entity.TodoEntity;

/**
 * Todo 业务接口
 */
public interface TodoService extends IService<TodoEntity> {

    // 如果需要自定义方法，可以在这里声明
    // 例如：List<TodoEntity> findByTitleLike(String title);
}
