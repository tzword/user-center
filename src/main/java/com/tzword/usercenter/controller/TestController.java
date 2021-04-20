package com.tzword.usercenter.controller;

import com.tzword.usercenter.annotation.CheckLogin;
import com.tzword.usercenter.dao.user.UserMapper;
import com.tzword.usercenter.domain.entity.user.User;
import com.tzword.usercenter.util.JwtOperator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author jianghy
 * @Description: 测试
 * @date 2021/3/29 16:08
 */
@RestController
@RequestMapping("hi")
@Slf4j
public class TestController {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private JwtOperator jwtOperator;


    @RequestMapping("helloword")
    @CheckLogin
    public List<User> printHello(){
        List<User> users = userMapper.selectAll();
        System.out.println(users.toString());
        return users;
    }

    @GetMapping("getUser/{id}")
    public User getUser(@PathVariable Integer id){
        User user = new User();
        user.setId(id);
        return userMapper.selectOne(user);
    }

    @PostMapping("getUserByPost")
    public List<User> getUserByPost(User user){
        List<User> users = userMapper.select(user);
        System.out.println(users.toString());
        return users;
    }

    @GetMapping("getUserByGet")
    public List<User> getUserByGet(User user){
        List<User> users = userMapper.select(user);
        System.out.println(users.toString());
        return users;
    }

    /**
     * @Description: 登录接口
     * @param  1 
     * @return java.util.Map<java.lang.String,java.lang.Object> 
     * @throws
     * @author jianghy
     * @date 2021/4/19 17:24 
     */
    @PostMapping("/login")
    public Map<String, Object> login(){
        //微信小程序服务端校验是否登录
        Map<String,Object> map = new HashMap<>();
        map.put("aaa","111");
        map.put("bbb","222");
        map.put("ccc","333");
        String token = jwtOperator.generateToken(map);
        log.info("生成的token：{}，有效期是：{}",token,jwtOperator.getExpirationDateFromToken(token));
        Map<String,Object> map2 = new HashMap<>();
        map2.put("token",token);
        map2.put("expire_time",jwtOperator.getExpirationDateFromToken(token));
        return map2;
    }

}
