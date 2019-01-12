package unice.ihm.jenkins.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Step implements Serializable {

    private String title;
    private String imgPath;
    private String stepText;

    private List<Keyword> keywords;

    public Step(String title, String imgPath, String stepText) {
        this.title = title;
        this.imgPath = imgPath;
        this.stepText = stepText;
        this.keywords = new ArrayList<>();
    }

    public Step(String title, String imgPath, String stepText, List<Keyword> keywords) {
        this.title = title;
        this.imgPath = imgPath;
        this.stepText = stepText;
        this.keywords = keywords;
    }

    public String getTitle() {
        return title;
    }

    public String getImgPath() {
        return imgPath;
    }

    public String getStepText() {
        return stepText;
    }

    public List<Keyword> getKeywords() {
        return keywords;
    }
}
