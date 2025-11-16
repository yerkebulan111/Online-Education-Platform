package strategy;

import courses.ICourse;
import user.IUser;

import java.util.ArrayList;

public class RecommendByHistory implements RecommendationService {
    @Override
    public void recommendCourses(IUser user) {
        System.out.println("Courses that you have ever enrolled:");
        ArrayList<ICourse> completedCourses = user.getCompletedCourses();
        ArrayList<ICourse> activeCourses = user.getActiveCourses();
        
        if (completedCourses.isEmpty() && activeCourses.isEmpty()) {
            System.out.println("No courses found.");
            return;
        }
        
        for (ICourse course : completedCourses) {
            System.out.println(course.getName());
        }
        for (ICourse course : activeCourses) {
            System.out.println(course.getName());
        }
    }
}
