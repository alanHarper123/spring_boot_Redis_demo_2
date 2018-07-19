package com.qiujintao.spring_boot_Redis_demo_2.repository;

import java.util.Map;

import com.qiujintao.spring_boot_Redis_demo_2.model.Movie;

public interface RedisRepository {
	Map<String, String> finalAllMovies();
	void add(Movie movie);
	void delete(String id);
	Movie findMovie(String id);
}
