package com.itcast.example.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.itcast.example.bean.User;

@RestController
@RequestMapping(value="/index")
public class IndexController {
	
	
	@Value("${itcast.secret}")
	private String secret;
	
	
	@Value("${itcast.number}")
	private Integer number;
	
	@Value("${itcast.desc}")
	private String desc;
	
	@RequestMapping
	public String index() {
		return "hello world";
	}
	
	@RequestMapping(value="get")
	public Map<String,Object> get(@RequestParam String name) {
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("name", name);
		map.put("value", "hello world");
		map.put("secret", secret);
		map.put("number", number);
		map.put("desc", desc);
		return map;
	}

	@RequestMapping(value="find/{id}/{name}")
	public User find(@PathVariable Integer id,@PathVariable String name) {
		User user = new User();
		user.setName(name);
		user.setId(id);
		user.setDate(new Date());
		return user;
	}
}
