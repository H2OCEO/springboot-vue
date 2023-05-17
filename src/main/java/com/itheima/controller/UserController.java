package com.itheima.controller;


import com.itheima.domain.User;
import com.itheima.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/users")
@CrossOrigin
public class UserController {
    @Autowired
   private UserService userService;
    //    查全部
//    @GetMapping()
//    public Result getAll(){
//        List<User> userList = userService.getAll();
//        Integer status = userList != null ? Status.GET_SUCCESS : Status.GET_ERR;
//        String msg = userList != null ? "查询成功" : "查询失败";
//        return new Result(status,msg,userList);
//    }
    @GetMapping("/findByPage")
    public Map<String,Object> findByPage(Integer pageNow,Integer size){
        System.out.println(pageNow);
        System.out.println(size);
        pageNow = pageNow == null ? 1 : pageNow;
        size = size == null ? 2 : size;
        Map<String, Object> pageMap = userService.findByPage(pageNow, size);
        return pageMap;
    }

    @PostMapping
    public Result save(@RequestBody User user){
        int num = userService.save(user);
        Integer status = num > 0 ? Status.SAVE_SUCCESS : Status.SAVE_ERR;
        return new Result(status);
    }

    @GetMapping("/delete")
    public Result delete(Integer id){
        int num = userService.delete(id);
        Integer status = num > 0 ? Status.DELETE_SUCCESS : Status.DELETE_SUCCESS;
        return new Result(status);
    }

    @PostMapping("/update")
    public Result update(@RequestBody User user){
        int num = userService.update(user);
        Integer status = num > 0 ? Status.UPDATE_SUCCESS : Status.UPDATE_SUCCESS;
        return new Result(status);
    }

    @GetMapping("/getbyid")
    public Result getById(String id){
        User user = userService.getById(id);
        Integer status = user != null ? Status.GET_SUCCESS : Status.GET_ERR;
        String msg = user != null ? "查询成功" : "查询失败";
        return new Result(status,msg,user);
    }
}
