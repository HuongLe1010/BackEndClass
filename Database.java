package Coding.mentor.db;

import java.util.ArrayList;
import java.util.Date;

import Coding.mentor.data.Course;
import Coding.mentor.data.Mentor;
import Coding.mentor.data.User;

public class Database {
	public static ArrayList<Mentor> MENTORS_DB = new ArrayList<Mentor>();
	public static ArrayList<Course> COURSE_DB = new ArrayList<Course>();
	public static ArrayList<User> USERS_DB = new ArrayList<User>();
	
	public static void initDB() {
		//initialize Mentor DB
		MENTORS_DB.add(new Mentor (1, "Dung", "dung@gmail.com", "0909"));
		MENTORS_DB.add(new Mentor (2, "Jayden", "jayden@gmail.com", "0808"));
		MENTORS_DB.add(new Mentor (3, "Tony", "tony@gmail.com", "0707"));
		
		// initilize Course DB
		ArrayList<Mentor> teachingMentors = new ArrayList<Mentor>();
		teachingMentors.add(MENTORS_DB.get(0));
		COURSE_DB.add(new Course(1, "BE 1", teachingMentors, new Date(), new Date(), 3000));
		
		teachingMentors = new ArrayList<Mentor>();
		teachingMentors.add(MENTORS_DB.get(0));
		teachingMentors.add(MENTORS_DB.get(1));
		COURSE_DB.add(new Course(2, "BE 2", teachingMentors, new Date(), new Date(), 3100));
		
		teachingMentors = new ArrayList<Mentor>();
		teachingMentors.add(MENTORS_DB.get(2));
		COURSE_DB.add(new Course(3, "DATA 1", teachingMentors, new Date(), new Date(), 3100));
		
	}
	
}
