package unice.ihm.jenkins.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Keyword implements Serializable {

    private String word;
    private List<String> alternatives;
    private String explanation;

    public Keyword(String word, String explanation) {
        this.word = word;
        this.explanation = explanation;
        this.alternatives = new ArrayList<>();
    }

    public Keyword(String word, List<String> alternatives, String explanation) {
        this.word = word;
        this.alternatives = alternatives;
        this.explanation = explanation;
    }

    public String getWord() {
        return word;
    }

    public String getExplanation() {
        return explanation;
    }

    public boolean matches(String text) {
        if (text.contains(word)) {
            return true;
        } else {
            for (String alt : alternatives) {
                if (text.contains(alt)) {
                    return true;
                }
            }
        }
        return false;
    }

}
