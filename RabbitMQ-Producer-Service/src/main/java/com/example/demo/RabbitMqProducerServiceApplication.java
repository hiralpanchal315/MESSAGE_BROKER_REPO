package com.example.demo;

import java.util.HashMap;
import java.util.Map;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;



@SpringBootApplication
public class RabbitMqProducerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RabbitMqProducerServiceApplication.class, args);
	}

	@Bean
	public Queue queue(){
	
		Map<String, Object> map = new HashMap<>();
		map.put("x-max-length", new Integer(50));
		return new Queue("basic-queue", true, false, false,map);
	}

	@Bean
	public DirectExchange exchange(){
		
		return new DirectExchange("basic-exchange");
	}
	
	@Bean
	public Binding binding(Queue queue, DirectExchange exchange){
		
		return BindingBuilder.bind(queue).to(exchange).with("route-to-basicqueue");
    }
}
