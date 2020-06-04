//TODO mettre en place un minuteur pour gerer les conflits
//TODO mettre en place la phase 3

package front;

import Question.Question;
import Question.QCM;
import Question.VF;
import Question.RC;
import Question.ListeQuestions;
import Themes.*;

import main.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.UncheckedIOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;


public class Eureka_front implements Cloneable{

    private ArrayList<Themes> liste_theme;// Liste des différents thèmes (nommés sur les dossiers dans fichier)
    private EnsJoueurs liste_player;// liste de joeurs (les 20 joueurs)
    private ArrayList<Joueur> liste_candidat;// liste de 4 Joueurs jouant au jeux
    private Joueur joueur_en_cours;// Le joueur répondant à la question
    private int num_candidat = -1;// Numéro du joueur en cours (1,2,3 ou 4). Peut être mis en format random pour
    //Mettre un ordre aléatoire de chaque joueur pour le passage.
    private int indexTheme=0;
    private int niveauQuestion = 1;
    private int phase = 1;// variable de Phase.
    private ArrayList<Themes> Phase2ListeThemes;
    private int scoreQuestion = 2;

    //GRAPHISME
    private JFrame f;
    private JPanel JpanelJeux;
    private JPanel QCMJpanel;
    private JPanel VFJpanel;
    private JPanel RCJpanel;
    private JLabel QuestionQCMLabel;
    private JButton Proposition1Button;
    private JButton Proposition2Button;
    private JButton Proposition3Button;
    private JLabel QuestionVF;
    private JButton Vrai;
    private JButton Faux;
    private JLabel QuestionRC;
    private JButton ValidRCButton;
    private JTextArea ReponseText;
    private JPanel Descrition1;
    private JPanel Description2;
    private JPanel Description3;
    private JLabel Level1;
    private JLabel Theme1;
    private JLabel Joueur1;
    private JLabel Level2;
    private JLabel Theme2;
    private JLabel Joueur2;
    private JLabel Level3;
    private JLabel Theme3;
    private JLabel Joueur3;
    private JPanel EnterPseudoJpanel;
    private JTextArea JoueurtextArea1;
    private JTextArea JoueurtextArea2;
    private JTextArea JoueurtextArea3;
    private JTextArea JoueurtextArea4;
    private JButton validerButton;
    private JComboBox ListTheme;
    private JLabel JoueurLabel;
    private JButton SelectThemeButton;
    private JPanel SelectThemeJpanel;
    private JPanel Phase2SelectThemeJPanel;
    private JLabel NomJoueurLabel;
    private JComboBox ChoixThemePhase2ComboBox;
    private JButton ValiderThemePhase2Button;
    private JPanel AffichageScorePhase1;
    private JLabel AffichageScoreLabel;
    private JButton FinPhaseButton;
    private JLabel NomPremierLabel;
    private JLabel ScorePremierLabel;
    private JLabel NomDeuxiemeLabel;
    private JLabel ScoreDeuxiemeLabel;
    private JLabel NomTroisiemeLabel;
    private JLabel ScoreTroisiemeLabel;
    private JLabel NomQuatriemeLabel;
    private JLabel ScoreQuatriemeLabel;
    private String reponse;

    public Eureka_front() {//initialisation d'un premier frame.
        this.f = new JFrame("Eureka");
        f.setContentPane(EnterPseudoJpanel);
        f.setSize(600,175);
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        f.setLocationRelativeTo(null);
        liste_theme = new ArrayList<Themes>(9);
        liste_player  = new EnsJoueurs();
        liste_candidat = new ArrayList<Joueur>(3);
        f.setVisible(true);
        ValidRCButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {// Devellopement de chaque interaction des boutons.

                if(ReponseText.getText().toLowerCase().equals(reponse.toLowerCase()))
                {
                    liste_candidat.get(num_candidat).ajouter_point(scoreQuestion);
                }
                ReponseText.setText("");

                reload_display_select_theme();

            }
        });
        Vrai.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean vrai = true;

                if(reponse.equals(String.valueOf(vrai)))
                {
                    liste_candidat.get(num_candidat).ajouter_point(scoreQuestion);
                }


                reload_display_select_theme();

            }
        });
        Faux.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean faux = false;

                if(reponse.equals(String.valueOf(faux)))
                {
                    liste_candidat.get(num_candidat).ajouter_point(2);
                }

                reload_display_select_theme();


            }
        });
        Proposition1Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                if (Proposition1Button.getText().equals(reponse)) {
                    liste_candidat.get(num_candidat).ajouter_point(2);
                }
                reload_display_select_theme();
            }
        });
        Proposition2Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                if(Proposition2Button.getText().equals(reponse))
                {
                    liste_candidat.get(num_candidat).ajouter_point(2);
                }
                reload_display_select_theme();

            }
        });
        Proposition3Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                if(Proposition3Button.getText().equals(reponse))
                {
                    liste_candidat.get(num_candidat).ajouter_point(2);
                }
                reload_display_select_theme();

            }
        });
        validerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                liste_candidat.get(0).setNom(JoueurtextArea1.getText());
                liste_candidat.get(1).setNom(JoueurtextArea2.getText());
                liste_candidat.get(2).setNom(JoueurtextArea3.getText());
                liste_candidat.get(3).setNom(JoueurtextArea4.getText());

                reload_display_select_theme();


            }
        });
        SelectThemeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                afficher_bonne_question(indexTheme);

                indexTheme++;
                indexTheme%=10;

            }
        });

        FinPhaseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (phase==2) {

                    Phase2ListeThemes = new ArrayList<>();

                    Collections.shuffle(liste_theme);

                    for (int i = 0; i < 6; i++) {
                        Phase2ListeThemes.add(liste_theme.get(i));
                        ChoixThemePhase2ComboBox.addItem(liste_theme.get(i).getNom());
                    }
                }

                reload_display_select_theme();
            }
        });

        ValiderThemePhase2Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int index=0;

                for (int i=0; i<Phase2ListeThemes.size(); i++){
                    if (Phase2ListeThemes.get(i).getNom().equals(ChoixThemePhase2ComboBox.getSelectedItem())){
                        index = i;
                        break;
                    }
                }

                afficher_bonne_question(index);

            }
        });
    }


    public void reload_display_select_theme()//Remettre en place la checkbox avec les thèmes choisis.
    {
        num_candidat++;

        if (phase==1) {
            try {
                this.JoueurLabel.setText(liste_candidat.get(num_candidat).getNom());
            } catch (IndexOutOfBoundsException e) {
                num_candidat %= 4;
                niveauQuestion++;
                if (niveauQuestion == 4) {
                    AfficherScore();
                    phase_de_jeu();
                    return;
                }
                this.JoueurLabel.setText(liste_candidat.get(num_candidat).getNom());
            }
            this.f.setContentPane(SelectThemeJpanel);
        }else if(phase==2){
            try {
                this.NomJoueurLabel.setText(liste_candidat.get(num_candidat).getNom());
            }catch (IndexOutOfBoundsException e){
                num_candidat%=3;
                this.NomJoueurLabel.setText(liste_candidat.get(num_candidat).getNom());
            }
            if (Phase2ListeThemes.size()==0){
                AfficherScore();
                phase_de_jeu();
                return;
            }

            this.f.setContentPane(Phase2SelectThemeJPanel);
        }
        this.f.revalidate();
    }

    public void init()//Initialisation des checkbox, de la liste et lecture des fichiers pour les questions pour chaque liste de thèmes.
    {
        Themes sport = new Themes("Sport");
        Themes histoire = new Themes("Histoire");
        Themes geographie = new Themes("Géographie");
        Themes mathématique = new Themes("Mathématique");
        Themes littérature = new Themes("Littérature");
        Themes culture_générale = new Themes("Culture générale");
        Themes informatique = new Themes("Informatique");
        Themes automobile = new Themes("Automobile");
        Themes politique = new Themes("Politique");
        Themes ville_française = new Themes("Ville Française");
        this.ajouter_theme(sport,0);
        this.ajouter_theme(histoire,1);
        this.ajouter_theme(geographie,2);
        this.ajouter_theme(mathématique,3);
        this.ajouter_theme(littérature,4);
        this.ajouter_theme(culture_générale,5);
        this.ajouter_theme(informatique,6);
        this.ajouter_theme(automobile,7);
        this.ajouter_theme(politique,8);
        this.ajouter_theme(ville_française,9);


        creation_question();
        liste_candidat = new ArrayList<Joueur>(3);
        liste_player.Créer();
        liste_candidat.add(0,liste_player.Selectionner_Joueur());
        liste_candidat.add(1,liste_player.Selectionner_Joueur());
        liste_candidat.add(2,liste_player.Selectionner_Joueur());
        liste_candidat.add(3,liste_player.Selectionner_Joueur());
    }

    public void phase_de_jeu()
    {
        phase++;
        if (phase==1){
            niveauQuestion=2;
            scoreQuestion=3;
            FinPhase();
        }else if(phase==2){
            scoreQuestion=5;
            FinPhase();
        }
    }
    public void ajouter_theme(Themes theme,int nb) { this.liste_theme.add(nb,theme); }// Ajout d'un theme

    public void creation_question()// Lecture de fichier dans la classe ListeQuestion.
    {
        for(int n=0;n<liste_theme.size();n++)
        {
            this.liste_theme.get(n).SaisirListeQuestions().charger_question_QCM(liste_theme.get(n).getNom());
            this.liste_theme.get(n).SaisirListeQuestions().charger_question_RC(liste_theme.get(n).getNom());
            this.liste_theme.get(n).SaisirListeQuestions().charger_Question_VF(liste_theme.get(n).getNom());

        }
    }

    public void afficher_bonne_question(int n)// Methode mère du cote graphique
    {
        joueur_en_cours = liste_candidat.get(num_candidat);

        Random rd = new Random();
        int nb = 0;
        do {
            nb = rd.nextInt(this.liste_theme.get(n).SaisirListeQuestions().GetListeQuestion().size());
        }while (this.liste_theme.get(n).SaisirListeQuestions().SelectionnerQuestion(nb).getLevel()!=niveauQuestion);

        switch (this.liste_theme.get(n).SaisirListeQuestions().SelectionnerQuestion(nb).saisir().getClass().getName()){
            case "Question.QCM":{

                this.QuestionQCMLabel.setText(this.liste_theme.get(n).SaisirListeQuestions().SelectionnerQuestion(nb).QCMtype().getQuestion());
                this.Proposition1Button.setText(this.liste_theme.get(n).SaisirListeQuestions().SelectionnerQuestion(nb).QCMtype().getProposition().get(0));
                this.Proposition2Button.setText(this.liste_theme.get(n).SaisirListeQuestions().SelectionnerQuestion(nb).QCMtype().getProposition().get(1));
                this.Proposition3Button.setText(this.liste_theme.get(n).SaisirListeQuestions().SelectionnerQuestion(nb).QCMtype().getReponse());
                if (phase==1){
                    this.Theme1.setText(this.liste_theme.get(n).SelectionnerTheme());
                } else if (phase == 2) {
                    this.Theme1.setText(Phase2ListeThemes.get(n).SelectionnerTheme());
                }
                this.Joueur1.setText(joueur_en_cours.getNom());
                this.Level1.setText("Niveau " + String.valueOf(this.liste_theme.get(n).SaisirListeQuestions().SelectionnerQuestion(nb).getLevel()));
                this.f.setContentPane(this.QCMJpanel);
                this.reponse = this.liste_theme.get(n).SaisirListeQuestions().SelectionnerQuestion(nb).QCMtype().getReponse();
                break;
            }
            case "Question.VF":{
                this.QuestionVF.setText(this.liste_theme.get(n).SaisirListeQuestions().SelectionnerQuestion(nb).VFtype().getQuestion());
                this.Vrai.setText("Vrai");
                this.Faux.setText("Faux");
                if (phase==1){
                    this.Theme2.setText(this.liste_theme.get(n).SelectionnerTheme());
                } else if (phase == 2) {
                    this.Theme2.setText(Phase2ListeThemes.get(n).SelectionnerTheme());
                }

                this.Joueur2.setText(joueur_en_cours.getNom());
                this.Level2.setText("Niveau " + String.valueOf(this.liste_theme.get(n).SaisirListeQuestions().SelectionnerQuestion(nb).getLevel()));
                this.f.setContentPane(this.VFJpanel);
                this.reponse = String.valueOf(this.liste_theme.get(n).SaisirListeQuestions().SelectionnerQuestion(nb).VFtype().GetReponse());
                break;
            }
            case "Question.RC":{
                this.QuestionRC.setText(this.liste_theme.get(n).SaisirListeQuestions().SelectionnerQuestion(nb).RCtype().getQuestion());

                if (phase==1){
                    this.Theme3.setText(this.liste_theme.get(n).SelectionnerTheme());
                } else if (phase == 2) {
                    this.Theme3.setText(Phase2ListeThemes.get(n).SelectionnerTheme());
                }
                this.Joueur3.setText(joueur_en_cours.getNom());
                this.Level3.setText("Niveau " + String.valueOf(this.liste_theme.get(n).SaisirListeQuestions().SelectionnerQuestion(nb).getLevel()));
                this.f.setContentPane(this.RCJpanel);
                this.reponse= this.liste_theme.get(n).SaisirListeQuestions().SelectionnerQuestion(nb).RCtype().getReponse();
                break;
            }
        }

        if(phase==2){
            reloadComboBox(n);
        }

        this.f.setSize(500,175);
        this.f.revalidate();


    }

    public void AfficherScore()   {
        for (Joueur j : liste_candidat){
            System.out.println(j.getNom()+" "+j.getScore());
        }
    }

    public void FinPhase(){

        reloadScoreLabel();

        ArrayList<Joueur> AffichageScoreList = (ArrayList<Joueur>) liste_candidat.clone();

        Collections.sort(AffichageScoreList, new Comparator<Joueur>() {
            @Override
            public int compare(Joueur o1, Joueur o2) {
                return Integer.compare(o1.getScore(), o2.getScore());
            }
        });

        for (int i=0; i<AffichageScoreList.size(); i++) {
            if (i==3){
                NomPremierLabel.setText(AffichageScoreList.get(i).getNom());
                ScorePremierLabel.setText(String.valueOf(AffichageScoreList.get(i).getScore()));
            }else if (i==2){
                NomDeuxiemeLabel.setText(AffichageScoreList.get(i).getNom());
                ScoreDeuxiemeLabel.setText(String.valueOf(AffichageScoreList.get(i).getScore()));
            }else if(i==1){
                NomTroisiemeLabel.setText(AffichageScoreList.get(i).getNom());
                ScoreTroisiemeLabel.setText(String.valueOf(AffichageScoreList.get(i).getScore()));
                if (phase==3) {
                    for (int j = 0; j < liste_candidat.size(); j++) {
                        if (liste_candidat.get(j).getNom().equals(AffichageScoreList.get(i).getNom())) {
                            liste_candidat.remove(j);
                            break;
                        }
                    }
                }
            }else{
                NomQuatriemeLabel.setText(AffichageScoreList.get(i).getNom());
                ScoreQuatriemeLabel.setText(String.valueOf(AffichageScoreList.get(i).getScore()));

                if (phase==2) {
                    for (int j = 0; j < liste_candidat.size(); j++) {
                        if (liste_candidat.get(j).getNom().equals(AffichageScoreList.get(i).getNom())) {
                            liste_candidat.remove(j);
                            break;
                        }
                    }
                }
            }
        }

        for (Joueur j : liste_candidat){
            j.setScore(0);
            System.out.println(j.getNom());
        }

        this.f.setContentPane(AffichageScorePhase1);
        this.f.revalidate();

    }

    public void reloadComboBox(int index){
        Phase2ListeThemes.remove(index);

        ChoixThemePhase2ComboBox.removeAllItems();
        for (Themes th : Phase2ListeThemes){
            ChoixThemePhase2ComboBox.addItem(th.getNom());
        }
    }

    public void reloadScoreLabel(){
        NomPremierLabel.setText("");
        ScorePremierLabel.setText("");

        NomDeuxiemeLabel.setText("");
        ScoreDeuxiemeLabel.setText("");

        NomTroisiemeLabel.setText("");
        ScoreTroisiemeLabel.setText("");

        NomQuatriemeLabel.setText("");
        ScoreTroisiemeLabel.setText("");
    }
}
