package nh.springboot.helloworld.model;

public class AppInfo {
	String name;
	String username;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String toString() {
		return "AppInfo [name=" + name + ", username=" + username + "]";
	}

}