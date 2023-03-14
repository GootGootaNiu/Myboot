package com.king.myboot.service;

import com.king.myboot.pojo.User;

public interface UserService {
    /**
     * 添加用户信息
     * @param user
     * @return
     */
    void insertAll(User user);

    /**
     * 根据条件查询用户信息
     * @param username
     * @param password
     * @return
     */
    User selectAll(String username,String password);
}
