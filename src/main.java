import Questions.Question;
import Questions.VF;

public class main {
    public static void main(String[] args) {

        VF test = new VF("test", true);
        Question question = new Question(0,"test", 0, test);

        Affichage affichage = new Affichage(question);

    }
}
