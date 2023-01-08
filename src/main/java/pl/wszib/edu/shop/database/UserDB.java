package pl.wszib.edu.shop.database;

import pl.wszib.edu.shop.model.User;

public class UserDB {
    private User[] users = new User[2];
    private static final UserDB instance = new UserDB();
    private UserDB(){
        this.users[0] = new User("admin","eb0468abcd9f88e9844fd140fbb6acff", User.Role.ADMIN);
        this.users[1] = new User("dominik", "200d0c3651cf442b1cbde01825eb53be", User.Role.USER);
    }
    public User[] getUsers() {
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
        User[] newUsers = new User[this.users.length +1];
        for(int i = 0; i < this.users.length; i++) {
            newUsers[i] = this.users[i];
        }
        newUsers[newUsers.length - 1] = user;
        this.users = newUsers;
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
