package com.example.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.entity.TodoEntity;
import com.example.mapper.TodoMapper;
import com.example.service.TodoService;
import org.springframework.stereotype.Service;

@Service
public class TodoServiceImpl extends ServiceImpl<TodoMapper, TodoEntity>
        implements TodoService {
}
