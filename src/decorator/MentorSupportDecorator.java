package decorator;

import courses.ICourse;

public class MentorSupportDecorator extends CourseDecorator {

    public MentorSupportDecorator(ICourse course) {
        super(course);
    }

    public void addMentor() {
        System.out.println("Adding mentor");
    }

    @Override
    public String info() {
        return super.info() + " + Mentor Support";
    }

}
