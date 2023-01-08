package pl.wszib.edu.shop.database;

import pl.wszib.edu.shop.model.User;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class UserDB {
    private List<User> users = new ArrayList<>();
    private static final UserDB instance = new UserDB();
    private UserDB(){
        users.add(new User("admin","eb0468abcd9f88e9844fd140fbb6acff", User.Role.ADMIN));
        users.add(new User("dominik", "200d0c3651cf442b1cbde01825eb53be", User.Role.USER));
    }
    public List<User> getUsers() {
        return users;
    }

    public User findByLogin(String login) {
        for (User user : this.users) {
            if (user.getLogin().equals(login)) {
                return user;
            }
        }
        return null;
    }
    public void addUser(User user) {
        /*
        User[] newUsers = new User[this.users.length +1];
        for(int i = 0; i < this.users.length; i++) {
            newUsers[i] = this.users[i];
        }
        newUsers[newUsers.length - 1] = user;
        this.users = newUsers;
        */
        this.users.add(user);
    }
    public void changeUserRole(String login) {
        boolean userFound = false;
        for(User user : this.users) {
            if(user.getLogin().equals(login)){
                userFound = true;
                if(user.getRole() == User.Role.USER) {
                    user.setRole(User.Role.ADMIN);
                }
                else user.setRole(User.Role.USER);
                System.out.println("Role changed succesfully");
            }
        }
        if(!userFound) System.out.println("Invalid user login, operation denied!");
    }
    public static UserDB getInstance() {
        return instance;
    }
}
