package com.example.demo.service;

import com.example.demo.domain.Tag;

import java.util.List;

public interface TagService {
    //添加记录
    int insertSelective(Tag record);

    //删除记录
    int deleteByTagId(Integer tagId);

    //修改信息
    int updateByPrimaryKeySelective(Tag record);

    //显示所有信息
    List<Tag> selectAll();

    //按id查询
    Tag selectByPrimaryKey(Integer tagId);

    //按类型查询
    List<Tag> selectByTagName(String tagName);

    //按次数多少查询
    List<Tag> selectCount();
}
