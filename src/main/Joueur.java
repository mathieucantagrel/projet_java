package main;

import java.util.Comparator;
import java.util.concurrent.atomic.AtomicInteger;

public class Joueur{
    private static AtomicInteger id = new AtomicInteger(0);
    private int numero;
    private String nom;
    private int score;
    private String etat;// etat en string pour les vérifier par equals. et pratique pour faire des comparators(peut être utile dans le dev de l'app)

    public Joueur(String nom) {
        this.numero = id.incrementAndGet();
        this.nom = nom;
        this.score = 0;
        this.etat = "";
    }

    public int getNumero() { return numero; }
    public void setNumero(int numero) { this.numero = numero; }
    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }
    public int getScore() { return score; }
    public void setScore(int score) { this.score = score; }
    public String getEtat() { return etat; }
    protected void setEtat(String etat) { this.etat = etat; }
    public void ajouter_point(int score){this.score+=score;}
    public Joueur saisir(){return this;}
    public void MAJScore(int score){this.setScore(score);}
    public void ChangerEtat(String etat){this.setEtat(etat);}
    public void Afficher()
    {
        System.out.println("Numero : "+numero);
        System.out.println("Nom : "+nom);
        System.out.println("Score : "+score);
        System.out.println("Etat : "+etat);
    }

    @Override
    public String toString() {
        return "Joueur{" +
                "numero=" + numero +
                ", nom='" + nom + '\'' +
                ", score=" + score +
                ", etat='" + etat + '\'' +
                '}';
    }

}
