package com.example.demo.service;

import com.example.demo.domain.User;

import java.util.List;

public interface UserService {
    int insertSelective(User record);

    int deleteByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(User record);

    //显示所有信息
    List<User> selectAll();

    //按Id进行查找
    User selectByPrimaryKey(Integer userId);

    //按联系方式进行查找
    User selectByContact(String contact);
}
