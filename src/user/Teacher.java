package user;

import courses.ICourse;

import java.util.ArrayList;

public class Teacher implements IUser{
    private final String email;
    private final String username;
    private final String password;

    public Teacher(String username, String password, String email) {
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
        return "User{username: " + getUsername() + ", email: " + getEmail() + "}";
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
