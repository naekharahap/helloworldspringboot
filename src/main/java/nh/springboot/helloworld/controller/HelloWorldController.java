package nh.springboot.helloworld.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

import nh.springboot.helloworld.service.HelloworldService;

@RestController
public class HelloWorldController {
	@Autowired
	private HelloworldService helloworldService;
	
	@GetMapping(path = "/", produces = MediaType.APPLICATION_JSON_VALUE)
	public String index() throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		String jsonResult = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(helloworldService.hello());

		return jsonResult;
	}
}