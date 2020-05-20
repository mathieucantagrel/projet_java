package Questions.Types;

import javax.swing.*;
import java.awt.*;

public class VF extends JFrame{

    private String description = "";
    private final Boolean bonneReponse;

    private ButtonGroup reponse = new ButtonGroup();
    private JRadioButton vrai = new JRadioButton("Vrai");
    private JRadioButton faux = new JRadioButton("Faux");

    public VF(String description, Boolean bonneReponse) {
        this.description = description;
        this.bonneReponse = bonneReponse;
    }

    public String getDescription() {
        return description;
    }

    public Boolean getBonneReponse() {
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


        reponse.add(vrai);
        reponse.add(faux);

        enonce.add(new JLabel(description), gbcEnonce);

        gbcEnonce.gridx = 1;
        enonce.add(vrai);

        gbcEnonce.gridy = 1;
        enonce.add(faux);

        return enonce;
    }

    public Boolean getReponse(){
        if (vrai.isSelected()){
            return true;
        }
        return false;
    }

}
