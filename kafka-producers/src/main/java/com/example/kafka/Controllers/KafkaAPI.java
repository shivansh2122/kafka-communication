package com.example.kafka.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.kafka.model.Person;


@RestController
@RequestMapping(value = "kafka")
public class KafkaAPI {
	@Autowired
	KafkaTemplate<String, Person> template;
	
	private static final String TOPIC = "kafkaTest";

	@GetMapping("/sendmessage/{message}")
	public String sendMessage(@PathVariable("message") final String name) {
		template.send(TOPIC, new Person(name, "hahaha"));
		return "published successfuly";

	}

}
