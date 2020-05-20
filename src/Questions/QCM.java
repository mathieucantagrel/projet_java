package Questions;

public class QCM {

    private String description = "";
    private String reponse1 = "";
    private String reponse2 = "";
    private String reponse3 = "";
    private String bonneReponse = "";

    public QCM(String description, String reponse1, String reponse2, String reponse3, String bonneReponse) {
        this.description = description;
        this.reponse1 = reponse1;
        this.reponse2 = reponse2;
        this.reponse3 = reponse3;
        this.bonneReponse = bonneReponse;
    }

    public String getDescription() {
        return description;
    }

    public String getReponse1() {
        return reponse1;
    }

    public String getReponse2() {
        return reponse2;
    }

    public String getReponse3() {
        return reponse3;
    }

    public String getBonneReponse() {
        return bonneReponse;
    }

//    public void Afficher(){
//        System.out.println(description);
//    }
}
