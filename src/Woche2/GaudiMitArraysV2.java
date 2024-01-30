package Woche2;

public class GaudiMitArraysV2 {
    public static void main(String[] args) {
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        char[] array = alphabet.toCharArray();
        char[] newArray = new char[26];

        int howMuch = 2;
        int counter =0;


        howMuch = howMuch % 26;  // -25 ... +25
        if (howMuch < 0){
            howMuch = 26+howMuch;
        }


       for (int i=howMuch; i<=25; i++){
           newArray[i] = array[i-howMuch];
       }

       for (int b= (26-howMuch); b<=25; b++){
           newArray[counter] = array[b];
           counter++;
       }

       for (int a=0; a<newArray.length;a++){
           System.out.println(newArray[a]);
       }


    }
}
