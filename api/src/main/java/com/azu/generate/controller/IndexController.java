package com.azu.generate.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zzs
 * @date 2021/7/18 12:10
 */
@Controller
public class IndexController {

    @RequestMapping("/index")
    public ModelAndView toIndex(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        modelAndView.addObject("hello", "hello world");
        return  modelAndView;
    }
}
