package com.fatie.luntan.service;

import com.fatie.luntan.dao.UserMapper;
import com.fatie.luntan.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
@Autowired
private UserMapper userMapper;

    /**
     * 用户注册
     * @return
     */
    //用户注册
    public boolean addUser(User user) {

        return userMapper.addUser(user) > 0;
    }

   /* *
     * 登录验证

    public User login(String username, String password) {
        return userMapper.login(username,password);
    }

    *
     * 添加积分

    public boolean addCredit(Integer points, Integer id){

    }

    *
     * 获取用户信息
     *
     * @param username
     * @return

    public User findByUsername(String username){

    }


    *
     * 获取用户信息
     *
     * @param id
     * @return

    public User findUserById(Integer id){

    }


    public User updateUser(User user){

    }*/
}
