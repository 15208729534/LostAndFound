package com.example.demo.service;

import com.example.demo.domain.Announce;

import java.util.List;

public interface AnnounceService {

    //添加记录
    int insertSelective(Announce record);

    //删除，使信息不显示
    int updateByIsStatus(Integer announceId);

    //修改信息
    int updateByPrimaryKeySelective(Announce record);

    //显示所有信息
    List<Announce> selectAll();

    //按发布信息的ID进行查询
    Announce selectByPrimaryKey(Integer announceId);

    //按发布类型查询
    List<Announce> selectByAnnounceType(boolean announceType);

    //按物品类型查询
    List<Announce>  selectByTagName(String tagName);

}
