package facade;

import courses.ICourse;
import user.IUser;

import java.util.ArrayList;

public class StudentPortalFacade {
    private IUser user;

    public StudentPortalFacade(IUser currentUser) {
        this.user = currentUser;
    }

    public void enrollInCourse(ICourse course) {
        user.addActiveCourse(course);
        System.out.println("[Student Portal] You successfully enroll in course: " + course.info());
    }

    public void startLearning(ICourse course) {
        if (!user.getActiveCourses().contains(course)) {
            System.out.println("[Student Portal] You must enroll first!");
            return;
        }
        course.setAsStarted();
        System.out.println("[Student Portal] Starting the course: " + course.info());
        course.deliverContent();
        System.out.println();
    }

    public void test(ICourse course) {
        if  (course.isStarted()) {
            System.out.println("[Student Portal] Your course: " + course.info());
            course.test();
        } else{
            System.out.println("[Student Portal:] Course is not started yet! You have to start the course to complete it!");
        }
    }

    public void completeCourse(ICourse course) {
        if (!course.isTestCompleted()) {
//            System.out.println("[Student Portal] Course is not started yet! You have to start the course to complete it!");
            System.out.println("[Student Portal:] You have to pass the test to complete the course!");
            System.out.println();
            return;
        }
        user.completeCourse(course);
        System.out.println("[Student Portal:] Congratulations!");
        System.out.println("[Student Portal:] You completed the course: " + course.info());
        sendNotification(course);
        System.out.println();
    }

    private void sendNotification(ICourse course) {
        System.out.println("[Student Portal:] Notification: Course '" + course.info() + "' marked as completed!");
    }

//    public void showProgress() {
//        System.out.println("Active Courses: " + activeCourses.size());
//        System.out.println("Completed Courses: " + completedCourses.size());
//    }
}
