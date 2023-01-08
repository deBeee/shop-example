package pl.wszib.edu.shop.model;

import java.time.LocalDate;


public final class Creatine extends Supplement{

    private Type type;
    private Flavour flavour;

    public Creatine(String brand, LocalDate expireDate, double price, int weight, String productCode, int inStock, Type type, Flavour flavour) {
        super(brand, expireDate, price, weight, productCode, inStock);
        this.type = type;
        this.flavour = flavour;
    }

    public Creatine() {
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
                .append(" creatine, flavour: ")
                .append(this.flavour.toString().toLowerCase())
                .toString();
    }
    public static Type getType(String choice){
        switch(choice){
            case "1":
                return Type.MONOHYDRATE;
            case "2":
                return Type.TCM;
            case "3":
                return Type.HYDROCHLORIDE;
            default:
                return null;
        }
    }
    public static Flavour getFlavour(String choice){
        switch(choice){
            case "1":
                return Flavour.ORANGE;
            case "2":
                return Flavour.LEMON;
            case "3":
                return Flavour.GRAPEFRUIT;
            case "4":
                return Flavour.ORANGEADE;
            case "5":
                return Flavour.NATURAL;
            default:
                return null;
        }
    }
    public enum Type{
        MONOHYDRATE,
        TCM,
        HYDROCHLORIDE
    }
    public enum Flavour {
        ORANGE,
        LEMON,
        GRAPEFRUIT,
        ORANGEADE,
        NATURAL
    }
}
