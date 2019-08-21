package com.example.demo;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PublisherController {

	@Autowired
	RabbitTemplate rabbitTemplate;
	
	@PostMapping(path="/post/topic", consumes="application/json", produces="application/json")
	public String postTopic(@RequestBody TopicVO topicvo){
		
		rabbitTemplate.convertAndSend("basic-exchange","route-to-basicqueue", topicvo);
		return "topic is sent to exchange!";
	}
	
}
