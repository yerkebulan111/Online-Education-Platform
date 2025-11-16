package strategy;

import courses.ICourse;
import user.IUser;

import java.util.ArrayList;

public class RecommendByActivity implements RecommendationService {

    @Override
    public void recommendCourses(IUser user) {
        System.out.println("--- Recommendations Based on Your Activity ---");

        ArrayList<ICourse> active = user.getActiveCourses();
        ArrayList<ICourse> completed = user.getCompletedCourses();

        if (active.isEmpty() && completed.isEmpty()) {
            System.out.println("You don't have any courses yet.");
            System.out.println("Start with beginner courses!");
            return;
        }

        if (!completed.isEmpty()) {
            System.out.println("Based on your completed courses:");
            for (ICourse course : completed) {
                String name = course.getName();
                String level = course.getCourseLevel();

                if (level.equalsIgnoreCase("Beginner")) {
                    System.out.println("- Try " + name + " at Intermediate level");
                } else if (level.equalsIgnoreCase("Intermediate")) {
                    System.out.println("- Try " + name + " at Advanced level");
                } else {
                    System.out.println("- Explore advanced topics related to " + name);
                }
            }
            System.out.println();
        }

        if (!active.isEmpty()) {
            System.out.println("You are currently studying:");
            for (ICourse course : active) {
                System.out.println("- " + course.getName() + " (" + course.getCourseLevel() + ")");
            }
            System.out.println();
        }
    }
}
