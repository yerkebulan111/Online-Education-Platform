package courses.language;

import course_levels.ICourseLevel;
import courses.language.LanguageCourse;

import java.util.Scanner;

public class EnglishCourse extends LanguageCourse {
    private final String courseName = "english";
    private double courseProgress;
    private Scanner scanner = new Scanner(System.in);
    private boolean isTestCompleted;

    public  EnglishCourse(ICourseLevel courseLevel) {
        super(courseLevel);
    }

    @Override
    public String getName() {
        return courseName;
    }


//    @Override
//    public void makeProgress() {
//        if (courseProgress < 100) {
//            courseProgress += 10;
//        }
//    }
//
//    @Override
//    public double getProgress() {
//        return courseProgress;
//    }

    @Override
    public void deliverContent() {
        System.out.println("English Course Content");
    }

//    @Override
//    public String info() {
//        return "English Course {Level: " + courseLevel.getLevelName() + ", Progress: " + getProgress() + "% }";
//    }

    @Override
    public String info() {
        return "English Course {Level: " + super.getCourseLevel() + "}";
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
