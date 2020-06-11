package Projet.main;

import Projet.Question.ListeQuestions;

import java.util.concurrent.atomic.AtomicInteger;

public class Joueur {
    private static AtomicInteger id = new AtomicInteger(10);
    private int numero;
    private String nom;
    private int score;
    private String etat;
    private int[] Chrono = new int[3];

    public Joueur(String nom) {
        this.numero = (id.incrementAndGet())*10;
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
    public void setEtat(String etat) { this.etat = etat; }
    public Joueur saisir(){return this;}
    public void ChangerEtat(String etat){this.setEtat(etat);}

    public void MAJScore(int phase)
    {
        if(phase == 1)
        { this.score += 2; }
        else if(phase == 2)
        { this.score += 3; }
        else
        { this.score += 5; }
    }

    public int[] getChrono() {
        return Chrono;
    }

    public void setChrono(int[] chrono) {
        Chrono = chrono;
    }

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
