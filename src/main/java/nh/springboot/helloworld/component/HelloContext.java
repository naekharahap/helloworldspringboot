package nh.springboot.helloworld.component;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import nh.springboot.helloworld.model.AppInfo;

@Component
@RequestScope
public class HelloContext {
	private String greeting = "Hi...";
	final private AppInfo appInfo;

	public HelloContext() {
		this.appInfo = new AppInfo();
	}

	public String getGreeting() {
		return greeting;
	}

	public void setGreeting(String greeting) {
		this.greeting = greeting;
	}

	public AppInfo getAppInfo() {
		return appInfo;
	}
}
