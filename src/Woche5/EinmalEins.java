package Woche5;

public class EinmalEins {
    public static void main(String[] args) {
        for (int i=1; i<=10; i++){
            System.out.println(" ");
            System.out.println(i+"er Reihe");
            for (int j=1; j<=10; j++){
                System.out.println(i+"*"+j+"="+(i*j));
            }
        }
    }
}
