package com.king.myboot.service.impl;

import com.king.myboot.mapper.UserMapper;
import com.king.myboot.pojo.User;
import com.king.myboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public void insertAll(User user) {
        //设置主键
        user.setId(UUID.randomUUID().toString());
        // 把数据传入进去
        userMapper.insertAll(user);
    }

    @Override
    public User selectAll(String username, String password) {
        return userMapper.selectAll(username,password);
    }
}
