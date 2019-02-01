package com.annie.controller;

import com.annie.service.TestService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;



@Controller
public class Testontroller {

    @Autowired
    TestService testService;


    @ResponseBody
    @RequestMapping("/getName")
    public PageInfo getName(){
        PageInfo name = testService.getName();
        return name;
    }






}
