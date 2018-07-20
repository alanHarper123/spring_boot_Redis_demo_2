package com.qiujintao.spring_boot_Redis_demo_2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.qiujintao.spring_boot_Redis_demo_2.queue.MessagePublisher;

@SpringBootApplication
public class SpringBootRedisDemo2Application implements CommandLineRunner {
	@Autowired
	private MessagePublisher messagePublisher;
	

	public static void main(String[] args) {
		SpringApplication.run(SpringBootRedisDemo2Application.class, args);
	}


	@Override
	public void run(String... arg0) throws Exception {
		messagePublisher.publish("test 1");
		messagePublisher.publish("test 2");
		messagePublisher.publish("test 3");
		
	}
}
