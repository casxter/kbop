package com.kbop.controller;

import com.kbop.mapper.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    @Autowired
    BookMapper bookMapper;

    @RequestMapping(value = "/")
    public String home() {

        return "forward:/page/home.html";
    }

}
