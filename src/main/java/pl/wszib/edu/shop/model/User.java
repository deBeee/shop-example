package pl.wszib.edu.shop.model;

public class User {
    private String login;
    private String password;
    private Role role;

    public User(String login, String password, Role role) {
        this.login = login;
        this.password = password;
        this.role = role;
    }

    public User() {
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }
    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return new StringBuilder()
                .append("Login: ")
                .append(this.login)
                .append(" Role: ")
                .append(this.role)
                .toString();
    }

    public enum Role {
        ADMIN,
        USER
    }
}
