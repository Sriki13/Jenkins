package unice.ihm.jenkins.entities;

import java.text.DecimalFormat;

public class Ingredient {

    private String name;
    private double quantity;
    private String unit;

    public Ingredient(String name, double quantity, String unit) {
        this.name = name;
        this.quantity = quantity;
        this.unit = unit;
    }

    public String getName() {
        return name;
    }

    public String getQuantityFormat() {
        DecimalFormat format = new DecimalFormat("0.#");
        return format.format(quantity);
    }

    public String getUnitFormat() {
        if (unit.length() > 4) {
            return " " + unit;
        }
        return unit;
    }

    public String getDescription() {
        return name + " " + getQuantityAsString();
    }

    public String getQuantityAsString() {
        return quantity + " " + unit;
    }

    @Override
    public String toString() {
        return "Ingredient{" +
                "name='" + name + '\'' +
                ", quantity=" + quantity +
                ", unit='" + unit + '\'' +
                '}';
    }
}
