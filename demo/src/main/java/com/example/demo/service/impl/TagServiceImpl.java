package com.example.demo.service.impl;

import com.example.demo.dao.TagDao;
import com.example.demo.domain.Tag;
import com.example.demo.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagServiceImpl implements TagService {


    @Autowired
    private TagDao tagDao;

    @Override
    public int insertSelective(Tag record) {
        return tagDao.insertSelective(record);
    }

    @Override
    public int deleteByTagId(Integer tagId) {
        return tagDao.deleteByTagId(tagId);
    }

    @Override
    public int updateByPrimaryKeySelective(Tag record) {
        return tagDao.updateByPrimaryKeySelective(record);
    }

    @Override
    public List<Tag> selectAll() {
        return tagDao.selectAll();
    }

    @Override
    public Tag selectByPrimaryKey(Integer tagId) {
        return tagDao.selectByPrimaryKey(tagId);
    }

    @Override
    public List<Tag> selectByTagName(String tagName) {
        return tagDao.selectByTagName(tagName);
    }

    @Override
    public List<Tag> selectCount() {
        return tagDao.selectCount();
    }
}

