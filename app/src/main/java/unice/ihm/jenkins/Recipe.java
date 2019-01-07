package unice.ihm.jenkins;

import java.io.Serializable;
import java.util.List;

import unice.ihm.jenkins.step.Step;

public class Recipe implements Serializable {

    private List<Step> steps;

    public Recipe(List<Step> steps) {
        this.steps = steps;
    }

    public List<Step> getSteps() {
        return steps;
    }

}
