import adapter.ProgressAdapter;
import builder.UserBuilder;
import course_builder.*;
import course_levels.*;
import courses.ICourse;
import decorator.*;
import facade.StudentPortalFacade;
import factory.*;
import observer.NotificationService;
import user.*;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Application {
    private static final Scanner scanner = new Scanner(System.in);
    private static boolean isLoggedIn = false;
    private static IUser currentUser;
    private static UserManager userManager = new UserManager();
    private static StudentPortalFacade studentPortal;
    private static ProgressAdapter progressAdapter;
    private static IUser admin = new Admin("admin", "admin", "admin");
    private static Teacher teacher = new Teacher("teacher", "teacher", "teacher");
    private static Course courseW;
    private static NotificationService notificationService = new NotificationService();


    public static void start() {
        if (isLoggedIn) {
            contentMenu();
        } else {
            mainMenu();
        }
    }


    private static void mainMenu() {

        System.out.println("---------- Main Page ----------");
        System.out.println("Welcome to LMS!");
        System.out.println("Select an option:");
        System.out.println("1. Register");
        System.out.println("2. Login");
        System.out.println("3. Exit App");
        System.out.print("Your choice: ");

        try {
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    registrationMenu();
                    break;
                case 2:
                    if (isLoggedIn) {
                        contentMenu();
                    } else {
                        loginMenu();
                    }
                    break;
                default:
                    System.out.println("Exiting the App...");
                    break;
            }

        } catch (InputMismatchException e) {
            throw new IllegalArgumentException("Invalid value! Must be an integer.");
        }

    }

    private static void registrationMenu() {
        System.out.println("---------- Registration ---------- ");

        System.out.println("Type '0' to go back to main menu!");
        System.out.println("Please, enter your email");
        String email = scanner.next();
        if (email.equals("0")) {
            mainMenu();
            return;
        }
        System.out.println("Create username");
        String username = scanner.next();
        System.out.println("Create password");
        String password = scanner.next();

        boolean isUserExists = false;
        for (IUser user : userManager.getUsers()) {
            if (user.getUsername().equals(username)) {
                isUserExists = true;
                System.out.println("Username already exists! Please try another username!");
                System.out.println();
                registrationMenu();
            }
        }

        if (!isUserExists) {
            UserBuilder userBuilder = new UserBuilder();
            userBuilder.email(email)
                    .username(username)
                    .password(password);
            IUser user = userBuilder.build();
            currentUser = userManager.registerUser(user);
            studentPortal = new StudentPortalFacade(currentUser);
            contentMenu();
        }
    }


    private static void loginMenu() {
        System.out.println("---------- Login Page ----------");
        System.out.println("Welcome back to LMS!");
        System.out.println("Type '0' to go back to main page!");
        while (true) {
            System.out.println("Please enter your username");
            String username = scanner.next();
            if (username.equals("0")) {
                mainMenu();
                return;
            }
            System.out.println("Please enter your password");
            String password = scanner.next();


            if (password.equals(admin.getPassword()) & username.equals(admin.getUsername())) {
                adminMenu();
                return;
            }

            if(password.equals(teacher.getPassword()) & username.equals(teacher.getUsername())){
                teacherMenu();
                return;
            }

            for (IUser user : userManager.getUsers()) {
                if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                    currentUser = userManager.loginUser(username, password);
                    studentPortal = new StudentPortalFacade(currentUser);
                    contentMenu();
                    return;
                }
            }

            System.out.println("There is no such user!");
            System.out.println("Try again");
        }
    }

    private static void logoutMenu() {
        System.out.println("Logging out...");
        System.out.println("Goodbye!");
        mainMenu();
    }

    private static void contentMenu() {
        System.out.println("---------- Content Page ----------");
        System.out.println("Hello, student!");
        progressAdapter = new ProgressAdapter(currentUser);
        System.out.println(progressAdapter.getProgressMessage());
        System.out.println("Select an option:");
        System.out.println("1. Enroll in course");
        System.out.println("2. My active courses");
        System.out.println("3. My completed courses");
        System.out.println("4. Log out");
        System.out.print("Your choice: ");

        try {
            int choice = scanner.nextInt();
            if (choice == 1) {
                enrollInCourseMenu();
            } else if (choice == 2) {
                userActiveCoursesMenu();
            } else if (choice == 3) {
                userCompletedCoursesMenu();
            } else {
                logoutMenu();
            }
        } catch (InputMismatchException e) {
            throw new IllegalArgumentException("Invalid value! Must be an integer.");
        }


    }


    private static void enrollInCourseMenu() {
        ICourse course = null;
        ICourseLevel courseLevel = null;
        try {
            System.out.println("---------- Enroll in Course ----------");
            System.out.println("Type '0' to go back to Content Menu!");
            System.out.println("Which course do you want to learn ?");
            System.out.println("1. Algebra");
            System.out.println("2. Geometry");
            System.out.println("3. Java");
            System.out.println("4. Python");
            System.out.println("5. English");
            System.out.println("6. Spanish");
            System.out.print("Your choice: ");
            int choice1 = scanner.nextInt();
            if (choice1 == 0) {
                contentMenu();
                return;
            }

            System.out.println("Choose your starting point. Which level of course do you want to learn?");
            System.out.println("1. Beginner");
            System.out.println("2. Intermediate");
            System.out.println("3. Advanced");
            System.out.print("Your choice: ");
            int choice2 = scanner.nextInt();
            if (choice2 == 0) {
                contentMenu();
                return;
            }

            System.out.println("Do you want to add Certification to the course?");
            System.out.println("1. Yes");
            System.out.println("2. No");
            System.out.print("Your choice: ");
            int choice3 = scanner.nextInt();
            if (choice3 == 0) {
                contentMenu();
                return;
            }

            System.out.println("Do you want to add Mentor Support to the course?");
            System.out.println("1. Yes");
            System.out.println("2. No");
            System.out.print("Your choice: ");
            int choice4 = scanner.nextInt();
            if (choice4 == 0) {
                contentMenu();
                return;
            }

            System.out.println("Do you want to add Games to the course?");
            System.out.println("1. Yes");
            System.out.println("2. No");
            System.out.print("Your choice: ");
            int choice5 = scanner.nextInt();
            if (choice5 == 0) {
                contentMenu();
                return;
            }

            System.out.println("Which Module do you want to study?");
            System.out.println("1. Module 1");
            System.out.println("2. Module 2");
            System.out.println("3. Module 3");
            System.out.print("Your choice: ");
            int choice6 = scanner.nextInt();
            if (choice6 == 0) {
                contentMenu();
                return;
            }


            System.out.println("Do you want to add Quizzes to the course?");
            System.out.println("1. Yes");
            System.out.println("2. No");
            System.out.print("Your choice: ");
            int choice7 = scanner.nextInt();
            if (choice7 == 0) {
                contentMenu();
                return;
            }


            //Level choice
            if (choice2 == 1) {
                courseLevel = new LevelA();
            } else if (choice2 == 2) {
                courseLevel = new LevelB();
            } else if (choice2 == 3) {
                courseLevel = new LevelC();
            } else {
                System.out.println("Invalid choice.");
            }


            ICourseFactory mathCourseFactory = new MathCourseFactory();
            ICourseFactory progCourseFactory = new ProgrammingCourseFactory();
            ICourseFactory langCourseFactory = new LanguageCourseFactory();

            //Course choice
            if (choice1 == 1) {
                course = mathCourseFactory.createCourse("Algebra", courseLevel);
            } else if (choice1 == 2) {
                course = mathCourseFactory.createCourse("Geometry", courseLevel);
            } else if (choice1 == 3) {
                course = progCourseFactory.createCourse("Java", courseLevel);
            } else if (choice1 == 4) {
                course = progCourseFactory.createCourse("Python", courseLevel);
            } else if (choice1 == 5) {
                course = langCourseFactory.createCourse("English", courseLevel);
            } else if (choice1 == 6) {
                course = langCourseFactory.createCourse("Spanish", courseLevel);
            } else {
                System.out.println("Invalid choice.");
            }


            //Certification for the course
            if (choice3 == 1) {
                course = new CertificateDecorator(course);
            } else if (choice3 == 2) {

            } else {
                System.out.println("Invalid choice.");
            }


            //Mentor Support for the course
            if (choice4 == 1) {
                course = new MentorSupportDecorator(course);
            } else if (choice4 == 2) {

            } else {
                System.out.println("Invalid choice.");
            }


            //Gamification for the course
            if (choice5 == 1) {
                course = new GamificationDecorator(course);
            } else if (choice5 == 2) {

            } else {
                System.out.println("Invalid choice.");
            }

            //module choice
            CourseModule module = null;
            if (choice6 == 1) {
                module = new CourseModule1();
            } else if (choice6 == 2) {
                module = new CourseModule2();
            } else if (choice6 == 3) {
                module = new CourseModule3();
            }

            //quiz
            boolean quiz = false;
            if (choice7 == 1) {
                quiz = true;
            } else if (choice7 == 2) {
                quiz = false;
            }

            courseW = new CourseBuilder()
                    .setCourse(course)
                    .setCourseModule(module)
                    .isQuizzed(quiz)
                    .build();

            studentPortal.enrollInCourse(course);
            notificationService.subscribe(currentUser);

            contentMenu();

        } catch (InputMismatchException e) {
            throw new IllegalArgumentException("Invalid value! Must be an integer.");
        }
    }


    private static void userActiveCoursesMenu() {
        System.out.println("---------- My Active Courses -----------");
        System.out.println("Type '0' to go back to Content Page!");
        System.out.println("Your active courses:");
        if (currentUser.getActiveCourses().isEmpty()) {
            System.out.println("You don't have any active courses!");
        } else {
//            System.out.println("Go to course:");
            int i = 1;
            for (ICourse course : currentUser.getActiveCourses()) {
                System.out.print(i + ". ");
                System.out.println(courseW.info());
                i++;
            }

        }
        System.out.println();
        System.out.print("Go to course(type 0 to go back to Content Page): ");
        int choice = scanner.nextInt();

        if (choice == 0) {
            contentMenu();
        } else {
            courseMenu(currentUser.getActiveCourses().get(choice - 1));
        }


    }

    private static void userCompletedCoursesMenu() {
        System.out.println("---------- My Completed Courses -----------");

        System.out.println("Your completed courses:");
        if (currentUser.getCompletedCourses().isEmpty()) {
            System.out.println("You have not completed any course!");
        } else {
            int i = 1;
            for (ICourse course : currentUser.getCompletedCourses()) {
                System.out.println(i + ". " + courseW.info());
                i++;
            }
        }
        System.out.println();
        System.out.print("Type '0' to go back to - Content Page: ");
        int choice = scanner.nextInt();
        if (choice == 0) {
            contentMenu();
        }
    }


    private static void courseMenu(ICourse course) {
        System.out.println("---------- Course Menu -----------");
        while (true) {
            System.out.println("Course Name: " + course.getName());
            System.out.println("Course Level: " + course.getCourseLevel());
            System.out.println("1. Start the course");
            System.out.println("2. Complete the course");
            System.out.println("3. Go back to - My Active Courses Page");
            System.out.println("4. Test");
            System.out.print("Your choice: ");
            int choice = scanner.nextInt();
            if (choice == 1) {
                studentPortal.startLearning(course);
            } else if (choice == 2) {
                if (course.isStarted()) {
                    studentPortal.completeCourse(course);
                    userActiveCoursesMenu();
                    return;
                } else {
                    studentPortal.completeCourse(course);
                }
            } else if (choice == 4) {
                studentPortal.test(course);
            } else {
                userCompletedCoursesMenu();
            }
        }

    }

    private static void test(ICourse course) {
        studentPortal.test(course);
        courseMenu(course);
    }


    public static void adminMenu() {
        System.out.println("---------- Admin Menu -----------");
        while (true) {
            System.out.println("1. See all users");
            System.out.println("2. Remove user");
            System.out.println("3. Go back to - Main Page");
            System.out.print("Your choice: ");
            int choice;
            try {
                choice = scanner.nextInt();
                if (choice == 1) {
                    int i = 1;
                    if (userManager.getUsers().isEmpty()) {
                        System.out.println("There is no any user!");
                        System.out.println();
                    } else {
                        System.out.println("Users:");
                        for (IUser user : userManager.getUsers()) {
                            System.out.println(i + ". " + user.info());
                            i++;
                        }
                        System.out.println();
                    }
                } else if (choice == 2) {
                    System.out.println("Enter number of user you want to remove: ");
                    int num = scanner.nextInt();
                    userManager.removeUser(userManager.getUsers().get(num - 1));
                } else {
                    mainMenu();
                }
            } catch (InputMismatchException e) {
                throw new IllegalArgumentException("Invalid value! Must be an integer.");
            }
        }
    }

    private static void teacherMenu() {
        System.out.println("---------- Teacher Menu -----------");
        System.out.println("1. See students");
        System.out.println("2. Grade assignments");
        System.out.println("3. Log out");


        System.out.print("Your choice: ");
        int choice = scanner.nextInt();
        if (choice == 1) {
            for(IUser user : notificationService.getReceivers()){
                System.out.println(user.info());
            }
        } else if (choice == 2) {
            notificationService.notifySubscribers("Assignment graded!");
            System.out.println("You have graded Assignment 1!");
        } else {
            mainMenu();
        }
    }
}


