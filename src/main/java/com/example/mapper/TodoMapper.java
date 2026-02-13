package com.example.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.entity.TodoEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TodoMapper extends BaseMapper<TodoEntity> {
    // 继承 BaseMapper 后，自动获得 insert、selectById、updateById、deleteById 等方法
    // 后面我们再加自定义方法
}
