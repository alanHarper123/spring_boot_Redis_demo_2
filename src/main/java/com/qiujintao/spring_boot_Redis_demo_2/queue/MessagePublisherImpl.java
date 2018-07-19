package com.qiujintao.spring_boot_Redis_demo_2.queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.stereotype.Service;

@Service
public class MessagePublisherImpl implements MessagePublisher {
	
	@Autowired
	private RedisTemplate<String, Object> redisTemplate;
	@Autowired
	private ChannelTopic topic;
	public MessagePublisherImpl() {
	}
	public MessagePublisherImpl(RedisTemplate<String, Object> redisTemplate,
			ChannelTopic topic) {
		this.redisTemplate = redisTemplate;
		this.topic = topic;
	}
	@Override
	public void publish(String messege) {
		redisTemplate.convertAndSend(topic.getTopic(), messege);
		
	}

}
