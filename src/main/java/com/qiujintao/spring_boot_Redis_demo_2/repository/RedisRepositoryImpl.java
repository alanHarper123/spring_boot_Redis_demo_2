package com.qiujintao.spring_boot_Redis_demo_2.repository;

import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;


import com.qiujintao.spring_boot_Redis_demo_2.model.Movie;

@Repository
public class RedisRepositoryImpl implements RedisRepository{
	private static final String KEY = "Movie";
	@Autowired
	private RedisTemplate<String, Object> redisTemplate;
	private HashOperations<String,String,String> hashOperations;
	@PostConstruct
	private void init() {
		hashOperations = redisTemplate.opsForHash();
	}


	@Override
	public void add(Movie movie) {
		hashOperations.put(KEY, movie.getId(), movie.getName());
	}

	@Override
	public void delete(String id) {
		hashOperations.delete(KEY, id);
		
	}

	@Override
	public Movie findMovie(String id) {
		return new Movie(id, hashOperations.get(KEY, id));
	}
	
	@Override
	public Map<String, String> finalAllMovies() {
		return hashOperations.entries(KEY);
	}

}
