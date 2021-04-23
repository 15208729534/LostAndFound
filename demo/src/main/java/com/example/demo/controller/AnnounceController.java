package com.example.demo.controller;

import com.example.demo.domain.Announce;
import com.example.demo.service.AnnounceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/announce")
public class AnnounceController {

    @Autowired
    private AnnounceService announceService;

    //添加记录
    @PostMapping("/insert")
    public boolean insertSelective(@RequestBody Announce body)
    {
        int res = announceService.insertSelective(body);
        if (res>0)
        {
            return true;
        }
        else
            return false;
    }

    //删除，使信息不显示
    @DeleteMapping("/delete/{id}")
    public boolean updateByIsStatus(@PathVariable("id") Integer announceId)
    {
        int res = announceService.updateByIsStatus(announceId);
        if(res>0)
        {
            return true;
        }
        else
            return false;
    }

    //修改信息
    @PutMapping("/update")
    public boolean updateByPrimaryKeySelective(@RequestBody Announce record)
    {
        int res = announceService.updateByPrimaryKeySelective(record);
        if(res>0)
        {
            return true;
        }
        else
            return false;
    }

    //查询所有信息
    @GetMapping("/selectAll")
    public List<Announce> selectAll()
    {
        return announceService.selectAll();
    }

    //按发布信息的ID进行查询
    @GetMapping("/selectById/{id}")
    public Announce selectByPrimaryKey(@PathVariable("id") Integer announceId)
    {
        return announceService.selectByPrimaryKey(announceId);
    }

    //按发布类型查询
    @GetMapping("/selectByType/{type}")
    public List<Announce> selectByAnnounceType(@PathVariable("type") boolean announceType)
    {
        return announceService.selectByAnnounceType(announceType);
    }

    //按物品类型查询
    @GetMapping("/selectByTagName/{tagName}")
    public List<Announce> selectByTagName(@PathVariable("tagName") String tagName)
    {
        return announceService.selectByTagName(tagName);
    }
}
