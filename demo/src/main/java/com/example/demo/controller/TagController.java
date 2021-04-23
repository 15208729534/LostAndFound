package com.example.demo.controller;



import com.example.demo.domain.Tag;
import com.example.demo.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tag")
public class TagController {

    @Autowired
    private TagService tagService;

    //添加记录
    @PostMapping("/insert")
    public boolean insertSelective(@RequestBody Tag record)
    {
        int res = tagService.insertSelective(record);
        if (res>0)
        {
            return true;
        }
        else
            return false;
    }

    //删除记录
    @DeleteMapping("/delete/{id}")
    public boolean deleteByTagId(@PathVariable("id") Integer tagId)
    {
        int res = tagService.deleteByTagId(tagId);
        if (res>0)
        {
            return true;
        }
        else
            return false;
    }

    //修改信息
    @PutMapping("/update")
    public boolean updateByPrimaryKeySelective(@RequestBody Tag record)
    {
        int res = tagService.updateByPrimaryKeySelective(record);
        if (res>0)
        {
            return true;
        }
        else
            return false;
    }

    //显示所有信息
    @GetMapping("/selectAll")
    public List<Tag> selectAll()
    {
        return tagService.selectAll();
    }

    //按id查询
    @GetMapping("/selectById/{id}")
    public Tag selectByPrimaryKey(@PathVariable("id") Integer tagId)
    {
        return tagService.selectByPrimaryKey(tagId);
    }

    //按类型查询
    @GetMapping("/selectByTagName/{tagName}")
    public List<Tag> selectByTagName(@PathVariable("tagName") String tagName)
    {
        return tagService.selectByTagName(tagName);
    }

    //按次数多少查询
    @GetMapping("/selectCount")
    public List<Tag> selectCount()
    {
        return tagService.selectCount();
    }
}
