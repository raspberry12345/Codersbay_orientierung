package Woche5;

public class WorkingWithStrings {
    public static void main(String[] args) {
        String text = " Hello World! ";
        String codersBay = "Codersbay";
        String wholeText = "";

        System.out.println("String: "+text);
        //in der abfrage der stringlänge sind die leerzeichen inkludiert!!!
        System.out.println("Stringlänge: "+text.length());
        System.out.println("String mit uppercase: "+text.toUpperCase());
        System.out.println("String mit lowercase: "+text.toLowerCase());
        text = text.replace("World", codersBay);
        System.out.println("use replace-method: "+text);
        text = text.substring(1, 17);
        System.out.println("ohne white-space am anfang:"+text);

        /*for (int i =0; i<15;i++){
            System.out.println(text);
        }*/

        System.out.println((text+"\n").repeat(15));

    }
}
