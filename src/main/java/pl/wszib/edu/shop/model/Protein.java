package pl.wszib.edu.shop.model;

import java.time.LocalDate;

public class Protein extends Supplement{
    private Type type;
    private Flavour flavour;

    public Protein(String brand, LocalDate expireDate, double price, int weight, String productCode, int inStock, Type type, Flavour flavour) {
        super(brand, expireDate, price, weight, productCode, inStock);
        this.type = type;
        this.flavour = flavour;
    }

    public Protein() {
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
                .append(" protein, flavour: ")
                .append(this.flavour.toString().toLowerCase())
                .toString();
    }
    public static Type getType(String choice){
        switch(choice){
            case "1":
                return Type.ISOLATE;
            case "2":
                return Type.MICELAR;
            case "3":
                return Type.VEGAN;
            default:
                return null;
        }
    }
    public static Flavour getFlavour(String choice){
        switch(choice){
            case "1":
                return Flavour.COCONUT;
            case "2":
                return Flavour.BANANA;
            case "3":
                return Flavour.STRAWBERRY;
            case "4":
                return Flavour.VANILLA;
            default:
                return null;
        }
    }

    public enum Type{
        ISOLATE,
        MICELAR,
        VEGAN
    }
    public enum Flavour {
        COCONUT,
        BANANA,
        STRAWBERRY,
        VANILLA
    }
}
