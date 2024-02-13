package nh.springboot.helloworld.controller;

import java.net.InetAddress;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

import nh.springboot.helloworld.component.HelloContext;

@RestController
public class HelloWorldController {
	@Autowired
	private HelloContext context;
	
	@GetMapping(path = "/", produces = MediaType.APPLICATION_JSON_VALUE)
	public String index() throws Exception {
		InetAddress host = InetAddress.getLocalHost();
		
		Map<String, Object> map = new LinkedHashMap <>();
		map.put("message", "Hello world spring boot");
		map.put("host", host.getHostName());
		map.put("ip(s)", host.getHostAddress());
		map.put("environment-variable(s)",  System.getenv());
		// Get data from request context
		map.put("greeting",  context.getGreeting());
		
		ObjectMapper mapper = new ObjectMapper();
		String jsonResult = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(map);

		return jsonResult;
	}
}