package nh.springboot.helloworld.interceptor;

import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import nh.springboot.helloworld.component.HelloContext;

public class AppContextInterceptor implements HandlerInterceptor {
	Logger logger = LoggerFactory.getLogger(AppContextInterceptor.class);

	@Autowired
	private HelloContext context;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		logger.debug("::preHandle()");
		
		// Query parameters
		Map<String, String[]> queryParams = request.getParameterMap();
		if( queryParams.containsKey("greeting" )) {
			context.setGreeting(queryParams.get("greeting")[0]);
		}

		// Header parameters
		String appData = request.getHeader("X-APP-DATA");
		Map<String, String> headerParams = new HashMap<String,String>();
		for(String param:appData.split("&")) {
			headerParams.put(param.split("=")[0], URLDecoder.decode(param.split("=")[1], StandardCharsets.UTF_8));
		}
		context.getAppInfo().setName(headerParams.get("name"));
		context.getAppInfo().setUsername(headerParams.get("username"));
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		logger.debug("::postHandle()");
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		logger.debug("::afterCompletion()");
	}
}
