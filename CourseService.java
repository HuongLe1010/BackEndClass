package Coding.mentor.service;

import Coding.mentor.data.Course;
import Coding.mentor.data.Mentor;
import Coding.mentor.db.Database;

public class CourseService {

	public static void showAllCourses() {
		for (int i = 0; i < Database.COURSE_DB.size(); i++) {
			System.out.print((i + 1) + ": " + Database.COURSE_DB.get(i).getName());
			for (Mentor mentor : Database.COURSE_DB.get(i).getTeachingMentors()) {
				System.out.print(" -- mentor name: " + mentor.getName());
			}
			System.out.println();
		}
	}

	public static void showCourseDetail(Course course) {
		System.out.println("Course: " + course.getName());
        for (Mentor mentor: course.getTeachingMentors()) {
        	System.out.println(" -- mentor name: "+ mentor.getName());
        }
        System.out.println("Start on: " + course.getBegin());
        System.out.println("Expected end on: " + course.getEnd());
        System.out.println("Fee: " + course.getFee());		    
	}

	public static void showMentorByCourse(Course course) {
		System.out.println("Mentors for course " + course.getName() + ":");

		for (Mentor mentor : course.getTeachingMentors()) {
			System.out.println("Mentor Name: " + mentor.getName());
			System.out.println("Email: " + mentor.getEmail());
			System.out.println("Phone: " + mentor.getPhone());
			System.out.println("-------------");
		}
	}
}
