package strategy;

import courses.ICourse;

import java.util.ArrayList;
import java.util.List;

public class RecommendByActivity implements RecommendationService {
    private List<String> courses = new ArrayList<>();
    private ArrayList<Integer> activelyOpened = new ArrayList<>();

    public void addActivelyOpened(int number) {
        for(Integer i : activelyOpened) {
            if(i==number) activelyOpened.remove(i);
        }
        activelyOpened.add(number);
    }

    @Override
    public void recommendCourses() {
        setStrategy();
        System.out.println("Courses that you have ever opened:");
        for (String course : courses) {
            System.out.println(course);
        }
    }

    public void setStrategy() {
        for(Integer number : activelyOpened ) {
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
    }
}
