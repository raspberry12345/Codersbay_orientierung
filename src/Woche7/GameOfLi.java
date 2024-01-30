package Woche7;

import java.util.Arrays;
import java.util.Random;

public class GameOfLi {


    public static void Random(String[][] lifeMap) {
        Random rn = new Random();
        for (int j = 0; j < lifeMap.length; j++) {
            for (int i = 0; i < lifeMap.length; i++) {
                boolean randomLife = rn.nextBoolean();

                if (randomLife) {
                    lifeMap[i][j] = "#";
                } else {
                    lifeMap[i][j] = ".";
                }
            }
        }
    }

    public static void checkNeighborhood(String[][] lifeMap, int row, int column, String[][] stayAlive) {
        //setze schleifenintervall für die direkten Nachbarn
        int distanz =1;
        int rowStart = row-distanz;
        int rowEnd = row+distanz;
        int columnStart = column-distanz;
        int columnEnd = column+distanz;
        int countLifeCell =0;

        //verhindere zugriff außerhalb des arrays

        //in zeilen-richtung
        if (rowStart<0){
            rowStart=0;
        } else if (rowEnd>=lifeMap.length) {
            rowEnd=row;
        }

        //in spalten-richtung
        if (columnStart<0){
            columnStart=0;
        } else if (columnEnd>=lifeMap.length) {
            columnEnd=column;
        }

        //urspungselement ist lebende Zelle
        if (lifeMap[row][column].contains("#")){
            countLifeCell--;
        }

        //zähle anzahl der nachbarn
        for (int j=columnStart; j<=columnEnd; j++){
            for (int i=rowStart; i<=rowEnd; i++){
                if (lifeMap[i][j].contains("#")){
                    countLifeCell++;
                }
            }
        }

        stayAlive[row][column] = Integer.toString(countLifeCell);

    }

    public static void overwritelifeMap(String[][] stayAlive, String[][] lifeMap) {


        for (int j=0; j<stayAlive.length; j++){
            for (int i=0; i<stayAlive.length; i++){
                if (Integer.parseInt(stayAlive[i][j])==3 && lifeMap[i][j].contains(".")){
                    lifeMap[i][j] = "#";
                } else if (Integer.parseInt(stayAlive[i][j])<2 && lifeMap[i][j].contains("#")) {
                    lifeMap[i][j] = ".";
                } else if (Integer.parseInt(stayAlive[i][j])>=2 && lifeMap[i][j].contains("#")) {
                    lifeMap[i][j] = "#";
                } else if (Integer.parseInt(stayAlive[i][j])>3 && lifeMap[i][j].contains("#")) {
                    lifeMap[i][j] = ".";
                }
            }
        }
    }
    public static void output(String[][] lifeMap) {
        String outputStream="";
        for (int j = 0; j < lifeMap.length; j++) {
            for (int i = 0; i < lifeMap.length; i++) {
                outputStream += lifeMap[i][j]+" ";
            }
            System.out.println(outputStream);
            outputStream = "";

        }
    }

    public static void main(String[] args) {
        String[][] lifeMap = new String[10][10];
        String[][] stayAlive = new String[10][10];
        int generation = 2;


        // befüllen mit einem bestimmten Wert
        /*
        for (String[] row: stayAlive) {
            Arrays.fill(row, "2");
        }
        */

        //random befüllen der map
        Random(lifeMap);
        //ausgabe der random befüllten map

        output(lifeMap);
        System.out.println(" ");
        for (int k=0; k<generation; k++){
            //check wieviele lebende Nachbarn
            for (int j=0; j<lifeMap.length; j++) {
                for (int i = 0; i < lifeMap.length; i++) {
                    checkNeighborhood(lifeMap, i, j, stayAlive);
                }
            }

            //ausgabe
            //Output(stayAlive);

            //überschreie die lifeMap mit der zukünftigen version
            overwritelifeMap(stayAlive, lifeMap);
            output(lifeMap);
            System.out.println(" ");
        }
    }
}
