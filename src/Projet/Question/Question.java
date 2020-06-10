package Projet.Question;

import java.util.concurrent.atomic.AtomicInteger;

public class Question <T> {
    private static AtomicInteger id = new AtomicInteger(0);
    private final int numero;
    private int level;
    private T type;

    public Question(int level, T enoncee) {
        this.numero = id.incrementAndGet();
        this.level = level;
        this.type = enoncee;
    }

    public int getLevel() { return level; }

    public void setLevel(int level) { this.level = level; }

    public T getType() { return this.type; }

    public void setType(T type) { this.type = type; }

    public QCM QCMtype() { return (QCM)this.type; }
    public VF VFtype() { return (VF)this.type; }
    public RC RCtype() { return (RC)this.type; }

    public void Afficher()
    {
        System.out.println("Level : "+level+"");
        System.out.println("Type de question : "+type);
    }
    public T saisir() { return this.type; }

    @Override
    public String toString() {
        return "Projet.Question{" +
                "numero=" + numero +
                ", level=" + level +
                ", type=" + type.toString() +
                '}';
    }
}
