package com.example.demo.service.impl;

import com.example.demo.dao.AnnounceDao;
import com.example.demo.domain.Announce;
import com.example.demo.service.AnnounceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnnounceServiceImpl implements AnnounceService {

    @Autowired
    private AnnounceDao announceDao;

    //添加记录
    @Override
    public int insertSelective(Announce record) {
        return announceDao.insertSelective(record);
    }

    //删除信息，使其不显示
    @Override
    public int updateByIsStatus(Integer announceId) {
        return announceDao.updateByIsStatus(announceId);
    }

    //修改信息
    @Override
    public int updateByPrimaryKeySelective(Announce record) {
        return announceDao.updateByPrimaryKeySelective(record);
    }

    //按发布信息的ID进行修改
    @Override
    public Announce selectByPrimaryKey(Integer announceId) {
        return announceDao.selectByPrimaryKey(announceId);
    }

    //显示所有信息
    public List<Announce> selectAll()
    {
        return announceDao.selectAll();
    }

    //按发布类型进行查询
    @Override
    public List<Announce> selectByAnnounceType(boolean announceType) {
        return announceDao.selectByAnnounceType(announceType);
    }

    //按物品的类别进行查询
    @Override
    public List<Announce> selectByTagName(String tagName) {
        return announceDao.selectByTagName(tagName);
    }

}
