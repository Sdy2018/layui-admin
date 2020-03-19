package com.adeng1024.admin.service.serviceImpl;

import com.adeng1024.admin.mapper.UserMapper;
import com.adeng1024.admin.pojo.User;
import com.adeng1024.admin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public Integer addUser(User user) {
        return userMapper.addUser( user);
    }

    @Override
    public Integer deleteUserById(Integer id) {
        return userMapper.deleteUserById(id);
    }

    @Override
    public User queryUserByName(String username) {
        return userMapper.queryUserByName(username);
    }

    @Override
    public List<User> queryUserList() {
        return userMapper.queryUserList();
    }
}
