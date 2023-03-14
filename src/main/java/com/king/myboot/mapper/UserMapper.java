package com.king.myboot.mapper;

import com.king.myboot.pojo.Emp;
import com.king.myboot.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {

    /**
     * 添加用户信息
     *
     * @param user
     * @return
     */
    void insertAll(User user);

    /**
     * 用户登录功能
     * @param username
     * @param password
     * @return
     */
    User selectAll(@Param("username") String username, @Param("password") String password);



}
