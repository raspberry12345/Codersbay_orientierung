package Woche5;

import java.util.HashMap;
import java.util.Scanner;

public class Leetspeak {

    static char translate(char singleSign){
        // falls schlüssel vorhanden change zeichen
        // else keine leetcode
        if (map.containsKey(singleSign)){
            return map.get(singleSign);
        }else {
            return singleSign;
        }


    }
    //Deklaration
    static HashMap<Character, Character> map = new HashMap<>();

    public static void main(String[] args) {
        String inputText;
        Scanner sc = new Scanner(System.in);

        //Initialisierung
        map.put('A', '5');
        map.put('E', '0');
        map.put('R', '3');
        map.put('U', '2');

        //programmstart
        System.out.println("Gib Text ein!");
        inputText = sc.nextLine();




        for ( char c : inputText.toCharArray()){
            c = Character.toUpperCase(c);
            System.out.println(translate(c));
        }
    }
}
