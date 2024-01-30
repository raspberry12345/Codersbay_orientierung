package Woche2;

public class KleinerAlgorithmusV1 {

    public static void main(String[] args) {
        int a = 1;
        int b = 1;
        int c;
        int counter = 5;
        while(counter > 0){
            c= a+b;
            System.out.println(a+"+"+b+"="+c);
            a=b;
            b=c;
            counter--;
        }
    }
}
