package decorator;

import courses.ICourse;

public class GamificationDecorator extends CourseDecorator {

    public GamificationDecorator(ICourse course) {
        super(course);
    }

    public void addPoints() {
        System.out.println("Adding points");
    }

    @Override
    public String info() {
        return super.info() + " + Gamification";
    }
}
