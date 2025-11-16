package strategy;

import courses.ICourse;
import user.IUser;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class RecommendByActivity implements RecommendationService {
    private final Set<Integer> activelyOpened = new HashSet<>();

    public void addActivelyOpened(int number) {
        activelyOpened.add(number);
    }

    @Override
    public void recommendCourses(IUser user) {
        ArrayList<String> courses = new ArrayList<>();
        
        for (Integer number : activelyOpened) {
            switch (number) {
                case 1:
                    courses.add("Algebra");
                    break;
                case 2:
                    courses.add("Geometry");
                    break;
                case 3:
                    courses.add("Java");
                    break;
                case 4:
                    courses.add("Python");
                    break;
                case 5:
                    courses.add("English");
                    break;
                case 6:
                    courses.add("Spanish");
                    break;
            }
        }
        
        System.out.println("Courses that you have ever opened:");
        if (courses.isEmpty()) {
            System.out.println("No courses found.");
        } else {
            for (String course : courses) {
                System.out.println(course);
            }
        }
    }
}
