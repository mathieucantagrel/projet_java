package Question;

import java.io.BufferedReader;
import java.nio.file.Files;
import java.util.ArrayList;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.charset.Charset;
import java.util.HashSet;

public class ListeQuestions <T> {
    ArrayList<Question<T>> listeQuestion;

    public ListeQuestions() {
        this.listeQuestion = new ArrayList<Question<T>>();
    }//Constructeur

    public void AfficherListe() {
        for (Question<T> q : listeQuestion) {
            q.Afficher();
        }
    }//Affichage

    public void AjouterQuestion(Question<T> question) {
        listeQuestion.add(question);
    }//Ajout

    public void SupprimerQuestion(int n) {
        listeQuestion.remove(n);
    }//Suppression

    public Question<T> SelectionnerQuestion(int n) {
        return this.listeQuestion.get(n);
    }//Selection

    public ArrayList<Question<T>> GetListeQuestion() {
        return this.listeQuestion;
    }

    public void charger_Question_VF(String nom_theme) {
        Question q;
        VF vf;
        Charset encodage = Charset.forName("UTF-8");

        Path path = Paths.get("Fichier/" + nom_theme + "/Question_VF.txt");

        try (BufferedReader bufferedReader = Files.newBufferedReader(path, encodage)) {
            String string = null;

            while ((string = bufferedReader.readLine()) != null) {
                vf = new VF();
                vf.setQuestion(bufferedReader.readLine());
                vf.setReponse(Boolean.parseBoolean(bufferedReader.readLine()));
                q = new Question(Integer.parseInt(string), vf);
                this.AjouterQuestion(q);
                bufferedReader.readLine();
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());

        }
    }

    public void charger_question_QCM(String nom_theme) {
        Question q;
        QCM qcm;
        Charset encodage = Charset.forName("UTF-8");
        ArrayList proposition;
        Path path = Paths.get("Fichier/" + nom_theme + "/Question_QCM.txt");

        try (BufferedReader bufferedReader = Files.newBufferedReader(path, encodage)) {
            String string = null;

            while ((string = bufferedReader.readLine()) != null) {
                qcm = new QCM();
                proposition = new ArrayList<>();
                qcm.setQuestion(bufferedReader.readLine());
                qcm.setReponse(bufferedReader.readLine());
                proposition.add(bufferedReader.readLine());
                proposition.add(bufferedReader.readLine());
                qcm.setProposition(proposition);
                q = new Question(Integer.parseInt(string), qcm);
                this.AjouterQuestion(q);
                bufferedReader.readLine();
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());

        }

    }

    public void charger_question_RC(String nom_theme) {
        Question q;
        RC rc;
        Charset encodage = Charset.forName("UTF-8");

        Path path = Paths.get("Fichier/" + nom_theme + "/Question_RC.txt");

        try (BufferedReader bufferedReader = Files.newBufferedReader(path, encodage)) {
            String string = null;

            while ((string = bufferedReader.readLine()) != null) {
                rc = new RC();
                rc.setQuestion(bufferedReader.readLine());
                rc.setReponse(bufferedReader.readLine());
                q = new Question(Integer.parseInt(string), rc);
                this.AjouterQuestion(q);
                bufferedReader.readLine();
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());

        }


    }
}
