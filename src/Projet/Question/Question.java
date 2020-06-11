package Projet.Question;

import java.util.concurrent.atomic.AtomicInteger;

public class Question <T> {
    private static AtomicInteger id = new AtomicInteger(0);
    private final int numero;
    private int level;
    private T enonce;

    public Question(int level, T enoncee) {
        this.numero = id.incrementAndGet();
        this.level = level;
        this.enonce = enoncee;
    }

    public int getLevel() { return level; }

    public void setLevel(int level) { this.level = level; }

    public T getEnonce() { return this.enonce; }

    public void setEnonce(T enonce) { this.enonce = enonce; }

    public QCM QCMtype() { return (QCM)this.enonce; }
    public VF VFtype() { return (VF)this.enonce; }
    public RC RCtype() { return (RC)this.enonce; }

    public void Afficher()
    {
        System.out.println("Level : "+level+"");
        System.out.println("Type de question : "+ enonce);
    }
    public T saisir() { return this.enonce; }

    @Override
    public String toString() {
        return "Projet.Question{" +
                "numero=" + numero +
                ", level=" + level +
                ", type=" + enonce.toString() +
                '}';
    }
}
