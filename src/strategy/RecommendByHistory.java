package strategy;

import courses.ICourse;

import java.util.ArrayList;
import java.util.List;


public class RecommendByHistory implements RecommendationService {
    private List<String> courses;
    private List<ICourse> history = new ArrayList<>();

    public void addToHistory(ICourse course) {
        if (!history.contains(course)) {
            history.add(course);
        }
    }

    @Override
    public void recommendCourses() {
        System.out.println("Courses that you have ever enrolled:");
        for (ICourse course : history) {
            System.out.println( course.getName() );
        }
    }


}
