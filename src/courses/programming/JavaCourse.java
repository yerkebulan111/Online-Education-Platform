package courses.programming;

import course_levels.ICourseLevel;

import java.util.Scanner;


public class JavaCourse extends ProgrammingCourse {
    private final String courseName = "java";
    private Scanner scanner = new Scanner(System.in);
    private boolean isTestCompleted;

    public JavaCourse(ICourseLevel courseLevel) {
        super(courseLevel);
    }

    @Override
    public String getName() {
        return courseName;
    }

    @Override
    public void deliverContent() {
        System.out.println("Java Course Content");
    }

    @Override
    public String info() {
        return "Java Course {Level: " + super.getCourseLevel() + "}";
    }

    @Override
    public void test() {
        System.out.println("2 + 3 = ");
        int answer1 = scanner.nextInt();
        System.out.println("4 * 6 = ");
        int answer2 = scanner.nextInt();
        System.out.println("100 / 5 = ");
        int answer3 = scanner.nextInt();

        if  (answer1 == 5 && answer2 == 24 && answer3 == 20) {
            isTestCompleted = true;
        }
    }

    @Override
    public boolean isTestCompleted() {
        return isTestCompleted;
    }
}
