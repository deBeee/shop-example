package pl.wszib.edu.shop.gui;

import org.apache.commons.codec.digest.DigestUtils;
import pl.wszib.edu.shop.database.SupplementDB;
import pl.wszib.edu.shop.model.*;
import pl.wszib.edu.shop.core.Authenticator;
import pl.wszib.edu.shop.database.UserDB;

import java.sql.SQLOutput;
import java.time.LocalDate;
import java.util.Scanner;

public class GUI {
    private final Scanner scanner = new Scanner(System.in);
    final Authenticator authenticator = Authenticator.getInstance();
    final SupplementDB supplementDB = SupplementDB.getInstance();
    final UserDB userDB = UserDB.getInstance();
    private static final GUI instance = new GUI();

    public GUI() {
    }

    public int readAmount() {
        System.out.println("Amount: ");
        return Integer.parseInt(this.scanner.nextLine());
    }
    public String readCode() {
        System.out.println("Code: ");
        return this.scanner.nextLine();
    }
    public void listSupplements() {
      for(Supplement supplement : this.supplementDB.getSupplements()){
          System.out.println(supplement);
      }
    }
    public void listUsers() {
        for (User user : this.userDB.getUsers()) {
            System.out.println(user);
        }
    }
    public String readUser() {
        System.out.println("User: ");
        return this.scanner.nextLine();
    }
    public String readRole() {
        System.out.println("Role:");
        return this.scanner.nextLine();
    }
    public Supplement readNewSupplementData(){
        System.out.println("1. Creatine");
        System.out.println("2. Preworkout");
        System.out.println("3. Protein");
        String choice = this.scanner.nextLine();
        System.out.println("Brand: ");
        String brand = this.scanner.nextLine();
        System.out.println("Expire date: \nYear: ");
        int year = Integer.parseInt(this.scanner.nextLine());
        System.out.println("Month: ");
        int month = Integer.parseInt(this.scanner.nextLine());
        System.out.println("Day: ");
        int day = Integer.parseInt(this.scanner.nextLine());
        LocalDate expireDate = LocalDate.of(year,month,day);

        System.out.println("Price: ");
        Double price = Double.parseDouble(this.scanner.nextLine());
        System.out.println("Weight: ");
        int weight = Integer.parseInt(this.scanner.nextLine());
        System.out.println("Product code: ");
        String productCode = this.scanner.nextLine();
        System.out.println("Quantity: ");
        int quantity = Integer.parseInt(this.scanner.nextLine());

        String typeChoice, flavourChoice;
        switch(choice){
            case "1":
                System.out.println("Type: \n1.Monohydrate\n2.TCM\n3.Hydrochloride");
                typeChoice = this.scanner.nextLine();
                System.out.println("Flavour: \n1.Orange\n2.Lemon\n3.Grapefruit\n4.Orangeade\n5.Natural");
                flavourChoice = this.scanner.nextLine();
                return new Creatine(brand,expireDate,price,weight,productCode,quantity,
                        Creatine.getType(typeChoice),Creatine.getFlavour(flavourChoice));
            case "2":
                System.out.println("Type: \n1.Citrulline\n2.Arginine\n3.Beta alanine");
                typeChoice = this.scanner.nextLine();
                System.out.println("Flavour: \n1.Cola-lime\n2.Lemonade\n3.Tropical\n4.Orangeade");
                flavourChoice = this.scanner.nextLine();
                return new Preworkout(brand,expireDate,price,weight,productCode,quantity,
                        Preworkout.getType(typeChoice),Preworkout.getFlavour(flavourChoice));
            case "3":
                System.out.println("Type: \n1.Isolate\n2.Micelar\n3.Vegan");
                typeChoice = this.scanner.nextLine();
                System.out.println("Flavour: \n1.Coconut\n2.Banana\n3.Strawberry\n4.Vanilla");
                flavourChoice = this.scanner.nextLine();
                return new Protein(brand,expireDate,price,weight,productCode,quantity,
                        Protein.getType(typeChoice),Protein.getFlavour(flavourChoice));
        }
        return null;
    }
    public String showMenu(){
        System.out.println("1. List supplements");
        System.out.println("2. Buy supplements");
        System.out.println("3. Exit");
        if (this.authenticator.getLoggedUser() != null &&
                this.authenticator.getLoggedUser().getRole() == User.Role.ADMIN) {
            System.out.println("4. Add supplement");
            System.out.println("5. Change user's role");
        }
        return scanner.nextLine();
    }
    public String showLoginMenu(){
        System.out.println("1. Login");
        System.out.println("2. Register");
        System.out.println("3. Exit");
        return scanner.nextLine();
    }
    public User register() {
        System.out.println("Login: ");
        String login = this.scanner.nextLine();
        System.out.println("Password: ");
        String password = this.scanner.nextLine();
        return new User(login, DigestUtils.md5Hex(password + authenticator.getSeed()), User.Role.USER);
    }
    public User readLoginAndPassword() {
        User user = new User();
        System.out.println("Login: ");
        user.setLogin(this.scanner.nextLine());
        System.out.println("Password: ");
        user.setPassword(this.scanner.nextLine());
        return user;
    }
    public static GUI getInstance(){
        return instance;
    }
}
