package com.itcast.example.controller;

import com.itcast.example.properties.UserProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value="/")
public class IndexController {

    @Autowired
    private UserProperties up;

    @RequestMapping
    public String index(){
        return up.getDesc();
    }

    @RequestMapping(value="get")
    public Map<String,String> get(@RequestParam String name){
        Map<String,String> map = new HashMap<String,String>();
        map.put("name",name);
        map.put("value","hello world");
        return map;
    }
}
