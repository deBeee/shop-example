package pl.wszib.edu.shop;
import org.apache.commons.codec.digest.DigestUtils;
import pl.wszib.edu.shop.core.Core;
public class App {
    public static void main(String[] args) {
        //System.out.println(DigestUtils.md5Hex("dominik" + "OK4wkjJ15XD@T*41pO9M21t^rLhlt#&9srznHWyo"));
        Core.getInstance().start();
    }

}
