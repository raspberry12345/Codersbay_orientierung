package Woche5;

import java.util.Scanner;

public class EigenschaftenEinerZahl {
    public static void main(String[] args) {
        int luckyNumber =9;
        int chooseNumber;
        Scanner sc = new Scanner(System.in);

        System.out.println("Gib eine Zahl ein!");
        chooseNumber = sc.nextInt();

        if (chooseNumber%2==0){
            System.out.println("Die gewählte Zahl ist gerade");
        }else{
            System.out.println("Die gewählte Zahl ist ungerade");
        }
        if (chooseNumber == luckyNumber){
            System.out.println("Du hast die Glückszahl gewählt.");
        }


    }
}
