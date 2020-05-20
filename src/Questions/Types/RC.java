package Questions.Types;

import javax.swing.*;
import java.awt.*;

public class RC extends JFrame{

    private String description = "";
    private String bonneReponse = "";

    private JTextField ReponseField = new JTextField(5);

    public RC(String description, String bonneReponse) {
        this.description = description;
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

        enonce.add(new JLabel("enonce : "));

        gbcEnonce.gridx = 1;
        enonce.add(new JLabel(description),gbcEnonce);

        gbcEnonce.gridy = 1;
        gbcEnonce.gridx = 0;
        enonce.add(new JLabel("reponse : "), gbcEnonce);

        gbcEnonce.gridx = 1;
        enonce.add(ReponseField, gbcEnonce);

        return enonce;
    }

    public String getReponse(){
        return ReponseField.getText();
    }
}
