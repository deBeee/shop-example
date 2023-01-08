package pl.wszib.edu.shop.core;

import pl.wszib.edu.shop.database.SupplementDB;
import pl.wszib.edu.shop.gui.GUI;
import pl.wszib.edu.shop.database.UserDB;
import pl.wszib.edu.shop.model.User;

public class Core {
    final SupplementDB supplementDB = SupplementDB.getInstance();
    final UserDB userDB = UserDB.getInstance();
    final Authenticator authenticator = Authenticator.getInstance();
    final GUI gui = GUI.getInstance();
    private static final Core instance = new Core();

    public Core() {
    }
    boolean isRunning = false;
    int counter = 0;
    public void start() {
        boolean isAuthorized = false;
        while (!isAuthorized) {
            switch (this.gui.showLoginMenu()) {
                case "1":
                    while (!isRunning && counter < 3) {
                        this.authenticator.authenticate(this.gui.readLoginAndPassword());
                        isRunning = this.authenticator.getLoggedUser() != null;
                        if (!isRunning) {
                            System.out.println("Invalid login or password, not authorized !!!");
                        } else isAuthorized = true;
                        counter++;
                    }
                    break;
                case "2":
                    this.userDB.addUser(this.gui.register());
                    break;
                case "3":
                    isAuthorized = true;
                    break;
            }
        }

        while(isRunning) {
            switch (this.gui.showMenu()) {
                case "1":
                    this.gui.listSupplements();
                    break;
                case "2":
                    this.gui.showResult(supplementDB.buySupplement(this.gui.readProductCode(), this.gui.readQuantity()));
                    break;
                case "3":
                    isRunning = false;
                    break;
                case "4":
                    this.authenticator.logout();
                    isRunning = false;
                    System.out.println("Logged out!");
                    start();
                    break;
                case "5":
                    if(this.authenticator.getLoggedUser() != null &&
                            this.authenticator.getLoggedUser().getRole() == User.Role.ADMIN) {
                        this.supplementDB.addSupplement(this.gui.readNewSupplementData());
                        break;
                    }
                case "6":
                    if(this.authenticator.getLoggedUser() != null &&
                            this.authenticator.getLoggedUser().getRole() == User.Role.ADMIN) {
                        this.gui.listUsers();
                        this.gui.showChangeResult(this.userDB.changeUserRole(this.gui.readUser()));
                        break;
                    }
                case "7":
                    if(this.authenticator.getLoggedUser() != null &&
                            this.authenticator.getLoggedUser().getRole() == User.Role.ADMIN) {
                        this.gui.listSupplements();
                        this.gui.showAddResult(this.supplementDB.addQuantity(this.gui.readProductCode(),this.gui.readQuantity()));
                        break;
                    }
                default:
                    System.out.println("Wrong choose !!");
                    break;
            }
        }
    }
    public static Core getInstance(){
        return instance;
    }
}
