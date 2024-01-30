package Woche8;

import java.util.HashMap;
import java.util.Scanner;

public class Wörterbuch {

    public static void addToDic(String english, String german){
        englishToGerman.put(english, german);
        germanToEnglish.put(german, english);
    }

    public static void removeFromDic(String english){
        String counterPart;
        if (englishToGerman.containsKey(english)){
            englishToGerman.remove(english);
            germanToEnglish.remove(englishToGerman.get(english));
            System.out.println("Erfolgreich aus dem Wörterbuch gelöscht!");
            System.out.println();
        }else{
            System.out.println("Es wurde kein Eintrag im Wörterbuch gefunden!");
            System.out.println();
        }
    }

    public static void search(int option, String word){
        if (option ==1){
            if (germanToEnglish.containsKey(word)){
                System.out.println(word +" -> "+ germanToEnglish.get(word));
            }else{
                System.out.println("Das gesuchte Vokabel ist nicht vorhanden");
            }
        } else if (option ==2) {
            if (englishToGerman.containsKey(word)){
                System.out.println(word +" -> "+ englishToGerman.get(word));
            }else{
                System.out.println("Das gesuchte Vokabel ist nicht vorhanden");
            }
        }else{
            System.out.println("error");
        }
    }



    static HashMap<String, String> englishToGerman = new HashMap<>();
    static HashMap<String, String> germanToEnglish = new HashMap<>();
    public static void main(String[] args) {
        String english;
        String german;
        int option;
        int optionLanguage;
        boolean menu = true;
        Scanner sa = new Scanner(System.in);
        Scanner sb = new Scanner(System.in);
        Scanner sc = new Scanner(System.in);
        Scanner sd = new Scanner(System.in);

        while(menu){
            System.out.println("Was möchten Sie machen?");
            System.out.println("option 1: Einfügen ins Wörterbuch");
            System.out.println("option 2: Lösche Elemente aus dem Wörterbuch");
            System.out.println("option 3: Suche nach einer Übersetzung");
            System.out.println("Eingabe der gewünschten Option über die Zahl und anschließender Enter-Taste (eingabe=0 entspricht Abbruch)");
            option = sa.nextInt();

            if (option == 1){
            System.out.println("Englische Eingabe ins Wörterbuch:");

            english = sb.nextLine();
            System.out.println("Zugehörige deutsche Eingabe ins Wörterbuch:");
            german = sc.nextLine();
            addToDic(english, german);
            } else if (option == 2) {
                System.out.println("Gib ein englisches Wort ein, welches aus dem Wöterbuch entfernt werden soll!");
                english = sc.nextLine();
                removeFromDic(english);
            } else if (option == 3) {
                System.out.println("Option 1: Suche zum deutschen Wort die englische Übersetzung");
                System.out.println("Option 2: Suche zum englischen Wort die deutsche Übersetzung");
                optionLanguage = sc.nextInt();
                System.out.println("Gib das gesuchte Wort ein!");
                english = sd.nextLine();
                search(optionLanguage, english);
            } else if (option == 0) {
                System.out.println("schließe das Wörterbuch");
                menu = false;
            } else{
                System.out.println("Error");
            }
        }

    }
}
