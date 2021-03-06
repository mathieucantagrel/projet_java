package Projet.Themes;


import Projet.Question.ListeQuestions;
import Projet.Question.Question;

public class Themes<T> {
    private String nom;
    private boolean indicateur;
    private ListeQuestions<Question<T>> listequestion;

    public Themes(String nom) {
        this.nom = nom;
        this.indicateur = false;
        this.listequestion = new ListeQuestions<Question<T>>();
    }

    public String getNom() { return nom; }
    public void setNom(String nom){this.nom=nom;}
    public boolean getIndicateur(){return this.indicateur;}
    public void setIndicateur(boolean bool){this.indicateur = bool;}
    public void ModifierTheme(String nom){this.nom = nom;}
    public String SelectionnerTheme(){
        this.indicateur= true;
        return this.nom;

    }
    public void Afficher(){
        System.out.println(this.nom);
        System.out.println(this.indicateur);
    }
    public ListeQuestions<Question<T>> SaisirListeQuestions() { return this.listequestion; }
    //public Projet.Themes Saisir(){return this;}
}
