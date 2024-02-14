package nh.springboot.helloworld.service.impl;

import java.net.InetAddress;
import java.util.LinkedHashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nh.springboot.helloworld.component.HelloContext;
import nh.springboot.helloworld.component.filter.HttpHeaderFilter;
import nh.springboot.helloworld.service.HelloworldService;

@Service
public class HelloworldServiceImpl implements HelloworldService {
	Logger logger = LoggerFactory.getLogger(HelloworldServiceImpl.class);
	
	@Autowired
	private HelloContext context;
	
	@Override
	public Map<String, Object> hello() throws Exception {
		Map<String, Object> map = new LinkedHashMap <>();
		
		InetAddress host = InetAddress.getLocalHost();
		map.put("message", "Hello world spring boot");
		map.put("host", host.getHostName());
		map.put("ip(s)", host.getHostAddress());
		map.put("environment-variable(s)",  System.getenv());
		// Get data from request context
		map.put("greeting",  context.getGreeting());
		
		logger.info(context.getAppInfo().toString());
		logger.info("email: naekha@gmail.com");
		map.put("name",  context.getAppInfo().getName());
		map.put("username",  context.getAppInfo().getUsername());
		return map;
	}

}
