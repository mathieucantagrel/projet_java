package Question;

public class VF {
    private String question;
    private boolean reponse;

    public VF() {
        this.question = "";
        this.reponse = false;
    }

    public String getQuestion() {
        return question;
    }

    public boolean GetReponse() {
        return reponse;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public void setReponse(boolean reponse) {
        this.reponse = reponse;
    }

    @Override
    public String toString() {
        return "VF{" +
                "question='" + question + '\'' +
                ", reponse=" + reponse +
                '}';
    }
}
