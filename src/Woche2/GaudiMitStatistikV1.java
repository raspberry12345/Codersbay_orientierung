package Woche2;

public class GaudiMitStatistikV1 {
    public static void main(String[] args) {
        String content = "Unter #Handy finden sich 6 große Anbieter, 2 davon sind aber die besten!";
        char[] myArr = content.toCharArray();
        int countLetteruppercase=0;
        int countLetterlowercase=0;
        int countNumbers=0;
        int elseSign=0;

        for (int i=0; i<myArr.length;i++){

            char dummy = myArr[i];
            if('A' <= dummy && dummy <= 'Z'){
                //letter uppercase
                countLetteruppercase++;
            } else if ('a'<= dummy && dummy <='z') {
                //letter lowercase
                countLetterlowercase++;
            } else if ('0'<= dummy && dummy <='9') {
                countNumbers++;
            } else {
                elseSign++;
            }


        }
        System.out.println("Großbuchstaben: " + countLetteruppercase);
        System.out.println("Kleinbuchstaben: " + countLetterlowercase);
        System.out.println("Zahlen: " + countNumbers);
        System.out.println("Sonstige Zeichen: " + elseSign);
    }
}
