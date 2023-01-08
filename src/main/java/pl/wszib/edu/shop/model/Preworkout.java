package pl.wszib.edu.shop.model;

import java.time.LocalDate;

public final class Preworkout extends Supplement {
    private Type type;
    private Flavour flavour;

    public Preworkout(String brand, LocalDate expireDate, double price, int weight, String productCode, int inStock, Type type, Flavour flavour) {
        super(brand, expireDate, price, weight, productCode, inStock);
        this.type = type;
        this.flavour = flavour;
    }

    public Preworkout() {
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Flavour getFlavour() {
        return flavour;
    }

    public void setFlavour(Flavour flavour) {
        this.flavour = flavour;
    }

    @Override
    public String toString() {
        return new StringBuilder(super.toString())
                .append(" , type: ")
                .append(this.type.toString().toLowerCase())
                .append(" preworkout, flavour: ")
                .append(this.flavour.toString().toLowerCase())
                .toString();
    }
    public static Type getType(String choice){
        switch(choice){
            case "1":
                return Type.CITRULLINE;
            case "2":
                return Type.ARGININE;
            case "3":
                return Type.BETA_ALANINE;
            default:
                return null;
        }
    }
    public static Flavour getFlavour(String choice){
        switch(choice){
            case "1":
                return Flavour.COLA_LIME;
            case "2":
                return Flavour.LEMONADE;
            case "3":
                return Flavour.TROPICAL;
            case "4":
                return Flavour.ORANGEADE;
            default:
                return null;
        }
    }

    public enum Type{
        CITRULLINE,
        ARGININE,
        BETA_ALANINE
    }
    public enum Flavour {
        COLA_LIME,
        LEMONADE,
        TROPICAL,
        ORANGEADE
    }
}
