package Themes;


import Question.ListeQuestions;
import Question.Question;

import java.util.ArrayList;

public class Themes<T> {
    private String nom;
    private boolean indicateur;
    private ListeQuestions<Question<T>> listequestion;

    public Themes(String nom) {
        this.nom = nom;
        this.indicateur = false;
        this.listequestion = new ListeQuestions<Question<T>>();
    }

    public String getNom() {
        return nom;
    }

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
    //public Themes Saisir(){return this;}
}
