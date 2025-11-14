package user;

import courses.ICourse;

import java.util.ArrayList;
public class User implements IUser {
    private String email;
    private String username;
    private String password;

    private final ArrayList<ICourse> activeCourses = new ArrayList<>();
    private final ArrayList<ICourse> completedCourses = new ArrayList<>();

    public User(){

    }

    public User(String email, String username, String password) {
        this.email = email;
        this.username = username;
        this.password = password;
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
    public void addActiveCourse(ICourse course){
        activeCourses.add(course);
    }

    @Override
    public void completeCourse(ICourse course){
        completedCourses.add(course);
        activeCourses.remove(course);
    }
    @Override
    public ArrayList<ICourse> getActiveCourses(){
        return activeCourses;
    }
    @Override
    public ArrayList<ICourse> getCompletedCourses(){
        return completedCourses;
    }
    @Override
    public String info() {
        return "User{username: " + getUsername() + ", email: " + getEmail() + "}";
    }
}
