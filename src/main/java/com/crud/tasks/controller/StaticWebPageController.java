package com.crud.tasks.controller;

import com.crud.tasks.service.MailCreatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.core.env.Environment;

import java.util.Map;

@Controller
@ConfigurationProperties
public class StaticWebPageController {
    @Autowired
    private Environment environment;

    @RequestMapping("/")
    public String index(Map<String,Object> model){
        model.put("variable","My Thymeleaf variable");
        model.put("one", 1);
        model.put("two", 2);
        model.put("three", environment.getProperty("admin.name"));
        return "index";
    }



}
