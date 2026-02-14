package com.example.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.example.dto.TodoCreateDTO;
import com.example.dto.TodoUpdateDTO;
import com.example.entity.TodoEntity;
import com.example.service.TodoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todos")
public class TodoController {
    @Autowired
    private TodoService todoService;

    /**
     * 获取所有 Todo 列表（支持简单查询）
     */
    @GetMapping("/selectList")
    public ResponseEntity<List<TodoEntity>> selectList(
            @RequestParam(required = false) String title,
            @RequestParam(required = false) Integer completed) {

        LambdaQueryWrapper<TodoEntity> wrapper = Wrappers.lambdaQuery();

        if (title != null && !title.isBlank()) {
            wrapper.like(TodoEntity::getTitle, title);
        }
        if (completed != null) {
            wrapper.eq(TodoEntity::getCompleted, completed);
        }

        wrapper.orderByDesc(TodoEntity::getCreatedAt);

        List<TodoEntity> list = todoService.list(wrapper);
        return ResponseEntity.ok(list);
    }


    /**
     * 获取单个 Todo 详情
     */
    @GetMapping("/getById")
    public ResponseEntity<TodoEntity> getById(@RequestParam("id") Long id) {
        TodoEntity todo = todoService.getById(id);
        if (todo == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(todo);
    }

    /**
     * 新增 Todo
     */
    @PostMapping("/create")
    public ResponseEntity<TodoEntity> create(@RequestBody TodoCreateDTO todoCreateDTO) {
        TodoEntity todoEntity = new TodoEntity();
        BeanUtils.copyProperties(todoCreateDTO, todoEntity);
        // completed 默认 0（未完成）
        if (todoEntity.getCompleted() == null) {
            todoEntity.setCompleted(0);
        }
        boolean save = todoService.save(todoEntity);
        if (!save) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(todoEntity);
    }

    /**
     * 修改 Todo
     */
    @PutMapping("/update")
    public ResponseEntity<TodoEntity> update(@RequestBody TodoUpdateDTO todoUpdateDTO) {
        Long id = todoUpdateDTO.getId();
        TodoEntity todo = todoService.getById(id);
        if (todo == null) {
            return ResponseEntity.notFound().build();
        }

        BeanUtils.copyProperties(todoUpdateDTO, todo);
        todoService.updateById(todo);
        return ResponseEntity.ok(todo);
    }

    /**
     * 删除 Todo
     */
    @DeleteMapping("/deleteById")
    public ResponseEntity<Void> deleteById(@RequestParam("id") Long id) {
        boolean removed = todoService.removeById(id);
        if (!removed) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }
}
