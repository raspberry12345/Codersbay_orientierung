package Woche13;

public class Lens {
    static int countLens = 0;
    private int minFocalWidth;
    private int maxFocalWidth;


    //konstruktor
    public Lens(int minimaleBrennweite, int maximaleBrennweite) {
        if (minimaleBrennweite < maximaleBrennweite) {
            this.minFocalWidth = minimaleBrennweite;
            this.maxFocalWidth = maximaleBrennweite;
            countLens++;
        } else {
            System.out.println("Try again. The minimum focal length is greater than the maximum focal length");
        }
    }
    //start setters

    //end setters


    //start getter
    public int getMinFocalWidth() {
        return this.minFocalWidth;
    }

    public int getMaxFocalWidth() {
        return this.maxFocalWidth;
    }
    //end getter
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Minimale Brennweite: ");
        sb.append(this.minFocalWidth).append(" | ");
        sb.append("Maximale Brennweite: ");
        sb.append(this.maxFocalWidth).append(" | ");



        return sb.toString();
    }
}
