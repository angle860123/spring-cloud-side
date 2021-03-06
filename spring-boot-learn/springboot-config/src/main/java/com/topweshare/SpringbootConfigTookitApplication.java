package com.topweshare;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.concurrent.CountDownLatch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;

@SpringBootApplication
public class SpringbootConfigTookitApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(SpringbootConfigTookitApplication.class);


	public static void main(String[] args) throws Exception{
		ApplicationContext ctx =  SpringApplication.run(SpringbootConfigTookitApplication.class, args);


	}


}
