package user;

import courses.ICourse;

import java.util.ArrayList;

public class Admin implements IUser {
    private String username = "admin";
    private String password = "admin";
    private String email = "admin";

    public Admin(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String info() {
        return "Admin{ username: " + username + ", email: " + email + " }";
    }





    @Override
    public void addActiveCourse(ICourse course) {

    }

    @Override
    public void completeCourse(ICourse course) {

    }

    @Override
    public ArrayList<ICourse> getActiveCourses() {
        return null;
    }

    @Override
    public ArrayList<ICourse> getCompletedCourses() {
        return null;
    }

    @Override
    public void getNotification(String message) {

    }
}
