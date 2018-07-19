package com.qiujintao.spring_boot_Redis_demo_2.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qiujintao.spring_boot_Redis_demo_2.model.Movie;
import com.qiujintao.spring_boot_Redis_demo_2.repository.RedisRepository;

@Controller
public class WebController {
	@Autowired
	private RedisRepository redisRepository;
	
	@RequestMapping("/")
	public String index() {
		return "index";
	}
	
	@RequestMapping("/keys")
	@ResponseBody
	public Map<? extends Object, ?extends Object> keys(){
		return redisRepository.finalAllMovies();
	}
	
	@RequestMapping("/values")
	@ResponseBody
	public Map<String, String> finalAll(){
		return redisRepository.finalAllMovies();
	}
	@RequestMapping(value="/add", method = RequestMethod.POST)
	public ResponseEntity<String> add(
			@RequestParam String key, @RequestParam String value){
		redisRepository.add(new Movie(key, value));
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@RequestMapping(value="/delete", method = RequestMethod.POST)
	public ResponseEntity<String> delete(@RequestParam String key){
		redisRepository.delete(key);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	
}
