package Coding.mentor.data;

import java.util.ArrayList;

public class User {

	private String id;
	private String password;
	private String name;
	private ArrayList<Course> registeredCourse;
	private int loginAttempts;
	
	public User() {
		// TODO Auto-generated constructor stub
	}
	
	public User(String id, String password, String name) {
		super();
		this.id = id;
		this.password = password;
		this.name = name;
		this.registeredCourse = new ArrayList<>();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Course> getRegisteredCourse() {
		return registeredCourse;
	}

	public void setRegisteredCourse(ArrayList<Course> registeredCourse) {
		this.registeredCourse = registeredCourse;
	}

	public int getloginAttempts() {
		return loginAttempts;
	}

	public void setloginAttempts(int loginAttempts) {
		this.loginAttempts = loginAttempts;
	}
	
	
}
