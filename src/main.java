import Questions.Question;
import Questions.Types.QCM;
import Questions.Types.RC;
import Questions.Types.VF;

public class main {
    public static void main(String[] args) {

        VF test = new VF("testVF", true);
        Question<VF> question = new Question<VF>("test", 0, test);

        RC testRC = new RC("testRC", "test");
        Question<RC> questionRC = new Question<RC>("test", 0, testRC);

        QCM testQCM = new QCM("testQCM", "test1", "test2", "test3", "test4");
        Question<QCM> questionQCM = new Question<QCM>("test", 0, testQCM);

        Affichage affichage = new Affichage(questionRC);

    }
}
