package com.sda.kino.spring;

import com.sda.kino.RandomNumberGenerator;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @GetMapping(path = "/hello")
    public ModelAndView helloPage(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("happyNumber", RandomNumberGenerator.drawHappyNumber());
        modelAndView.setViewName("index");
        return modelAndView;
    }
}
