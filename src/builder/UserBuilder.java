package builder;

import courses.ICourse;
import user.IUser;
import user.User;

import java.util.ArrayList;

public class UserBuilder implements IUser {
    private String email;
    private String username;
    private String password;

    public UserBuilder email(String email) {
        this.email = email;
        return this;
    }

    public UserBuilder username(String username) {
        this.username = username;
        return this;
    }
    public UserBuilder password(String password) {
        this.password = password;
        return this;
    }
    public User build() {
        return new User(email,username,password);
    }

    @Override
    public String getEmail() {
        return "";
    }
    @Override
    public String getUsername() {
        return "";
    }
    @Override
    public String getPassword() {
        return "";
    }
    @Override
    public String info() {
        return "";
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
}
