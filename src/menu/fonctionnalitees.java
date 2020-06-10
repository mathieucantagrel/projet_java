package menu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.invoke.StringConcatFactory;

import Question.Question;
import Themes.Themes;
import front.Eureka_front;

public class fonctionnalitees {

    private String ThemeChoisi;
    private Themes themes;

    //Menu Principal
    private JFrame frame;
    private JButton lancerLeJeuButton;
    private JButton afficherLesThemesButton;
    private JPanel Menu;

    //Affichage des themes
    private JButton retourButton;
    private JPanel AffichageThemes;
    private JButton animauxButton;
    private JButton automobileButton;
    private JButton cuisineButton;
    private JButton geographieButton;
    private JButton histoireButton;
    private JButton langueFrançaiseButton;
    private JButton mathématiqueButton;
    private JButton mythologieGrecoRomaineButton;
    private JButton sportButton;
    private JButton villeFrançaiseButton;

    //Choix du niveau de la question
    private JButton a1Button;
    private JButton a2Button;
    private JButton a3Button;
    private JPanel ChoixNiveau;
    private JPanel AffichageQuestion;
    private JButton retourButton2;

    //Affichage questions pour niveau et theme choisi
    private JButton retourButton1;
    private JLabel AffichageQuestionLabel;
    private JButton quitterButton;

    public fonctionnalitees() {
        this.frame = new JFrame();
        frame.setContentPane(Menu);
        frame.setSize(600,175);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        lancerLeJeuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { //lance le jeu
                Eureka_front l = new Eureka_front();
                l.init();//Lancement de l'application
                frame.dispose(); //ferme la fenetre du menu
            }
        });

        afficherLesThemesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setContentPane(AffichageThemes);
                frame.setSize(600,400);
                frame.revalidate();
            }
        });
        retourButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setContentPane(Menu);
                frame.setSize(400, 175);
                frame.revalidate();
            }
        });

        animauxButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                themes = new Themes("Animaux");
                AffichageChoixNiveau();
            }
        });

        automobileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                themes = new Themes("Automobile");
                AffichageChoixNiveau();
            }
        });

        cuisineButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                themes = new Themes("Cuisine");;
                AffichageChoixNiveau();
            }
        });

        geographieButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                themes = new Themes("Géographie");
                AffichageChoixNiveau();
            }
        });

        histoireButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                themes = new Themes("Histoire");
                AffichageChoixNiveau();
            }
        });

        langueFrançaiseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                themes = new Themes("Langue Française");
                AffichageChoixNiveau();
            }
        });

        mathématiqueButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                themes = new Themes("Mathématique");
                AffichageChoixNiveau();
            }
        });

        mythologieGrecoRomaineButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                themes = new Themes("Mythologie greco-romaine");
                AffichageChoixNiveau();
            }
        });

        sportButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                themes = new Themes("Sport");
                AffichageChoixNiveau();
            }
        });

        villeFrançaiseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                themes = new Themes("Ville Française");
                AffichageChoixNiveau();
            }
        });

        retourButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setContentPane(AffichageThemes);
                frame.setSize(600,400);
                frame.revalidate();
            }
        });

        a1Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SetQuestionLabel(1);
                frame.setContentPane(AffichageQuestion);
                frame.setSize(800,600);
                frame.revalidate();
            }
        });

        a2Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SetQuestionLabel(2);
                frame.setContentPane(AffichageQuestion);
                frame.setSize(800,600);
                frame.revalidate();
            }
        });

        a3Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SetQuestionLabel(3);
                frame.setContentPane(AffichageQuestion);
                frame.setSize(800,600);
                frame.revalidate();
            }
        });
        retourButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setContentPane(ChoixNiveau);
                frame.revalidate();
            }
        });

        quitterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });
    }

    public void AffichageChoixNiveau(){ //charge les questions pour le theme choisi
        themes.SaisirListeQuestions().charger_question_QCM(themes.getNom());
        themes.SaisirListeQuestions().charger_Question_VF(themes.getNom());
        themes.SaisirListeQuestions().charger_question_RC(themes.getNom());
        frame.setContentPane(ChoixNiveau);
        frame.revalidate();
    }

    public void SetQuestionLabel(int niveau){ //affichage de la liste des questions pour le theme et le niveau choisi
        String ListeQuestion = "<html>"; //permet le retour a la ligne dans un label

        for (int i=0; i<themes.SaisirListeQuestions().GetListeQuestion().size(); i++) {
            if (themes.SaisirListeQuestions().SelectionnerQuestion(i).getLevel() == niveau) {
                switch (themes.SaisirListeQuestions().SelectionnerQuestion(i).saisir().getClass().getName()) {
                    case "Question.QCM": {
                        ListeQuestion += (themes.SaisirListeQuestions().SelectionnerQuestion(i).QCMtype().getQuestion()) +"<br/>";
                        break;
                    }
                    case "Question.VF": {
                        ListeQuestion += (themes.SaisirListeQuestions().SelectionnerQuestion(i).VFtype().getQuestion()) +"<br/>";
                        break;
                    }
                    case "Question.RC": {
                        ListeQuestion += (themes.SaisirListeQuestions().SelectionnerQuestion(i).RCtype().getQuestion()) +"<br/>";
                        break;
                    }
                }
            }
        }

        ListeQuestion += "</html>";

        AffichageQuestionLabel.setText(ListeQuestion);
    }
}
