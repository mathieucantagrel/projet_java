package Questions;

import javax.swing.*;
import java.awt.*;

public class Question<T extends VF> extends JFrame {

    private Integer numero;
    private String theme;
    private Integer difficulte;
    private T enonce;

    public Question(Integer numero, String theme, Integer difficulte, T enonce) {
        this.numero = numero;
        this.theme = theme;
        this.difficulte = difficulte;
        this.enonce = enonce;
    }

    public JPanel Afficher(){
        JPanel mainPan = new JPanel();
        mainPan.setLayout(new GridLayout(4,2));
        mainPan.add(new JLabel("numero : "));
        mainPan.add(new JLabel(String.valueOf(numero)));
        mainPan.add(new JLabel("theme : "));
        mainPan.add(new JLabel(theme));
        mainPan.add(new JLabel("difficulte : "));
        mainPan.add(new JLabel(String.valueOf(difficulte)));
        mainPan.add(new JLabel("enonce : "));
        mainPan.add(enonce.Afficher());

        return mainPan;
    }
}

// TODO: 5/20/2020 T doit pouvoir extends QCM, VF et RC