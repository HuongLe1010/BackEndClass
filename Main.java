package Coding.mentor;

import java.util.Scanner;

import Coding.mentor.data.Course;
import Coding.mentor.data.User;
import Coding.mentor.db.Database;
import Coding.mentor.service.CourseService;
import Coding.mentor.service.UserService;

public class Main {

	public static void main(String[] args) {
		CourseService courseService = new CourseService();
		UserService userService = new UserService();
		Database.initDB();

		Scanner scanner = new Scanner(System.in);
		User currentUser = null;
		String id, password, name;

		boolean loggedIn = false;

		do {
			System.out.println("Please choose an option:");
			System.out.println("1. Log in");
			System.out.println("2. Register");

			int choice = scanner.nextInt();
			scanner.nextLine();

			switch (choice) {
			case 1:
				System.out.println("Please input your ID");
				id = scanner.nextLine();
				System.out.println("Please input your password");
				password = scanner.nextLine();

				if (userService.login(id, password)) {
					currentUser = userService.validateUser(id);
					if (currentUser != null) {
						currentUser.setloginAttempts(0);
						System.out.println("Login successful.");
						loggedIn = true;
					} else {
						System.out.println("Login failed. Please check your credentials.");
					}
				} else {
					System.out.println("Login failed. Please check your credentials.");
				}
				break;

			case 2:
				System.out.println("Please input your ID");
				id = scanner.nextLine();
				System.out.println("Please input your password");
				password = scanner.nextLine();
				System.out.println("Please input your name");
				name = scanner.nextLine();

				userService.registerNewUser(id, password, name);
				System.out.println("Registration successful.");
				break;
			default:
				System.out.println("Invalid choice. Please select a valid option.");
				break;
			}
		} while (!loggedIn);

		boolean continueCourseSelection = true;
		while (currentUser != null && continueCourseSelection) {
			System.out.println("0: Show my registered courses");
			CourseService.showAllCourses();
			System.out.println("Which course would you like to choose?");
			int courseChosen = scanner.nextInt();

			if (courseChosen == 0) {
				UserService.showRegisteredCoursesByUser(currentUser);
			} else if (courseChosen >= 1 && courseChosen <= Database.COURSE_DB.size()) {
				Course chosenCourse = Database.COURSE_DB.get(courseChosen - 1);
				CourseService.showCourseDetail(chosenCourse);

				System.out.println("Select an option:");
				System.out.println("1. Register for this course");
				System.out.println("2. Don't Register");
				System.out.println("3. Show Mentor Details");

				int option = scanner.nextInt();

				switch (option) {
				case 1:
					UserService.registerNewCourse(currentUser, chosenCourse);
					System.out.println("You have successfully registered for this course.");
					break;
				case 2:
					System.out.println("You chose not to register for this course.");
					break;
				case 3:
					CourseService.showMentorByCourse(chosenCourse);
					break;
				default:
					System.out.println("Invalid choice. Please select a valid option.");
				}
			} else {
				System.out.println("Invalid course choice. Please select a valid option.");
			}
			System.out.println("Do you want to choose another course? (yes/no)");
			String continueChoice = scanner.next();
			continueCourseSelection = continueChoice.equalsIgnoreCase("yes");
		}
	}

}
