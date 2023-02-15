package com.rwkj.dormitory.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class test {

    @RequestMapping("/index")
    public String index() {
        return "absentrecord";
    }
}
