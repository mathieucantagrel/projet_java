import Questions.Question;
import Questions.Types.QCM;
import Questions.Types.RC;
import Questions.Types.VF;

import javax.swing.*;
import java.awt.*;

public class Affichage extends JFrame {

    public Affichage(Question question){



        JFrame frame = new JFrame();
        frame.setLayout(new BorderLayout());

        JPanel mainPan = question.Afficher();

        frame.add(mainPan, BorderLayout.NORTH);

        switch (question.getEnonce().getClass().getName()){
            case "Questions.Types.QCM":{
                QCM enonce = (QCM) question.getEnonce();
                frame.add(enonce.Afficher(), BorderLayout.CENTER);
                break;
            }
            case "Questions.Types.VF":{
                VF enonce = (VF) question.getEnonce();
                frame.add(enonce.Afficher(), BorderLayout.CENTER);
                break;
            }
            case "Questions.Types.RC":{
                RC enonce = (RC) question.getEnonce();
                frame.add(enonce.Afficher(), BorderLayout.CENTER);
                break;
            }
        }

        this.pack();

        frame.setSize(new Dimension(600,600));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}

// TODO: 5/20/2020 peut etre touver une autre methode que de devoir passer par cette classe (pas opti)