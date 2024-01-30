package Woche5;

import java.util.Scanner;

public class NotenÜbersetzen {
    public static void main(String[] args) {
        int input;

        Scanner sc = new Scanner(System.in);
        System.out.println("Gibt eine Note von 1 bis 5 ein:");
        input = sc.nextInt();

        if (input == 1){
            System.out.println("Sehr gut");
        } else if (input == 2) {
            System.out.println("gut");
        }else if (input == 3) {
            System.out.println("befriedigend");
        }else if (input == 4) {
            System.out.println("genügend");
        }else if (input == 5) {
            System.out.println("nicht genügend");
        }
    }
}
