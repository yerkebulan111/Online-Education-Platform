package courses.math;

import course_levels.ICourseLevel;

import java.util.Scanner;

public class GeometryCourse extends MathCourse {
    private final String courseName = "geometry";
    private final Scanner scanner = new Scanner(System.in);
    private boolean isTestCompleted;

    public GeometryCourse(ICourseLevel courseLevel) {
        super(courseLevel);
    }

    @Override
    public String getName() {
        return courseName;
    }

    @Override
    public void deliverContent() {
        System.out.println("Geometry Course Content");
    }

    @Override
    public String info() {
        return "Geometry Course {Level: " + super.getCourseLevel() + "}";
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
