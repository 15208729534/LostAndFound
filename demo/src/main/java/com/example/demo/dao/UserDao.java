package com.example.demo.dao;

import com.example.demo.domain.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserDao {

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