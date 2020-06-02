package Questions;

import java.util.LinkedList;
import java.util.List;

public class ListeQuestion {

    LinkedList<Question> Liste;

    public ListeQuestion(LinkedList<Question> liste) {
        Liste = liste;
    }

    public void AjouterQuestion(Question question){
        Liste.add(question);
    }

    public void SUpprimerQuestion(int indice){
        Liste.remove(indice);
    }

    public Question SelectionnerQuestion(){

        int randomIndice = (int) (Math.random() * (Liste.size()));
        return Liste.get(randomIndice);

    }

    @Override
    public String toString() {
        return "ListeQuestion{" +
                "Liste=" + Liste +
                '}';
    }
}
