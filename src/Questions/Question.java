package Questions;

import javax.swing.*;
import java.awt.*;

public class Question<T> extends JFrame{

    private static Integer numero = 0;
    private int numeroQuestion;
    private String theme;
    private Integer difficulte;
    private T enonce;

    public Question(String theme, Integer difficulte, T enonce) {
        this.numero = ++numero;
        this.numeroQuestion = numero;
        this.theme = theme;
        this.difficulte = difficulte;
        this.enonce = enonce;
    }

    public T getEnonce() {
        return enonce;
    }

    public JPanel Afficher(){
        JPanel mainPan = new JPanel();
        mainPan.setLayout(new GridLayout(4,2));
        mainPan.add(new JLabel("numero : "));
        mainPan.add(new JLabel(String.valueOf(numeroQuestion)));
        mainPan.add(new JLabel("theme : "));
        mainPan.add(new JLabel(theme));
        mainPan.add(new JLabel("difficulte : "));
        mainPan.add(new JLabel(String.valueOf(difficulte)));

        return mainPan;
    }
}

// TODO: 5/20/2020 T doit pouvoir extends QCM, VF et RC