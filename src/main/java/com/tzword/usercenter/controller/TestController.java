package com.tzword.usercenter.controller;

import com.tzword.usercenter.dao.user.UserMapper;
import com.tzword.usercenter.domain.entity.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author jianghy
 * @Description: 测试
 * @date 2021/3/29 16:08
 */
@RestController
@RequestMapping("hi")
public class TestController {
    @Autowired
    private UserMapper userMapper;


    @RequestMapping("helloword")
    public List<User> printHello(){
        List<User> users = userMapper.selectAll();
        System.out.println(users.toString());
        return users;
    }

}
