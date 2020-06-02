package main;
import Question.*;
import Themes.*;
import front.Eureka_front;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        Themes th = new Themes("Sport");
        Eureka_front l = new Eureka_front();
        l.creation_question();
        l.afficher_bonne_question(0);
        th.SaisirListeQuestions().charger_Question_VF(th.getNom());
        th.SaisirListeQuestions().charger_question_QCM(th.getNom());
        th.SaisirListeQuestions().AfficherListe();





    }
}
