package pl.wszib.edu.shop.database;

import pl.wszib.edu.shop.model.Preworkout;
import pl.wszib.edu.shop.model.Creatine;
import pl.wszib.edu.shop.model.Protein;
import pl.wszib.edu.shop.model.Supplement;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class SupplementDB {
    private List<Supplement> supplements = new LinkedList<>();
    private static final SupplementDB instance = new SupplementDB();

    private SupplementDB(){
        supplements.add(new Creatine("KFD", LocalDate.of(2024,1,23), 79.99, 500,
                "CRK12", 10, Creatine.Type.MONOHYDRATE, Creatine.Flavour.ORANGE));
        supplements.add(new Creatine("Olimp", LocalDate.of(2024,3,21), 65.49, 550,
                "CR034", 5, Creatine.Type.TCM, Creatine.Flavour.LEMON));
        supplements.add(new Creatine("ActivLab", LocalDate.of(2024,4,5), 121.99, 1000,
                "CRA45", 6, Creatine.Type.HYDROCHLORIDE, Creatine.Flavour.GRAPEFRUIT));

        supplements.add(new Preworkout("SynthagenLabs", LocalDate.of(2023,11,15), 59.99, 400,
                "PWS45", 3, Preworkout.Type.BETA_ALANINE, Preworkout.Flavour.LEMONADE));
        supplements.add(new Preworkout("HiTec", LocalDate.of(2023,10,22), 49.99, 350,
                "PWH56", 8, Preworkout.Type.CITRULLINE, Preworkout.Flavour.COLA_LIME));
        supplements.add(new Preworkout("MyVita", LocalDate.of(2024,2,1), 71.99, 600,
                "PWM67", 2, Preworkout.Type.ARGININE, Preworkout.Flavour.TROPICAL));

        supplements.add(new Protein("TrecNutrition", LocalDate.of(2023,7,13), 129.99, 900,
                "PRT78", 7, Protein.Type.MICELAR, Protein.Flavour.BANANA));
        supplements.add(new Protein("OstroVit", LocalDate.of(2023,11,30), 199.99, 2000,
                "PRO89", 1, Protein.Type.ISOLATE, Protein.Flavour.STRAWBERRY));
        supplements.add(new Protein("BioTech", LocalDate.of(2023,3,13), 99.99, 750,
                "PRB90", 4, Protein.Type.VEGAN, Protein.Flavour.VANILLA));
    }

    public List<Supplement> getSupplements() {
        return supplements;
    }
    public void buySupplement(String code, int amount) {
        boolean productFound = false;
        for(Supplement supplement : this.supplements) {
            if(supplement.getProductCode().equals(code)){
                if(supplement.getInStock() >= amount) {
                    supplement.setInStock(supplement.getInStock() - amount);
                    System.out.println("Product bought successfully");
                } else {
                    System.out.println("There is/are only " + supplement.getInStock() + " piece(s) of this product available at this moment, request denied!");
                }
                productFound = true;
            }
        }
        if(!productFound) System.out.println("Invalid product code, request denied");
    }
    public void addSupplement(Supplement supplement) {
        /*
        Supplement[] newSupplements = new Supplement[this.supplements.length +1];
        for(int i = 0; i < this.supplements.length; i++) {
            newSupplements[i] = this.supplements[i];
        }

        newSupplements[newSupplements.length - 1] = supplement;
        this.supplements = newSupplements;
        */
        this.supplements.add(supplement);
    }

    public static SupplementDB getInstance(){
        return instance;
    }
}

