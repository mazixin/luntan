package com.fatie.luntan.dao;

import com.fatie.luntan.domain.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

/**
 * 用户信息持久化接口
 */
@Mapper
@Repository
public interface UserMapper {
    /**
     * 用户注册
     *
     * @param user
     */

    @Insert("INSERT INTO user (id,username, password,sex,email,phone,create_time,credit,avatar,type,state,code) VALUES (#{user.id},#{user.userName},#{user.password},#{user.sex},#{user.email},#{user.phone},#{user.createTime},#{user.credit},#{user.avatar},#{user.type},#{user.state},#{user.code})")
    @ResultMap("userMap")
    int addUser(@Param("user")User user);
    /**
     * 用户登录
     *
     * @param password
     * @param userName
     * @return
     */
    @Select("SELECT * FROM user WHERE username = #{userName} AND password = #{password}")
    @Results(id = "userMap", value = {
            @Result(property = "id", column = "id"),
            @Result(property = "userName", column = "username"),
            @Result(property = "password", column = "password"),
            @Result(property = "sex", column = "sex"),
            @Result(property = "email", column = "email"),
            @Result(property = "phone", column = "phone"),
            @Result(property = "createTime", column = "create_time"),
            @Result(property = "credit", column = "credit"),
            @Result(property = "avatar", column = "avatar"),
            @Result(property = "type", column = "type"),
            @Result(property = "state", column = "state"),
            @Result(property = "code", column = "code")
    })
    User login(@Param("userName") String userName, @Param("password") String password);



}
