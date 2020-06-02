package Questions.Types;

import javax.swing.*;
import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class QCM extends JFrame{

    private String description;
    private String reponse1;
    private String reponse2;
    private String reponse3;
    private String bonneReponse;

    private ButtonGroup reponse = new ButtonGroup();
    private JRadioButton rep1 = new JRadioButton();
    private JLabel rep1Label = new JLabel();
    private JRadioButton rep2 = new JRadioButton();
    private JRadioButton rep3 = new JRadioButton();
    private JRadioButton rep4 = new JRadioButton();

    public QCM(String description, String reponse1, String reponse2, String reponse3, String bonneReponse) {
        this.description = description;
        this.reponse1 = reponse1;
        this.reponse2 = reponse2;
        this.reponse3 = reponse3;
        this.bonneReponse = bonneReponse;
    }

    public String getReponse1() {
        return reponse1;
    }

    public String getReponse2() {
        return reponse2;
    }

    public String getReponse3() {
        return reponse3;
    }

    public String getDescription() {
        return description;
    }

    public String getBonneReponse() {
        return bonneReponse;
    }

    public boolean getReponse(){
        if (rep4.isSelected()){
            return true;
        }
        return false;
    }

    public JPanel Afficher(){

        ArrayList<String> ordre = randomList();

        JPanel enonce = new JPanel();
        enonce.setLayout(new GridBagLayout());

        GridBagConstraints gbcEnonce = new GridBagConstraints();
        gbcEnonce.gridx = 0;
        gbcEnonce.gridy = 0;
        gbcEnonce.gridwidth = 1;
        gbcEnonce.gridheight = 1;
        gbcEnonce.insets = new Insets(10, 20, 10, 20);

        enonce.add(new JLabel(description),gbcEnonce);

        reponse.add(rep1);
        reponse.add(rep2);
        reponse.add(rep3);
        reponse.add(rep4);

        gbcEnonce.gridx = 1;
        rep1.setText(ordre.get(0));
        enonce.add(rep1, gbcEnonce);

        gbcEnonce.gridy = 1;
        rep2.setText(ordre.get(1));
        enonce.add(rep2, gbcEnonce);

        gbcEnonce.gridy = 2;
        rep3.setText(ordre.get(2));
        enonce.add(rep3, gbcEnonce);

        gbcEnonce.gridy = 3;
        rep4.setText(ordre.get(3));
        enonce.add(rep4, gbcEnonce);

        return enonce;
    }

    private ArrayList<String> randomList(){

        ArrayList<String> ordre = new ArrayList<>(Arrays.asList(reponse1, reponse2, reponse3, bonneReponse)) ;
        Collections.shuffle(ordre);
        return ordre;

    }
}