public class Joueur {

    private static int numero=100;
    private int numeroJoueur;
    private String nom;
    private int score;
    private String etat;

    public Joueur(int numeroJoueur, String nom, int score, String etat) {

        this.numeroJoueur = numeroJoueur;
        this.nom = nom;
        this.score = score;
        this.etat = etat;
    }
}
