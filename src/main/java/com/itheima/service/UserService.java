package com.itheima.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.itheima.domain.User;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

public interface UserService {
//    public List<User> getAll();
    public User getById(String id);
    public int save(User user);
    public int delete(Integer id);
    public int update(User user);
    Map<String,Object> findByPage(Integer start, Integer size);
}
