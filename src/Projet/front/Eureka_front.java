package Projet.front;

import Projet.Themes.*;

import Projet.main.*;

import Projet.menu.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;


public class Eureka_front implements Cloneable {

    private ArrayList<Themes> liste_theme;// Liste des différents thèmes (nommés sur les dossiers dans fichier)
    private EnsJoueurs liste_player;// liste de joeurs (les 20 joueurs)
    private ArrayList<Joueur> liste_candidat;// liste de 4 Joueurs jouant au jeux
    private Joueur joueur_en_cours;// Le joueur répondant à la question
    private int num_candidat = -1;// Numéro du joueur en cours (1,2,3 ou 4). Peut être mis en format random pour
    //TODO : Mettre un ordre aléatoire de chaque joueur pour le passage.
    private int indexTheme = 0; //index du theme a choisir dans la liste de themes
    private int niveauQuestion = 1; //niveau de la question qui va etre posee
    private int phase = 1;// variable de Phase.
    private ArrayList<Themes> Phase2ListeThemes; //liste des themes pour la phase 2
    private int scoreQuestion = 2; //nombres de points par question
    private ArrayList<Themes> Phase3ListeThemes;

    private static int Minutes = 0; //minute du chrono
    private static int Secondes = 0; //seconde du chrono
    private static int Milisecondes = 0; //milisecondes du chrono
    private static boolean state = true;
    private static int[] Chrono = new int[3];

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
    private JPanel Description1;
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
    private JLabel TempsPhase2Label;
    private JLabel TempsPhase1Et3Label;
    private JLabel TempsJoueur1Label;
    private JLabel TempsJoueur2Label;
    private JLabel TempsJoueur3Label;
    private JLabel TempsJoueur4Label;
    private String reponse;

    public Eureka_front() {//initialisation d'un premier frame.
        this.f = new JFrame("Eureka");
        f.setContentPane(EnterPseudoJpanel);
        f.setSize(600, 175);
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        f.setLocationRelativeTo(null);
        liste_theme = new ArrayList<Themes>(9);
        liste_player = new EnsJoueurs();
        liste_candidat = new ArrayList<Joueur>(3);
        f.setVisible(true);
        ValidRCButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {// verification de reponse pour question RC

                if (ReponseText.getText().toLowerCase().equals(reponse.toLowerCase())) {
                    liste_candidat.get(num_candidat).MAJScore(phase);
                }
                ReponseText.setText("");

                reload_display_select_theme();

            }
        });
        Vrai.addActionListener(new ActionListener() { //reponse vrai pour question VF
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean vrai = true;

                if (reponse.equals(String.valueOf(vrai))) {
                    liste_candidat.get(num_candidat).MAJScore(phase);
                }


                reload_display_select_theme();

            }
        });
        Faux.addActionListener(new ActionListener() { //reponse faux pour question VF
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean faux = false;

                if (reponse.equals(String.valueOf(faux))) {
                    liste_candidat.get(num_candidat).MAJScore(phase);
                }

                reload_display_select_theme();

            }
        });
        Proposition1Button.addActionListener(new ActionListener() { //reponse 1 question QCM
            @Override
            public void actionPerformed(ActionEvent e) {

                if (Proposition1Button.getText().equals(reponse)) {
                    liste_candidat.get(num_candidat).MAJScore(phase);
                }
                reload_display_select_theme();
            }
        });
        Proposition2Button.addActionListener(new ActionListener() { //reponse 2 question QCM
            @Override
            public void actionPerformed(ActionEvent e) {

                if (Proposition2Button.getText().equals(reponse)) {
                    liste_candidat.get(num_candidat).MAJScore(phase);
                }
                reload_display_select_theme();

            }
        });
        Proposition3Button.addActionListener(new ActionListener() { //reponse 3 quesiton QCM
            @Override
            public void actionPerformed(ActionEvent e) {

                if (Proposition3Button.getText().equals(reponse)) {
                    liste_candidat.get(num_candidat).MAJScore(phase);
                }
                reload_display_select_theme();

            }
        });
        validerButton.addActionListener(new ActionListener() { //choix des pseudo au debut
            @Override
            public void actionPerformed(ActionEvent e) {
                liste_candidat.get(0).setNom(JoueurtextArea1.getText());
                liste_candidat.get(1).setNom(JoueurtextArea2.getText());
                liste_candidat.get(2).setNom(JoueurtextArea3.getText());
                liste_candidat.get(3).setNom(JoueurtextArea4.getText());

                reload_display_select_theme();

            }
        });
        SelectThemeButton.addActionListener(new ActionListener() { //boutton pour passer a la question suivante
            @Override
            public void actionPerformed(ActionEvent e) {

                if (phase == 1) {
                    afficher_bonne_question(indexTheme);
                } else if (phase == 3) {
                    for (int index = 0; index < liste_theme.size(); index++) {
                        if (liste_theme.get(index).getNom().equals(Phase3ListeThemes.get(0).getNom())) {
                            afficher_bonne_question(index);
                            break;
                        }
                    }
                }

                indexTheme++;
                indexTheme %= 10;

            }
        });

        FinPhaseButton.addActionListener(new ActionListener() { //bouton pour passer la phase suivante
            @Override
            public void actionPerformed(ActionEvent e) {

                if (phase == 2) {

                    Phase2ListeThemes = new ArrayList<>();

                    Collections.shuffle(liste_theme); //randomzation des themes

                    for (int i = 0; i < 6; i++) { //ajout des 6 themes dans la nouvelle liste et dans la ComboBox
                        Phase2ListeThemes.add(liste_theme.get(i));
                        ChoixThemePhase2ComboBox.addItem(liste_theme.get(i).getNom());
                    }
                } else if (phase == 3) {

                    Phase3ListeThemes = new ArrayList<>();

                    Collections.shuffle(liste_theme);

                    for (int i = 0; i < 3; i++) {
                        Phase3ListeThemes.add(liste_theme.get(i));
                    }

                    for (Themes th : Phase3ListeThemes) {
                        System.out.println(th.getNom());
                    }
                }

                reload_display_select_theme();
            }
        });

        ValiderThemePhase2Button.addActionListener(new ActionListener() { //choix de theme durant la phase 2
            @Override
            public void actionPerformed(ActionEvent e) {

                int index = 0;

                for (int i = 0; i < liste_theme.size(); i++) { //recuperation de l index du theme choisi
                    if (liste_theme.get(i).getNom().equals(ChoixThemePhase2ComboBox.getSelectedItem())) {
                        index = i;
                        break;
                    }
                }

                afficher_bonne_question(index);

            }
        });
    }


    public void reload_display_select_theme()//affichage fenetre avant question : phase1->validation joueur | phase2-> choix d'un theme
    {

        state = false;

        if (num_candidat != -1) {
            liste_candidat.get(num_candidat).getChrono()[2] = Minutes;
            liste_candidat.get(num_candidat).getChrono()[1] = Secondes;
            liste_candidat.get(num_candidat).getChrono()[0] = Milisecondes;
        }

        num_candidat++;//passage au joueur suivant

        try {
            if (phase == 2) {
                this.NomJoueurLabel.setText(liste_candidat.get(num_candidat).getNom());
            } else {
                this.JoueurLabel.setText(liste_candidat.get(num_candidat).getNom());
            }

        } catch (IndexOutOfBoundsException e) {

            if (phase == 1) {
                num_candidat %= 4;
                niveauQuestion++;

                if (niveauQuestion == 4) { //si chaque joueur a eu 1 question de chaque difficulté
                    phase_de_jeu(); //passage a la phase suivante
                    return;
                }

                this.JoueurLabel.setText(liste_candidat.get(num_candidat).getNom());

            } else if (phase == 2) {
                num_candidat %= 3;
                this.NomJoueurLabel.setText(liste_candidat.get(num_candidat).getNom());
            } else if (phase == 3) {
                num_candidat %= 2;
                niveauQuestion++;
                if (niveauQuestion == 4) {
                    niveauQuestion = 1;
                    Phase3ListeThemes.remove(0);
                }
                if (Phase3ListeThemes.size() == 0) {
                    phase_de_jeu();
                    return;
                }
                this.JoueurLabel.setText(liste_candidat.get(num_candidat).getNom());
            }
        }


        String Temps = String.valueOf(liste_candidat.get(num_candidat).getChrono()[2]) + ":" + String.valueOf(liste_candidat.get(num_candidat).getChrono()[1]) + ":" + String.valueOf(liste_candidat.get(num_candidat).getChrono()[0]);

        if (phase == 1 || phase == 3) {
            TempsPhase1Et3Label.setText(Temps);
            this.f.setContentPane(SelectThemeJpanel);
        } else if (phase == 2) {

            TempsPhase2Label.setText(Temps);

            this.f.setContentPane(Phase2SelectThemeJPanel);

            if (Phase2ListeThemes.size() == 0) { //si tous les themes ont ete utilisé
                phase_de_jeu(); //passage a la phase suivante
                return;
            }
        }
        this.f.revalidate(); //recharge le JPannel
    }

    public void init()//Initialisation des checkbox, de la liste et lecture des fichiers pour les questions pour chaque liste de thèmes.
    {

        Themes animaux = new Themes("Animaux");
        Themes Automobile = new Themes("Automobile");
        Themes Cuisine = new Themes("Cuisine");
        Themes Geographie = new Themes("Géographie");
        Themes Histoire = new Themes("Histoire");
        Themes Langue_francaise = new Themes("Langue française");
        Themes Mathematique = new Themes("Mathématique");
        Themes Mythologie = new Themes("Mythologie greco-romaine");
        Themes Sport = new Themes("Sport");
        Themes Ville_francaise = new Themes("Ville Française");
        this.ajouter_theme(animaux, 0);
        this.ajouter_theme(Automobile, 1);
        this.ajouter_theme(Geographie, 2);
        this.ajouter_theme(Cuisine, 3);
        this.ajouter_theme(Histoire, 4);
        this.ajouter_theme(Langue_francaise, 5);
        this.ajouter_theme(Mathematique, 6);
        this.ajouter_theme(Mythologie, 7);
        this.ajouter_theme(Sport, 8);
        this.ajouter_theme(Ville_francaise, 9);

        creation_question();
        liste_candidat = new ArrayList<Joueur>(3);
        liste_player.Créer();
        liste_candidat.add(0, liste_player.Selectionner_Joueur());
        liste_candidat.add(1, liste_player.Selectionner_Joueur());
        liste_candidat.add(2, liste_player.Selectionner_Joueur());
        liste_candidat.add(3, liste_player.Selectionner_Joueur());

        Collections.shuffle(liste_candidat);
    }

    public void phase_de_jeu() //passage a la phase suivante
    {
        phase++;
        if (phase == 2) { //fin phase 1 passage a la phase 2
            niveauQuestion = 2;
            scoreQuestion = 3;
            num_candidat = -1;
            FinPhase(); //affichage des scores
        } else if (phase == 3) {
            niveauQuestion = 1;
            scoreQuestion = 5;
            num_candidat = -1;
            FinPhase(); //affichage des scores
        } else if (phase == 4) {
            FinPhase(); //affichage des scores
        }
    }

    public void ajouter_theme(Themes theme, int nb) {
        this.liste_theme.add(nb, theme);
    }// Ajout d'un theme

    public void creation_question()// Lecture de fichier dans la classe ListeQuestion.
    {

        for (int n = 0; n < liste_theme.size(); n++) {
            this.liste_theme.get(n).SaisirListeQuestions().charger_question_QCM(liste_theme.get(n).getNom());
            this.liste_theme.get(n).SaisirListeQuestions().charger_question_RC(liste_theme.get(n).getNom());
            this.liste_theme.get(n).SaisirListeQuestions().charger_Question_VF(liste_theme.get(n).getNom());

        }
    }

    public void afficher_bonne_question(int n)// Methode mère du cote graphique
    {
        joueur_en_cours = liste_candidat.get(num_candidat);
        int index = 0;

        Random rd = new Random();
        int nb = 0;
        if (phase == 1 || phase == 3) {
            System.out.println(this.liste_theme.get(n).getNom());
            do {
                nb = rd.nextInt(this.liste_theme.get(n).SaisirListeQuestions().GetListeQuestion().size());
            } while (this.liste_theme.get(n).SaisirListeQuestions().SelectionnerQuestion(nb).getLevel() != niveauQuestion);
        } else if (phase == 2) {

            for (int i = 0; i < Phase2ListeThemes.size(); i++) {
                if (liste_theme.get(n).getNom().equals(Phase2ListeThemes.get(i).getNom())) {
                    index = i;
                    break;
                }
            }
            do {
                nb = rd.nextInt(this.Phase2ListeThemes.get(index).SaisirListeQuestions().GetListeQuestion().size());
            } while (this.Phase2ListeThemes.get(index).SaisirListeQuestions().SelectionnerQuestion(nb).getLevel() != niveauQuestion);
        }

        switch (this.liste_theme.get(n).SaisirListeQuestions().SelectionnerQuestion(nb).saisir().getClass().getName()) {
            case "Projet.Question.QCM": {

                this.QuestionQCMLabel.setText(this.liste_theme.get(n).SaisirListeQuestions().SelectionnerQuestion(nb).QCMtype().getQuestion());
                this.Proposition1Button.setText(this.liste_theme.get(n).SaisirListeQuestions().SelectionnerQuestion(nb).QCMtype().getProposition().get(0));
                this.Proposition2Button.setText(this.liste_theme.get(n).SaisirListeQuestions().SelectionnerQuestion(nb).QCMtype().getProposition().get(1));
                this.Proposition3Button.setText(this.liste_theme.get(n).SaisirListeQuestions().SelectionnerQuestion(nb).QCMtype().getReponse());
                if (phase == 1 || phase == 3) {
                    this.Theme1.setText(this.liste_theme.get(n).SelectionnerTheme());
                } else if (phase == 2) {
                    this.Theme1.setText(Phase2ListeThemes.get(index).SelectionnerTheme());
                }
                this.Joueur1.setText(joueur_en_cours.getNom());
                this.Level1.setText("Niveau " + String.valueOf(this.liste_theme.get(n).SaisirListeQuestions().SelectionnerQuestion(nb).getLevel()));
                this.f.setContentPane(this.QCMJpanel);
                this.reponse = this.liste_theme.get(n).SaisirListeQuestions().SelectionnerQuestion(nb).QCMtype().getReponse();
                break;
            }
            case "Projet.Question.VF": {
                this.QuestionVF.setText(this.liste_theme.get(n).SaisirListeQuestions().SelectionnerQuestion(nb).VFtype().getQuestion());
                this.Vrai.setText("Vrai");
                this.Faux.setText("Faux");
                if (phase == 1 || phase == 3) {
                    this.Theme2.setText(this.liste_theme.get(n).SelectionnerTheme());
                } else if (phase == 2) {
                    this.Theme2.setText(Phase2ListeThemes.get(index).SelectionnerTheme());
                }

                this.Joueur2.setText(joueur_en_cours.getNom());
                this.Level2.setText("Niveau " + String.valueOf(this.liste_theme.get(n).SaisirListeQuestions().SelectionnerQuestion(nb).getLevel()));
                this.f.setContentPane(this.VFJpanel);
                this.reponse = String.valueOf(this.liste_theme.get(n).SaisirListeQuestions().SelectionnerQuestion(nb).VFtype().GetReponse());
                break;
            }
            case "Projet.Question.RC": {
                this.QuestionRC.setText(this.liste_theme.get(n).SaisirListeQuestions().SelectionnerQuestion(nb).RCtype().getQuestion());

                if (phase == 1 || phase == 3) {
                    this.Theme3.setText(this.liste_theme.get(n).SelectionnerTheme());
                } else if (phase == 2) {
                    this.Theme3.setText(Phase2ListeThemes.get(index).SelectionnerTheme());
                }
                this.Joueur3.setText(joueur_en_cours.getNom());
                this.Level3.setText("Niveau " + String.valueOf(this.liste_theme.get(n).SaisirListeQuestions().SelectionnerQuestion(nb).getLevel()));
                this.f.setContentPane(this.RCJpanel);
                this.reponse = this.liste_theme.get(n).SaisirListeQuestions().SelectionnerQuestion(nb).RCtype().getReponse();
                break;
            }
        }

        if (phase == 2) {
            reloadComboBox(this.liste_theme.get(n).getNom()); //recharge la comboBox de choix des themes durant la phase 2
        }

        state = true;
        StartChrono(joueur_en_cours.getChrono());

        this.f.setSize(900, 300);
        this.f.revalidate();

    }

    public void FinPhase() { //affichage des scores et passage a la phase suivante

        reloadScoreLabel();//reset des labels affichage des scores

        ArrayList<Joueur> AffichageScoreList = (ArrayList<Joueur>) liste_candidat.clone();

        Collections.sort(AffichageScoreList, new Comparator<Joueur>() { //tri des joueurs en fonction de leur score
            @Override
            public int compare(Joueur o1, Joueur o2) {
                if (o1.getScore() != o2.getScore()) {
                    return Integer.compare(o1.getScore(), o2.getScore());
                }
                if (o1.getChrono()[2] != o2.getChrono()[2]) {
                    return -Integer.compare(o1.getChrono()[2], o2.getChrono()[2]);
                }
                if (o1.getChrono()[1] != (o2.getChrono()[1])) {
                    return -Integer.compare(o1.getChrono()[1], o2.getChrono()[1]);
                }
                if (o1.getChrono()[0] != o2.getChrono()[0]) {
                    return -Integer.compare(o1.getChrono()[0], o2.getChrono()[0]);
                }
                return 0;
            }
        });


        for (int i = 0; i < AffichageScoreList.size(); i++) { //affichage des scores
            if (i == AffichageScoreList.size() - 1) { //meilleur joueur
                NomPremierLabel.setText(AffichageScoreList.get(i).getNom());
                ScorePremierLabel.setText(String.valueOf(AffichageScoreList.get(i).getScore()));
                TempsJoueur1Label.setText(AffichageChrono(i, AffichageScoreList));
                if (phase == 4) {
                    for (int j = 0; j < liste_candidat.size(); j++) {
                        if (liste_candidat.get(j).getNom().equals(AffichageScoreList.get(i).getNom())) {
                            liste_candidat.get(j).setEtat("Gagnant");
                        }
                    }
                }
            } else if (i == AffichageScoreList.size() - 2) { //deuxieme joueur
                NomDeuxiemeLabel.setText(AffichageScoreList.get(i).getNom());
                ScoreDeuxiemeLabel.setText(String.valueOf(AffichageScoreList.get(i).getScore()));
                TempsJoueur2Label.setText(AffichageChrono(i, AffichageScoreList));
            } else if (i == AffichageScoreList.size() - 3) { //troisieme joueur
                NomTroisiemeLabel.setText(AffichageScoreList.get(i).getNom());
                ScoreTroisiemeLabel.setText(String.valueOf(AffichageScoreList.get(i).getScore()));
                TempsJoueur3Label.setText(AffichageChrono(i, AffichageScoreList));
                if (phase == 3) { //si passage a la phase 3 -> retirer joueur de la liste
                    for (int j = 0; j < liste_candidat.size(); j++) {
                        if (liste_candidat.get(j).getNom().equals(AffichageScoreList.get(i).getNom())) {
                            liste_candidat.get(i).setEtat("Elemine");
                            liste_candidat.remove(j);
                            break;
                        }
                    }
                }
            } else if (phase == 2) { //quatrieme joueur
                NomQuatriemeLabel.setText(AffichageScoreList.get(i).getNom());
                ScoreQuatriemeLabel.setText(String.valueOf(AffichageScoreList.get(i).getScore()));
                TempsJoueur4Label.setText(AffichageChrono(i, AffichageScoreList));

                for (int j = 0; j < liste_candidat.size(); j++) {
                    if (liste_candidat.get(j).getNom().equals(AffichageScoreList.get(i).getNom())) {
                        liste_candidat.get(i).setEtat("Elemine");
                        liste_candidat.remove(j);
                        break;
                    }
                }

            }
        }

        for (Joueur j : liste_candidat) { //reset des scores
            j.setScore(0);
            int[] chrono = {0, 0, 0};
            j.setChrono(chrono);
        }

        Collections.shuffle(liste_candidat);

        if (phase == 4) {
            FinJeu();
        }

        this.f.setContentPane(AffichageScorePhase1);
        this.f.revalidate();
    }

    public String AffichageChrono(int i, ArrayList<Joueur> AffichageScoreList) {
        return String.valueOf(AffichageScoreList.get(i).getChrono()[2]) + ":" + String.valueOf(AffichageScoreList.get(i).getChrono()[1]) + ":" + String.valueOf(AffichageScoreList.get(i).getChrono()[0]);
    }

    public void reloadComboBox(String theme) { //reload de la comboBox de choix des themes dans la phase 2

        for (int i = 0; i < Phase2ListeThemes.size(); i++) {
            if (Phase2ListeThemes.get(i).getNom().equals(theme)) {
                Phase2ListeThemes.remove(i);
                break;
            }
        }

        ChoixThemePhase2ComboBox.removeAllItems(); //vider la comboBox
        for (Themes th : Phase2ListeThemes) { //remplissage de la comboBox avec les themes qui restent
            ChoixThemePhase2ComboBox.addItem(th.getNom());
        }
    }

    public void reloadScoreLabel() { //reset des labels pour afficher les scores
        NomPremierLabel.setText("");
        ScorePremierLabel.setText("");
        TempsJoueur1Label.setText("");

        NomDeuxiemeLabel.setText("");
        ScoreDeuxiemeLabel.setText("");
        TempsJoueur2Label.setText("");

        NomTroisiemeLabel.setText("");
        ScoreTroisiemeLabel.setText("");
        TempsJoueur3Label.setText("");

        NomQuatriemeLabel.setText("");
        ScoreQuatriemeLabel.setText("");
        TempsJoueur4Label.setText("");
    }

    private void StartChrono(int[] ChronoJoueur) {

        Milisecondes = ChronoJoueur[0];
        Secondes = ChronoJoueur[1];
        Minutes = ChronoJoueur[2];

        Thread t = new Thread() {
            public void run() {

                for (; ; ) {

                    if (state) {

                        try {
                            sleep(1);

                            if (Milisecondes > 500) {
                                Milisecondes = 0;
                                Secondes++;
                            }
                            if (Secondes > 60) {
                                Secondes = 0;
                                Minutes++;
                            }
                            if (Minutes > 60) {
                                Minutes = 0;
                            }

                            Chrono[0] = Milisecondes;
                            Chrono[1] = Secondes;
                            Chrono[2] = Minutes;

                            Milisecondes++;

                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    } else {
                        break;
                    }

                }
            }
        };
        t.start();
    }

    private void FinJeu() {
        FinPhaseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.dispose(); //ferme la fenetre
                fonctionnalitees fonctionnalitees = new fonctionnalitees(); //ouvre le menu
            }
        });
    }

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        JpanelJeux = new JPanel();
        JpanelJeux.setLayout(new GridBagLayout());
        QCMJpanel = new JPanel();
        QCMJpanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc;
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        JpanelJeux.add(QCMJpanel, gbc);
        QuestionQCMLabel = new JLabel();
        QuestionQCMLabel.setText("Label");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 4;
        gbc.weightx = 1.0;
        QCMJpanel.add(QuestionQCMLabel, gbc);
        Proposition1Button = new JButton();
        Proposition1Button.setText("Button");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        QCMJpanel.add(Proposition1Button, gbc);
        Description1 = new JPanel();
        Description1.setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        QCMJpanel.add(Description1, gbc);
        Level1 = new JLabel();
        Level1.setText("Label");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        Description1.add(Level1, gbc);
        Theme1 = new JLabel();
        Theme1.setText("Label");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        Description1.add(Theme1, gbc);
        Joueur1 = new JLabel();
        Joueur1.setText("Label");
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        Description1.add(Joueur1, gbc);
        Proposition2Button = new JButton();
        Proposition2Button.setText("Button");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        QCMJpanel.add(Proposition2Button, gbc);
        Proposition3Button = new JButton();
        Proposition3Button.setText("Button");
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 2;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        QCMJpanel.add(Proposition3Button, gbc);
        VFJpanel = new JPanel();
        VFJpanel.setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        JpanelJeux.add(VFJpanel, gbc);
        QuestionVF = new JLabel();
        QuestionVF.setText("Label");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        gbc.weightx = 1.0;
        VFJpanel.add(QuestionVF, gbc);
        Vrai = new JButton();
        Vrai.setText("Vrai");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        VFJpanel.add(Vrai, gbc);
        Faux = new JButton();
        Faux.setText("Faux");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        VFJpanel.add(Faux, gbc);
        Description2 = new JPanel();
        Description2.setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        VFJpanel.add(Description2, gbc);
        Level2 = new JLabel();
        Level2.setText("Label");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        Description2.add(Level2, gbc);
        Joueur2 = new JLabel();
        Joueur2.setText("Label");
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        Description2.add(Joueur2, gbc);
        Theme2 = new JLabel();
        Theme2.setText("Label");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        Description2.add(Theme2, gbc);
        RCJpanel = new JPanel();
        RCJpanel.setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        JpanelJeux.add(RCJpanel, gbc);
        QuestionRC = new JLabel();
        QuestionRC.setText("Label");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 1.0;
        RCJpanel.add(QuestionRC, gbc);
        ValidRCButton = new JButton();
        ValidRCButton.setText("Valider");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        RCJpanel.add(ValidRCButton, gbc);
        Description3 = new JPanel();
        Description3.setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        RCJpanel.add(Description3, gbc);
        Level3 = new JLabel();
        Level3.setText("Label");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        Description3.add(Level3, gbc);
        Joueur3 = new JLabel();
        Joueur3.setText("Label");
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        Description3.add(Joueur3, gbc);
        Theme3 = new JLabel();
        Theme3.setText("Label");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        Description3.add(Theme3, gbc);
        ReponseText = new JTextArea();
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.ipadx = 500;
        gbc.ipady = 5;
        RCJpanel.add(ReponseText, gbc);
        EnterPseudoJpanel = new JPanel();
        EnterPseudoJpanel.setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        JpanelJeux.add(EnterPseudoJpanel, gbc);
        JoueurtextArea1 = new JTextArea();
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        EnterPseudoJpanel.add(JoueurtextArea1, gbc);
        JoueurtextArea2 = new JTextArea();
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        EnterPseudoJpanel.add(JoueurtextArea2, gbc);
        JoueurtextArea3 = new JTextArea();
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        EnterPseudoJpanel.add(JoueurtextArea3, gbc);
        JoueurtextArea4 = new JTextArea();
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 1;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        EnterPseudoJpanel.add(JoueurtextArea4, gbc);
        final JLabel label1 = new JLabel();
        label1.setText("Joueur 1 : ");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        EnterPseudoJpanel.add(label1, gbc);
        final JLabel label2 = new JLabel();
        label2.setText("Joueur 3 : ");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        EnterPseudoJpanel.add(label2, gbc);
        final JLabel label3 = new JLabel();
        label3.setText("Joueur 2 :");
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        EnterPseudoJpanel.add(label3, gbc);
        final JLabel label4 = new JLabel();
        label4.setText("Joueur 4 : ");
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 1;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        EnterPseudoJpanel.add(label4, gbc);
        validerButton = new JButton();
        validerButton.setText("Valider");
        gbc = new GridBagConstraints();
        gbc.gridx = 4;
        gbc.gridy = 1;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        EnterPseudoJpanel.add(validerButton, gbc);
        SelectThemeJpanel = new JPanel();
        SelectThemeJpanel.setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        JpanelJeux.add(SelectThemeJpanel, gbc);
        JoueurLabel = new JLabel();
        JoueurLabel.setText("Label");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        SelectThemeJpanel.add(JoueurLabel, gbc);
        SelectThemeButton = new JButton();
        SelectThemeButton.setText("Valider");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        SelectThemeJpanel.add(SelectThemeButton, gbc);
        TempsPhase1Et3Label = new JLabel();
        TempsPhase1Et3Label.setText("Label");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        SelectThemeJpanel.add(TempsPhase1Et3Label, gbc);
        Phase2SelectThemeJPanel = new JPanel();
        Phase2SelectThemeJPanel.setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        JpanelJeux.add(Phase2SelectThemeJPanel, gbc);
        NomJoueurLabel = new JLabel();
        NomJoueurLabel.setText("Label");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        Phase2SelectThemeJPanel.add(NomJoueurLabel, gbc);
        ValiderThemePhase2Button = new JButton();
        ValiderThemePhase2Button.setText("Valider");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        Phase2SelectThemeJPanel.add(ValiderThemePhase2Button, gbc);
        ChoixThemePhase2ComboBox = new JComboBox();
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        Phase2SelectThemeJPanel.add(ChoixThemePhase2ComboBox, gbc);
        TempsPhase2Label = new JLabel();
        TempsPhase2Label.setText("Label");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        Phase2SelectThemeJPanel.add(TempsPhase2Label, gbc);
        AffichageScorePhase1 = new JPanel();
        AffichageScorePhase1.setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridheight = 2;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        JpanelJeux.add(AffichageScorePhase1, gbc);
        AffichageScoreLabel = new JLabel();
        AffichageScoreLabel.setText("tableau des scores");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 3;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        AffichageScorePhase1.add(AffichageScoreLabel, gbc);
        NomPremierLabel = new JLabel();
        NomPremierLabel.setText("Label");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        AffichageScorePhase1.add(NomPremierLabel, gbc);
        NomDeuxiemeLabel = new JLabel();
        NomDeuxiemeLabel.setText("Label");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        AffichageScorePhase1.add(NomDeuxiemeLabel, gbc);
        NomQuatriemeLabel = new JLabel();
        NomQuatriemeLabel.setText("Label");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        AffichageScorePhase1.add(NomQuatriemeLabel, gbc);
        NomTroisiemeLabel = new JLabel();
        NomTroisiemeLabel.setText("Label");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        AffichageScorePhase1.add(NomTroisiemeLabel, gbc);
        FinPhaseButton = new JButton();
        FinPhaseButton.setText("continuer");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 3;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        AffichageScorePhase1.add(FinPhaseButton, gbc);
        ScorePremierLabel = new JLabel();
        ScorePremierLabel.setText("Label");
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 1;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        AffichageScorePhase1.add(ScorePremierLabel, gbc);
        ScoreDeuxiemeLabel = new JLabel();
        ScoreDeuxiemeLabel.setText("Label");
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 2;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        AffichageScorePhase1.add(ScoreDeuxiemeLabel, gbc);
        ScoreTroisiemeLabel = new JLabel();
        ScoreTroisiemeLabel.setText("Label");
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 3;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        AffichageScorePhase1.add(ScoreTroisiemeLabel, gbc);
        ScoreQuatriemeLabel = new JLabel();
        ScoreQuatriemeLabel.setText("Label");
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 4;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        AffichageScorePhase1.add(ScoreQuatriemeLabel, gbc);
        TempsJoueur1Label = new JLabel();
        TempsJoueur1Label.setText("Label");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        AffichageScorePhase1.add(TempsJoueur1Label, gbc);
        TempsJoueur2Label = new JLabel();
        TempsJoueur2Label.setText("Label");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        AffichageScorePhase1.add(TempsJoueur2Label, gbc);
        TempsJoueur3Label = new JLabel();
        TempsJoueur3Label.setText("label");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        AffichageScorePhase1.add(TempsJoueur3Label, gbc);
        TempsJoueur4Label = new JLabel();
        TempsJoueur4Label.setText("Label");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        AffichageScorePhase1.add(TempsJoueur4Label, gbc);
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return JpanelJeux;
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
