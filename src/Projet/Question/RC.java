package Projet.Question;

public class RC {
    private String question;
    private String reponse;

    public RC() {
        this.question = "";
        this.reponse = "";
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getReponse() {
        return reponse;
    }

    public void setReponse(String reponse) {
        this.reponse = reponse;
    }

    @Override
    public String toString() {
        return "RC{" +
                "question='" + question + '\'' +
                ", reponse='" + reponse + '\'' +
                '}';
    }

}
