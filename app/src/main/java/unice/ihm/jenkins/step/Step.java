package unice.ihm.jenkins.step;

import java.io.Serializable;

public class Step implements Serializable {

    private String title;
    private String imgPath;
    private String stepText;

    public Step(String title, String imgPath, String stepText) {
        this.title = title;
        this.imgPath = imgPath;
        this.stepText = stepText;
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

}
