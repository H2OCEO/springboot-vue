package com.itheima.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.itheima.domain.User;
import com.itheima.mapper.UserMapper;
import com.itheima.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
//    public List<User> getAll(){
//        List<User> userList = userMapper.selectList(null);
//        return userList;
//    }

    @Override
    public User getById(String id) {
        return userMapper.selectById(id);
    }

    @Override
    public int save(User user) {
        return userMapper.insert(user);
    }

    @Override
    public int delete(Integer id) {
        return userMapper.deleteById(id);
    }

    @Override
    public int update(User user) {
        return userMapper.updateById(user);
    }

    @Override
    public Map<String,Object> findByPage(Integer pageNow, Integer size) {
        IPage<User> page = new Page<>(pageNow,size);
        userMapper.selectPage(page,null);
        Map<String, Object> map = new HashMap<>();
        map.put("users",page.getRecords());
        map.put("totals",page.getTotal());
        return map;
    }
}
