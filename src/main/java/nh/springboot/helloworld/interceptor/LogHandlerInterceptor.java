package nh.springboot.helloworld.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import nh.springboot.helloworld.component.HelloContext;

public class LogHandlerInterceptor implements HandlerInterceptor {
    Logger logger = LoggerFactory.getLogger(LogHandlerInterceptor.class); 
    
    @Autowired
    private HelloContext context;
    
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
    	logger.info("LogHandlerInterceptor::preHandle()");
    	context.setGreeting("Hi..I am request context set from interceptor.");
      return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    	logger.info("LogHandlerInterceptor::postHandle()");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
    	logger.info("LogHandlerInterceptor::afterCompletion()");
    }
}
