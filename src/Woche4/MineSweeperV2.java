package Woche4;

import java.util.Random;
import java.util.Scanner;

public class MineSweeperV2 {


    static int mineCount = 0;
    static int countField = 0;
    static String[][] checkNext(int[][] randomNumbers, String[][] map, int convertY, int convertX) {


        // bestimme den offset
        int offset=randomNumbers[convertY][convertX];
        offset = offset+1;
        int lowBorderX = convertX+offset;
        int highBorderX = convertX+(offset*(-1));
        int lowBorderY = convertY+offset;
        int highBorderY = convertY+(offset*(-1));
        //-------------------

        // limit border out of playfield
        if (lowBorderX<0){
            lowBorderX=0;
        } else if (highBorderX > 9) {
            highBorderX =9;
        }
        if (lowBorderY <0) {
            lowBorderY = 0;
        } else if (highBorderY >9) {
            highBorderY =9;
        }
        //-------------------


        // write area in map




        for (int i =lowBorderY; i<=highBorderY; i++){
            for (int j=lowBorderX; j<=highBorderX;j++){
                if (randomNumbers[i][j] == 0){
                    map[i][j] = "[*]";
                    mineCount--;
                }else{
                    if(map[i][j].equals("[ ]")){
                    map[i][j] = "[-]";
                    countField++;
                    }
                }
            }
        }return map;



    }

    public static void main(String[] args) {
        String[][] map = {{"[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]"},
                {"[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]"},
                {"[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]"},
                {"[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]"},
                {"[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]"},
                {"[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]"},
                {"[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]"},
                {"[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]"},
                {"[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]"},
                {"[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]"}};


        int [][] randomNumbers = new int[10][10];



        Scanner sc = new Scanner(System.in);
        char[] inputChar = new char[2];
        int convertX=0;
        int convertY=0;
        boolean access = true;
        inputChar[0] = ' ';
        inputChar[1] = ' ';

        String input = "";



        //------------------------------------------------------------------------------
        // Befüllung mit minen und zählen der minenanzahl
        Random r = new Random(0);
        for (int j = 0; j < map.length; j++) {
            for (int k = 0; k < map.length; k++) {

                randomNumbers[k][j] = r.nextInt(4) - 3;
                if (randomNumbers[k][j] == 0) {
                    mineCount++;
                }
            }
        }

        //------------------------------------------------------------------------------



        while(access) {


            //------------------------------------------------------------------------------
            // Spielfeld Output

            System.out.println("   A  B  C  D  E  F  G  H  I  J");
            for (int i = 0; i < map.length; i++) {


                System.out.println(i + " " + map[i][0] + map[i][1] + map[i][2] + map[i][3] + map[i][4] + map[i][5] + map[i][6] + map[i][7] + map[i][8] + map[i][9]);


            }
            //------------------------------------------------------------------------------


            System.out.println(String.format("Du hast %d/%d (%.1f %%) des nicht verminten Gebiets auf Minen gecheckt",countField,(100-mineCount),(double)(countField*100)/(100-mineCount)));

            System.out.println("Es bleiben noch " + mineCount + " Minen versteckt.");

            do {
                System.out.println("Wo willst du nach Minen suchen?");
                input = sc.nextLine().toUpperCase();

            }while (!(input.matches("[A-J][0-9]")));

            boolean accessField = false;

            do {
                for (int m = 0; m < inputChar.length; m++) {
                    inputChar[m] = input.toUpperCase().charAt(m);
                }


                //------------------------------------------------------------------------------
                // Convert letters to numbers

                if (inputChar[0] == 'A') {
                    convertX = 0;
                    convertY = inputChar[1] - 48;
                } else if (inputChar[0] == 'B') {
                    convertX = 1;
                    convertY = inputChar[1] - 48;
                } else if (inputChar[0] == 'C') {
                    convertX = 2;
                    convertY = inputChar[1] - 48;
                } else if (inputChar[0] == 'D') {
                    convertX = 3;
                    convertY = inputChar[1] - 48;
                } else if (inputChar[0] == 'E') {
                    convertX = 4;
                    convertY = inputChar[1] - 48;
                } else if (inputChar[0] == 'F') {
                    convertX = 5;
                    convertY = inputChar[1] - 48;
                } else if (inputChar[0] == 'G') {
                    convertX = 6;
                    convertY = inputChar[1] - 48;
                } else if (inputChar[0] == 'H') {
                    convertX = 7;
                    convertY = inputChar[1] - 48;
                } else if (inputChar[0] == 'I') {
                    convertX = 8;
                    convertY = inputChar[1] - 48;
                } else if (inputChar[0] == 'J') {
                    convertX = 9;
                    convertY = inputChar[1] - 48;
                }else{
                    System.out.println("Error");
                }


            //------------------------------------------------------------------------------



            //------------------------------------------------------------------------------
            // Check already used field

                if (map[convertY][convertX].equals("[-]")||map[convertY][convertX].equals("[*]")){

                        accessField = true;
                        System.out.println("Wo willst du nach Minen suchen?");
                        input = sc.nextLine().toUpperCase();


                }else{
                    //------------------------------------------------------------------------------
                    // Check field
                    accessField=false;
                    if (randomNumbers[convertY][convertX] == 0){
                        access = false;
                        map[convertY][convertX]= "[*]";
                        System.out.println("Das... war eine Mine. Du hast leider verloren.");



                        //------------------------------------------------------------------------------
                        // Spielfeld Output

                        System.out.println("   A  B  C  D  E  F  G  H  I  J");
                        for (int i = 0; i < map.length; i++) {


                            System.out.println(i + " " + map[i][0] + map[i][1] + map[i][2] + map[i][3] + map[i][4] + map[i][5] + map[i][6] + map[i][7] + map[i][8] + map[i][9]);


                        }
                        //------------------------------------------------------------------------------



                    }else if(randomNumbers[convertY][convertX] <0 && randomNumbers[convertY][convertX] >-4) {
                        map[convertY][convertX]= "[-]";
                        //---------------------
                        //hier ansetzen
                        map = checkNext(randomNumbers,map ,convertY ,convertX);
                        countField++;
                    }else{
                        System.out.println("Error");
                    }

                    //------------------------------------------------------------------------------
                }

            }while(accessField);









        }





    }
}
