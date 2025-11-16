package builder;

import user.User;

public class UserBuilder {
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
        return new User(email, username, password);
    }
}
