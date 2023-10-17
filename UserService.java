package Coding.mentor.service;

import java.util.ArrayList;

import Coding.mentor.data.Course;
import Coding.mentor.data.Mentor;
import Coding.mentor.data.User;
import Coding.mentor.db.Database;

public class UserService {

	public void registerNewUser(String id, String password, String name) {
		// validate id yet existed
		User currentUser = validateUser(id);
		if (currentUser != null) {
			System.out.println("This ID has been used, please choose another one.");
			return;
		}
		// new Object User with user's input
		User user = new User(id, password, name);
		
		// add the user we created above to USERS_DB
		Database.USERS_DB.add(user);
		System.out.println("Register Successfully!");	
	}
	
	public boolean login(String id, String password) {
		// validate id yet existed
		User currentUser = validateUser(id);
		
		// further check
		if (currentUser != null) {
			if(currentUser.getloginAttempts() < 3) {
				if(password.equals(currentUser.getPassword())) {
					currentUser.setloginAttempts(0);
					return true;
				} else {
					currentUser.setloginAttempts(currentUser.getloginAttempts()+1);
				}
			}
		}
		return false;
	}
	
	public static void showRegisteredCoursesByUser(User user) {
		ArrayList<Course> registeredCourses = user.getRegisteredCourse();

        if (registeredCourses.isEmpty()) {
            System.out.println("You have not registered for any courses.");
        } else {
            System.out.println("Registered Courses for " + user.getName() + ":");
            for (Course course : registeredCourses) {
                System.out.print(course.getName());
                for (Mentor mentor : course.getTeachingMentors()) {
    				System.out.print(" -- mentor name: " + mentor.getName());
    			}
    			System.out.println();
            }
        }
	}
	
	public static void registerNewCourse(User user, Course course) {
		ArrayList<Course> registeredCourses = user.getRegisteredCourse();
		
		registeredCourses.add(course);
        System.out.println("Course registration successful!");
	}
	
	public User validateUser(String id) {
		for (User user: Database.USERS_DB) {
			if(user.getId().equals(id)) {
				return user;
			}
		}
		return null;
	}
	
}
