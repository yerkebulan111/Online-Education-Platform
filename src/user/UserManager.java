package user;

import java.util.ArrayList;

public class UserManager {
    private final ArrayList<IUser> users = new ArrayList<>();

    public ArrayList<IUser> getUsers() {
        return users;
    }
    public IUser registerUser(IUser user) {
        users.add(user);
        System.out.println("User registed successfully: " + user.info());
        System.out.println("Welcome to LMS");
        return user;
    }

    public IUser loginUser(String username, String password) {
        for (IUser user1 : users) {
            if (user1.getUsername().equals(username) && user1.getPassword().equals(password)) {
                System.out.println("User logged in successfully");
                return user1;

            }
        }
        System.out.println("User not found or invalid credentials");
        return null;
    }
    public void removeUser(IUser user) {
        users.remove(user);
        System.out.println("User deleted successfully");
    }
}
