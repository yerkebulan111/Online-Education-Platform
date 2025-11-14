package user;

import courses.ICOurse;
import java.util.ArrayList;

public interface IUser {
    String getEmail();
    String getUsername();
    String getPassword();
    String info();
    void addActiveCourse(ICourse course);
    void completeCourse(ICourse course);
    ArrayList<ICourse> getActiveCourses();
    ArraList<Icourse> getCompletedCourses();

}
