package strategy;

import courses.ICourse;
import user.IUser;

import java.util.ArrayList;

public class RecommendByHistory implements RecommendationService {
    
    @Override
    public void recommendCourses(IUser user) {
        System.out.println("=== Recommendations Based on Your Learning History ===");
        
        ArrayList<ICourse> completedCourses = user.getCompletedCourses();
        ArrayList<ICourse> activeCourses = user.getActiveCourses();
        
        if (completedCourses.isEmpty() && activeCourses.isEmpty()) {
            System.out.println("You haven't enrolled in any courses yet.");
            System.out.println("We recommend starting with beginner courses in any subject!");
            return;
        }
        
        // Show what they've completed
        if (!completedCourses.isEmpty()) {
            System.out.println("You've completed:");
            for (ICourse course : completedCourses) {
                System.out.println("  ✓ " + course.getName() + " (" + course.getCourseLevel() + ")");
            }
            System.out.println();
        }
        
        // Show what they're currently working on
        if (!activeCourses.isEmpty()) {
            System.out.println("You're currently enrolled in:");
            for (ICourse course : activeCourses) {
                System.out.println("  → " + course.getName() + " (" + course.getCourseLevel() + ")");
            }
            System.out.println();
        }
        
        // Recommend next steps based on history
        System.out.println("Based on your history, we recommend:");
        
        if (completedCourses.isEmpty()) {
            System.out.println("- Complete your current courses to unlock advanced recommendations");
        } else {
            // Recommend advanced versions or related courses
            for (ICourse course : completedCourses) {
                String courseName = course.getName();
                String level = course.getCourseLevel();
                
                if (level.equals("Beginner")) {
                    System.out.println("- Try " + courseName + " at Intermediate level");
                } else if (level.equals("Intermediate")) {
                    System.out.println("- Try " + courseName + " at Advanced level");
                } else {
                    System.out.println("- Explore related courses in the same subject");
                }
            }
        }
    }
}
