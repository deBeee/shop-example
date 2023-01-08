package pl.wszib.edu.shop.core;

import org.apache.commons.codec.digest.DigestUtils;
import pl.wszib.edu.shop.model.User;
import pl.wszib.edu.shop.database.UserDB;


public class Authenticator {
    final UserDB userDB = UserDB.getInstance();
    private User loggedUser = null;
    private final String seed = "OK4wkjJ15XD@T*41pO9M21t^rLhlt#&9srznHWyo";
    private static final Authenticator instance = new Authenticator();

    private Authenticator() {
    }

    public void authenticate(User user) {
        User userFromDB = this.userDB.findByLogin(user.getLogin());
        if(userFromDB != null && userFromDB.getPassword().equals(
                DigestUtils.md5Hex(user.getPassword() + this.seed))) {
            this.loggedUser = userFromDB;
        }
    }
    public User getLoggedUser() {
        return loggedUser;
    }
    public String getSeed() {
        return seed;
    }
    public static Authenticator getInstance() {
        return instance;
    }
}
