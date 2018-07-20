package com.qiujintao.spring_boot_Redis_demo_2.queue;


import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;



public class MessagePublisherImpl implements MessagePublisher {
	

	private RedisTemplate<String, Object> redisTemplate;

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
