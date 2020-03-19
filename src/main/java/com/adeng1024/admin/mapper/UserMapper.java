package com.adeng1024.admin.mapper;

import com.adeng1024.admin.pojo.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public  interface UserMapper  {
    Integer addUser(User user);
    Integer deleteUserById(Integer id);
    User queryUserByName(String username);
    List<User> queryUserList();
}
