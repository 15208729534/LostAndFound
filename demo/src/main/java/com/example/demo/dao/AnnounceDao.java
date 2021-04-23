package com.example.demo.dao;

import com.example.demo.domain.Announce;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AnnounceDao {
    //添加记录
    int insertSelective(Announce record);

    //删除，使信息不显示
    int updateByIsStatus(Integer announceId);

    //按发布信息的ID进行修改
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