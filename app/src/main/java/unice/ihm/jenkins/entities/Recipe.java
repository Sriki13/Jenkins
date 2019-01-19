package unice.ihm.jenkins.entities;

import android.support.annotation.Nullable;

import java.io.Serializable;
import java.util.List;

public class Recipe implements Serializable {

    private String title;
    private String description;
    private String imgPath;
    private List<Step> steps;
    private List<Ingredient> ingredients;
    private String time;
    private int nbPeople;

    public Recipe(String title, String description, @Nullable String imgPath, String time,
                  int nbPeople, List<Ingredient> ingredients, List<Step> steps) {
        this.title = title;
        this.description = description;
        this.steps = steps;
        this.imgPath = imgPath;
        this.ingredients = ingredients;
        this.time = time;
        this.nbPeople = nbPeople;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public List<Step> getSteps() {
        return steps;
    }

    public String getImgPath() {
        return imgPath;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getTime() {
        return time;
    }

    public int getNbPeople() {
        return nbPeople;
    }
}
