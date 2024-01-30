package Woche2;

public class PseudoCode {
    public static void main(String[] args) {
        int c= 0;
        int choosenVaule= 5;

        for(int k = 2; k< choosenVaule; k++){
            if (choosenVaule % k == 0){
                c++;
            }
        }
        if (c>0){
            System.out.println("keine Primzahl");
        }else{
            System.out.println("Primzahl gefunden");
        }










    }
}
