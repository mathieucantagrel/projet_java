package Questions.Types;

import javax.swing.*;
import java.awt.*;

public class QCM {

    private String description = "";
    private String reponse1 = "";
    private String reponse2 = "";
    private String reponse3 = "";
    private String bonneReponse = "";

    private ButtonGroup reponse = new ButtonGroup();
    private JRadioButton rep1 = new JRadioButton(reponse1);
    private JRadioButton rep2 = new JRadioButton(reponse2);
    private JRadioButton rep3 = new JRadioButton(reponse3);
    private JRadioButton rep4 = new JRadioButton(bonneReponse);

    public QCM(String description, String reponse1, String reponse2, String reponse3, String bonneReponse) {
        this.description = description;
        this.reponse1 = reponse1;
        this.reponse2 = reponse2;
        this.reponse3 = reponse3;
        this.bonneReponse = bonneReponse;
    }

    public String getDescription() {
        return description;
    }

    public String getBonneReponse() {
        return bonneReponse;
    }

    public JPanel Afficher(){
        JPanel enonce = new JPanel();
        enonce.setLayout(new GridBagLayout());

        GridBagConstraints gbcEnonce = new GridBagConstraints();
        gbcEnonce.gridx = 0;
        gbcEnonce.gridy = 0;
        gbcEnonce.gridwidth = 1;
        gbcEnonce.gridheight = 1;
        gbcEnonce.insets = new Insets(10, 20, 10, 20);

        enonce.add(new JLabel("enonce"));

        gbcEnonce.gridx = 1;
        enonce.add(rep1);

        gbcEnonce.gridy = 1;
        enonce.add(rep2);

        gbcEnonce.gridy = 2;
        enonce.add(rep3);

        gbcEnonce.gridy = 3;
        enonce.add(rep4);

        return enonce;
    }
}

// TODO: 5/20/2020 fix affichage