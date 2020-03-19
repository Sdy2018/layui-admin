package com.adeng1024.admin.service;

import com.adeng1024.admin.pojo.User;

import java.util.List;

public interface UserService  {
    Integer addUser(User user);
    Integer deleteUserById(Integer id);
    User queryUserByName(String username);
    List<User> queryUserList();
}
