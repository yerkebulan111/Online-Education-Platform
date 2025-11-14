package courses.programming;

import course_levels.ICourseLevel;

import java.util.Scanner;

public class PythonCourse extends ProgrammingCourse{
    private final String courseName = "python";
    private Scanner scanner = new Scanner(System.in);
    private boolean isTestCompleted;

    public PythonCourse(ICourseLevel courseLevel) {
        super(courseLevel);
    }

    @Override
    public String getName() {
        return courseName;
    }

    @Override
    public void deliverContent() {
        System.out.println("Python Course Content");
    }

    @Override
    public String info() {
        return "Python Course {Level: " + super.getCourseLevel() + "}";
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
