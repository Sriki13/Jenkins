package unice.ihm.jenkins.entities;

import android.support.annotation.Nullable;

import java.io.Serializable;
import java.util.List;

public class Recipe implements Serializable {

    private String description;
    private String imgPath;
    private List<Step> steps;
    private List<Ingredient> ingredients;
    private String time;

    public Recipe(String description, @Nullable String imgPath, String time, List<Ingredient> ingredients, List<Step> steps) {
        this.description = description;
        this.steps = steps;
        this.imgPath = imgPath;
        this.ingredients = ingredients;
        this.time = time;
    }

    public List<Step> getSteps() {
        return steps;
    }

}
