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
                    case "Question.QCM": {
                        ListeQuestion += (themes.SaisirListeQuestions().SelectionnerQuestion(i).QCMtype().getQuestion()) + "<br/>";
                        break;
                    }
                    case "Question.VF": {
                        ListeQuestion += (themes.SaisirListeQuestions().SelectionnerQuestion(i).VFtype().getQuestion()) + "<br/>";
                        break;
                    }
                    case "Question.RC": {
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
        panel1.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(4, 2, new Insets(0, 0, 0, 0), -1, -1));
        Menu = new JPanel();
        Menu.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(4, 1, new Insets(0, 0, 0, 0), -1, -1));
        panel1.add(Menu, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 2, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        lancerLeJeuButton = new JButton();
        lancerLeJeuButton.setText("lancer le jeu");
        Menu.add(lancerLeJeuButton, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        afficherLesThemesButton = new JButton();
        afficherLesThemesButton.setText("Afficher les themes");
        Menu.add(afficherLesThemesButton, new com.intellij.uiDesigner.core.GridConstraints(2, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label1 = new JLabel();
        label1.setText("menu");
        Menu.add(label1, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        quitterButton = new JButton();
        quitterButton.setText("Quitter");
        Menu.add(quitterButton, new com.intellij.uiDesigner.core.GridConstraints(3, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        AffichageThemes = new JPanel();
        AffichageThemes.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(12, 1, new Insets(0, 0, 0, 0), -1, -1));
        panel1.add(AffichageThemes, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 2, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        retourButton = new JButton();
        retourButton.setText("Retour");
        AffichageThemes.add(retourButton, new com.intellij.uiDesigner.core.GridConstraints(11, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        animauxButton = new JButton();
        animauxButton.setText("Animaux");
        AffichageThemes.add(animauxButton, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        automobileButton = new JButton();
        automobileButton.setText("Automobile");
        AffichageThemes.add(automobileButton, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        cuisineButton = new JButton();
        cuisineButton.setText("Cuisine");
        AffichageThemes.add(cuisineButton, new com.intellij.uiDesigner.core.GridConstraints(2, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        geographieButton = new JButton();
        geographieButton.setText("Géographie");
        AffichageThemes.add(geographieButton, new com.intellij.uiDesigner.core.GridConstraints(3, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        histoireButton = new JButton();
        histoireButton.setText("Histoire");
        AffichageThemes.add(histoireButton, new com.intellij.uiDesigner.core.GridConstraints(4, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        langueFrançaiseButton = new JButton();
        langueFrançaiseButton.setText("Langue Française");
        AffichageThemes.add(langueFrançaiseButton, new com.intellij.uiDesigner.core.GridConstraints(5, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        mathématiqueButton = new JButton();
        mathématiqueButton.setText("Mathématique");
        AffichageThemes.add(mathématiqueButton, new com.intellij.uiDesigner.core.GridConstraints(6, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        mythologieGrecoRomaineButton = new JButton();
        mythologieGrecoRomaineButton.setText("Mythologie greco-romaine");
        AffichageThemes.add(mythologieGrecoRomaineButton, new com.intellij.uiDesigner.core.GridConstraints(7, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        sportButton = new JButton();
        sportButton.setText("Sport");
        AffichageThemes.add(sportButton, new com.intellij.uiDesigner.core.GridConstraints(8, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        villeFrançaiseButton = new JButton();
        villeFrançaiseButton.setText("Ville Française");
        AffichageThemes.add(villeFrançaiseButton, new com.intellij.uiDesigner.core.GridConstraints(9, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer1 = new com.intellij.uiDesigner.core.Spacer();
        AffichageThemes.add(spacer1, new com.intellij.uiDesigner.core.GridConstraints(10, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_VERTICAL, 1, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        ChoixNiveau = new JPanel();
        ChoixNiveau.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(6, 1, new Insets(0, 0, 0, 0), -1, -1));
        panel1.add(ChoixNiveau, new com.intellij.uiDesigner.core.GridConstraints(2, 0, 1, 2, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        final JLabel label2 = new JLabel();
        label2.setText("Niveau");
        ChoixNiveau.add(label2, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        a1Button = new JButton();
        a1Button.setText("1");
        ChoixNiveau.add(a1Button, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        a2Button = new JButton();
        a2Button.setText("2");
        ChoixNiveau.add(a2Button, new com.intellij.uiDesigner.core.GridConstraints(2, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        a3Button = new JButton();
        a3Button.setText("3");
        ChoixNiveau.add(a3Button, new com.intellij.uiDesigner.core.GridConstraints(3, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        retourButton2 = new JButton();
        retourButton2.setText("Retour");
        ChoixNiveau.add(retourButton2, new com.intellij.uiDesigner.core.GridConstraints(5, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer2 = new com.intellij.uiDesigner.core.Spacer();
        ChoixNiveau.add(spacer2, new com.intellij.uiDesigner.core.GridConstraints(4, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_VERTICAL, 1, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        AffichageQuestion = new JPanel();
        AffichageQuestion.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(3, 1, new Insets(0, 0, 0, 0), -1, -1));
        panel1.add(AffichageQuestion, new com.intellij.uiDesigner.core.GridConstraints(3, 0, 1, 2, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        AffichageQuestionLabel = new JLabel();
        AffichageQuestionLabel.setText("Label");
        AffichageQuestion.add(AffichageQuestionLabel, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        retourButton1 = new JButton();
        retourButton1.setText("Retour");
        AffichageQuestion.add(retourButton1, new com.intellij.uiDesigner.core.GridConstraints(2, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer3 = new com.intellij.uiDesigner.core.Spacer();
        AffichageQuestion.add(spacer3, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_VERTICAL, 1, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
    }
}
