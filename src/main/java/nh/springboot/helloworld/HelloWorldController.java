package nh.springboot.helloworld;

import java.net.InetAddress;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class HelloWorldController {

	@GetMapping(path = "/", produces = MediaType.APPLICATION_JSON_VALUE)
	public String index() throws Exception {
		InetAddress host = InetAddress.getLocalHost();
		
		Map<String, String> map = new LinkedHashMap <>();
		map.put("message", "Hello world spring boot");
		map.put("host", host.getHostName());
		map.put("ip", host.getHostAddress());

		ObjectMapper mapper = new ObjectMapper();
		String jsonResult = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(map);

		return jsonResult;
	}
}