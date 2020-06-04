package main;

import java.util.Comparator;
import java.util.Random;
import java.util.Vector;

public class EnsJoueurs {
    Vector<Joueur> liste_joueur;

    public EnsJoueurs() {
        this.liste_joueur = new Vector<>(19);
    }

    public Vector<Joueur> getListe_joueur() {
        return liste_joueur;
    }

    public void setListe_joueur(Vector<Joueur> liste_joueur) {
        this.liste_joueur = liste_joueur;
    }
    public void Créer(){
        //Methode permettant de créer les 20 joueurs demandés avec leurs état en "attente"

        Joueur player;
        for(int i = 0;i<=19;i++)
        {
            player = new Joueur("Joueur "+String.valueOf(i)+"");
            player.setEtat("En attente");
            this.liste_joueur.add(i,player);
        }
    }
    public void Afficher(){
        for (Joueur player:liste_joueur
             ) {
            System.out.println(player.getNom());
        }
    }
    public Joueur Selectionner_Joueur()//Selection de Joueur de manière aléatoire et vérifie qu'il n'est pas déjà selectionné.
    {
        Random rd = new Random();
        int nb = 0;
        while(true)
        {
            nb = rd.nextInt(this.liste_joueur.size());
            if(this.liste_joueur.get(nb).getEtat().equals("Selectionné")){
                System.out.println("Déjà selectionné!!");
                continue;
            }
            else
            {
                this.liste_joueur.get(nb).setEtat("Selectionné");
                return this.liste_joueur.get(nb);
            }

        }
    }

}
