package com.meesho.mohsin.cache.springredisexample;

import com.meesho.mohsin.cache.springredisexample.model.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootApplication
public class SpringRedisExampleApplication {


	@Bean
	JedisConnectionFactory jedisConnectionFactory(){
		return new JedisConnectionFactory();   //  If you want custom port number and hostname you can provide here
	}

	@Bean
	RedisTemplate<String, User> redisTemplate(){
		RedisTemplate<String,User> redisTemplate = new RedisTemplate<>();
		redisTemplate.setConnectionFactory(jedisConnectionFactory());
		return redisTemplate;
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringRedisExampleApplication.class, args);
	}

}
