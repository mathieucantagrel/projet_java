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
import java.util.ArrayList;


public class Eureka_front {

    private Themes th;
    private ArrayList<Themes> liste_theme = new ArrayList<Themes>(9);
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
    private String reponse;

    public Eureka_front() {
        this.f = new JFrame("Eureka");
        f.setContentPane(JpanelJeux);
        f.setSize(500,175);
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        f.setLocationRelativeTo(null);
        th = new Themes("Sport");
        f.setVisible(true);
        ValidRCButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                if(ReponseText.getText().toLowerCase().equals(reponse.toLowerCase()))
                {
                    System.out.println("YES!!!!");
                }
            }
        });
        Vrai.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean vrai = true;
                if(reponse.equals(String.valueOf(vrai)))
                {
                    System.out.println("YESSSS");
                }
            }
        });
        Faux.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean faux = false;
                if(reponse.equals(String.valueOf(faux)))
                {
                    System.out.println("YESSSS");
                }
            }
        });
        Proposition1Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(Proposition1Button.getText().equals(reponse))
                {
                    System.out.println("YESSSS");
                }
            }
        });
        Proposition2Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(Proposition2Button.getText().equals(reponse))
                {
                    System.out.println("YESSSS");
                }
            }
        });
        Proposition3Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(Proposition3Button.getText().equals(reponse))
                {
                    System.out.println("YESSSS");
                }
            }
        });
    }

    public void ajouter_theme(Themes theme) { this.liste_theme.add(theme); }

    public void creation_question()
    {
        th.SaisirListeQuestions().charger_question_QCM(th.getNom());
        th.SaisirListeQuestions().charger_Question_VF(th.getNom());
        th.SaisirListeQuestions().charger_question_RC(th.getNom());
    }


    public void afficher_bonne_question(int n)
    {
        System.out.println(this.th.SaisirListeQuestions().SelectionnerQuestion(n).saisir().getClass().getName());
        switch (this.th.SaisirListeQuestions().SelectionnerQuestion(n).saisir().getClass().getName()){
            case "Question.QCM":{

                this.QuestionQCMLabel.setText(this.th.SaisirListeQuestions().SelectionnerQuestion(n).QCMtype().getQuestion());
                this.Proposition1Button.setText(this.th.SaisirListeQuestions().SelectionnerQuestion(n).QCMtype().getProposition().get(0));
                this.Proposition2Button.setText(this.th.SaisirListeQuestions().SelectionnerQuestion(n).QCMtype().getProposition().get(1));
                this.Proposition3Button.setText(this.th.SaisirListeQuestions().SelectionnerQuestion(n).QCMtype().getReponse());
                this.Theme1.setText(th.SelectionnerTheme());
                this.Joueur1.setText("Joueur 1");
                this.Level1.setText("Niveau " + String.valueOf(this.th.SaisirListeQuestions().SelectionnerQuestion(n).getLevel()));
                this.f.setContentPane(this.QCMJpanel);
                this.reponse = th.SaisirListeQuestions().SelectionnerQuestion(n).QCMtype().getReponse();
                break;
            }
            case "Question.VF":{
                this.QuestionVF.setText(this.th.SaisirListeQuestions().SelectionnerQuestion(n).VFtype().getQuestion());
                this.Vrai.setText("Vrai");
                this.Faux.setText("Faux");

                this.Theme2.setText(th.SelectionnerTheme());
                this.Joueur2.setText("Joueur 2");
                this.Level2.setText("Niveau " + String.valueOf(this.th.SaisirListeQuestions().SelectionnerQuestion(n).getLevel()));
                this.f.setContentPane(this.VFJpanel);
                this.reponse = String.valueOf(th.SaisirListeQuestions().SelectionnerQuestion(n).VFtype().GetReponse());
                break;
            }
            case "Question.RC":{
                this.QuestionRC.setText(this.th.SaisirListeQuestions().SelectionnerQuestion(n).RCtype().getQuestion());

                this.Theme3.setText(th.SelectionnerTheme());
                this.Joueur3.setText("Joueur 3");
                this.Level3.setText("Niveau " + String.valueOf(this.th.SaisirListeQuestions().SelectionnerQuestion(n).getLevel()));
                this.f.setContentPane(this.RCJpanel);
                this.reponse= th.SaisirListeQuestions().SelectionnerQuestion(n).RCtype().getReponse();
                break;
            }
        }
        this.f.revalidate();

    }
}
