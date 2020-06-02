package Question;
import java.util.ArrayList;
public class QCM {
    private String question;
    private ArrayList<String> proposition;
    private String reponse;

    public QCM() {
        this.question = "";
        this.proposition = new ArrayList<String>(1);
        this.reponse = "";
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public ArrayList<String> getProposition() {
        return proposition;
    }

    public void setProposition(ArrayList<String> proposition) {
        this.proposition = proposition;
    }

    public String getReponse() {
        return reponse;
    }

    public void setReponse(String reponse) {
        this.reponse = reponse;
    }

    @Override
    public String toString() {
        return "QCM{" +
                "question='" + question + '\'' +
                ", proposition=" + proposition +
                ", reponse='" + reponse + '\'' +
                '}';
    }
}
