package strategy;

import courses.ICourse;
import user.IUser;

import java.util.ArrayList;

public class RecommendByActivity implements RecommendationService {
    
    @Override
    public void recommendCourses(IUser user) {
        System.out.println("--- Recommendations Based on Your Activity ---");
        
        ArrayList<ICourse> activeCourses = user.getActiveCourses();
        
        if (activeCourses.isEmpty()) {
            System.out.println("You don't have any active courses yet.");
            System.out.println("We recommend starting with beginner courses!");
            return;
        }
        
        System.out.println("Based on your current activity, we recommend:");
        

        for (ICourse course : activeCourses) {
            String courseName = course.getName();
            String level = course.getCourseLevel();
            
            System.out.println("- Continue with: " + courseName + " (" + level + ")");
            

            if (courseName.contains("Algebra")) {
                System.out.println("Try Geometry next!");
            } else if (courseName.contains("Geometry")) {
                System.out.println("Try Algebra or advanced Math courses!");
            } else if (courseName.contains("Java")) {
                System.out.println("Try Python to learn another programming language!");
            } else if (courseName.contains("Python")) {
                System.out.println("Try Java to learn object-oriented programming!");
            } else if (courseName.contains("English")) {
                System.out.println("Try Spanish to learn another language!");
            } else if (courseName.contains("Spanish")) {
                System.out.println("Try English or other language courses!");
            }
        }
    }
}
