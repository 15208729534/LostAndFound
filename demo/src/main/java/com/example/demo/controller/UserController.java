package com.example.demo.controller;

import com.example.demo.domain.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/insert")
    public boolean insertSelective(@RequestBody User record)
    {
        int res = userService.insertSelective(record);
        if (res>0)
        {
            return true;
        }
        else
            return false;
    }

    @DeleteMapping("/delete/{id}")
    public boolean deleteByPrimaryKey(@PathVariable("id") Integer userId)
    {
        int res = userService.deleteByPrimaryKey(userId);
        if (res>0)
        {
            return true;
        }
        else
            return false;
    }

    @PutMapping("/update")
    public boolean updateByPrimaryKeySelective(@RequestBody User record)
    {
        int res = userService.updateByPrimaryKeySelective(record);
        if (res>0)
        {
            return true;
        }
        else
            return false;
    }

    //显示所有信息
    @GetMapping("/selectAll")
    List<User> selectAll()
    {
        return userService.selectAll();
    }

    //按Id进行查找
    @GetMapping("/selectById/{id}")
    User selectByPrimaryKey(@PathVariable("id") Integer userId)
    {
        return userService.selectByPrimaryKey(userId);
    }

    //按联系方式进行查找
    @GetMapping("/selectByContact/{contact}")
    User selectByContact(@PathVariable("contact") String contact)
    {
        return userService.selectByContact(contact);
    }
}
