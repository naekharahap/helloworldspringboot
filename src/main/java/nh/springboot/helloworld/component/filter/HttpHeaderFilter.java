package nh.springboot.helloworld.component.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
@Order(2)
public class HttpHeaderFilter implements Filter {
	Logger logger = LoggerFactory.getLogger(HttpHeaderFilter.class);

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		
		String appData = req.getHeader("X-APP-DATA");
		if(appData==null) {
			res.setStatus(HttpStatus.BAD_REQUEST.value());
			return;
		}
		
		chain.doFilter(request, response);
	}
}

