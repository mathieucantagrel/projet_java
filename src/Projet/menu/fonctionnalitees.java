package Projet.menu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Projet.Themes.Themes;
import Projet.front.Eureka_front;

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
        frame.setSize(600, 175);
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
                frame.setSize(600, 400);
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
                themes = new Themes("Cuisine");
                ;
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
                frame.setSize(600, 400);
                frame.revalidate();
            }
        });

        a1Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SetQuestionLabel(1);
                frame.setContentPane(AffichageQuestion);
                frame.setSize(800, 600);
                frame.revalidate();
            }
        });

        a2Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SetQuestionLabel(2);
                frame.setContentPane(AffichageQuestion);
                frame.setSize(800, 600);
                frame.revalidate();
            }
        });

        a3Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SetQuestionLabel(3);
                frame.setContentPane(AffichageQuestion);
                frame.setSize(800, 600);
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

    public void AffichageChoixNiveau() { //charge les questions pour le theme choisi
        themes.SaisirListeQuestions().charger_question_QCM(themes.getNom());
        themes.SaisirListeQuestions().charger_Question_VF(themes.getNom());
        themes.SaisirListeQuestions().charger_question_RC(themes.getNom());
        frame.setContentPane(ChoixNiveau);
        frame.revalidate();
    }

    public void SetQuestionLabel(int niveau) { //affichage de la liste des questions pour le theme et le niveau choisi
        String ListeQuestion = "<html>"; //permet le retour a la ligne dans un label

        for (int i = 0; i < themes.SaisirListeQuestions().GetListeQuestion().size(); i++) {
            if (themes.SaisirListeQuestions().SelectionnerQuestion(i).getLevel() == niveau) {
                switch (themes.SaisirListeQuestions().SelectionnerQuestion(i).saisir().getClass().getName()) {
                    case "Projet.Question.QCM": {
                        ListeQuestion += (themes.SaisirListeQuestions().SelectionnerQuestion(i).QCMtype().getQuestion()) + "<br/>";
                        break;
                    }
                    case "Projet.Question.VF": {
                        ListeQuestion += (themes.SaisirListeQuestions().SelectionnerQuestion(i).VFtype().getQuestion()) + "<br/>";
                        break;
                    }
                    case "Projet.Question.RC": {
                        ListeQuestion += (themes.SaisirListeQuestions().SelectionnerQuestion(i).RCtype().getQuestion()) + "<br/>";
                        break;
                    }
                }
            }
        }

        ListeQuestion += "</html>";

        AffichageQuestionLabel.setText(ListeQuestion);
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
        final JPanel panel1 = new JPanel();
        panel1.setLayout(new GridBagLayout());
        Menu = new JPanel();
        Menu.setLayout(new GridBagLayout());
        GridBagConstraints gbc;
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        panel1.add(Menu, gbc);
        lancerLeJeuButton = new JButton();
        lancerLeJeuButton.setText("lancer le jeu");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        Menu.add(lancerLeJeuButton, gbc);
        afficherLesThemesButton = new JButton();
        afficherLesThemesButton.setText("Afficher les themes");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        Menu.add(afficherLesThemesButton, gbc);
        final JLabel label1 = new JLabel();
        label1.setText("Projet.menu");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        Menu.add(label1, gbc);
        quitterButton = new JButton();
        quitterButton.setText("Quitter");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        Menu.add(quitterButton, gbc);
        AffichageThemes = new JPanel();
        AffichageThemes.setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        panel1.add(AffichageThemes, gbc);
        retourButton = new JButton();
        retourButton.setText("Retour");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 11;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        AffichageThemes.add(retourButton, gbc);
        animauxButton = new JButton();
        animauxButton.setText("Animaux");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        AffichageThemes.add(animauxButton, gbc);
        automobileButton = new JButton();
        automobileButton.setText("Automobile");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        AffichageThemes.add(automobileButton, gbc);
        cuisineButton = new JButton();
        cuisineButton.setText("Cuisine");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        AffichageThemes.add(cuisineButton, gbc);
        geographieButton = new JButton();
        geographieButton.setText("Géographie");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        AffichageThemes.add(geographieButton, gbc);
        histoireButton = new JButton();
        histoireButton.setText("Histoire");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        AffichageThemes.add(histoireButton, gbc);
        langueFrançaiseButton = new JButton();
        langueFrançaiseButton.setText("Langue Française");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        AffichageThemes.add(langueFrançaiseButton, gbc);
        mathématiqueButton = new JButton();
        mathématiqueButton.setText("Mathématique");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        AffichageThemes.add(mathématiqueButton, gbc);
        mythologieGrecoRomaineButton = new JButton();
        mythologieGrecoRomaineButton.setText("Mythologie greco-romaine");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        AffichageThemes.add(mythologieGrecoRomaineButton, gbc);
        sportButton = new JButton();
        sportButton.setText("Sport");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 8;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        AffichageThemes.add(sportButton, gbc);
        villeFrançaiseButton = new JButton();
        villeFrançaiseButton.setText("Ville Française");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 9;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        AffichageThemes.add(villeFrançaiseButton, gbc);
        ChoixNiveau = new JPanel();
        ChoixNiveau.setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        panel1.add(ChoixNiveau, gbc);
        final JLabel label2 = new JLabel();
        label2.setText("Niveau");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        ChoixNiveau.add(label2, gbc);
        a1Button = new JButton();
        a1Button.setText("1");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        ChoixNiveau.add(a1Button, gbc);
        a2Button = new JButton();
        a2Button.setText("2");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        ChoixNiveau.add(a2Button, gbc);
        a3Button = new JButton();
        a3Button.setText("3");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        ChoixNiveau.add(a3Button, gbc);
        retourButton2 = new JButton();
        retourButton2.setText("Retour");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        ChoixNiveau.add(retourButton2, gbc);
        AffichageQuestion = new JPanel();
        AffichageQuestion.setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        panel1.add(AffichageQuestion, gbc);
        AffichageQuestionLabel = new JLabel();
        AffichageQuestionLabel.setText("Label");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        AffichageQuestion.add(AffichageQuestionLabel, gbc);
        retourButton1 = new JButton();
        retourButton1.setText("Retour");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        AffichageQuestion.add(retourButton1, gbc);
    }
}
