package com.qiujintao.spring_boot_Redis_demo_2.queue;

public interface MessagePublisher {
	void publish(final String messege);
}
