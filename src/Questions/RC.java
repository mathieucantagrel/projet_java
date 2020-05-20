package Questions;

public class RC {

    private String description = "";
    private String bonneReponse = "";

    public RC(String description, String bonneReponse) {
        this.description = description;
        this.bonneReponse = bonneReponse;
    }

    public String getDescription() {
        return description;
    }

    public String getBonneReponse() {
        return bonneReponse;
    }

    public void Afficher(){
        System.out.println(description);
    }
}
