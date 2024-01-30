package Woche13;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainCamera {
    public static void main(String[] args) {
        List<Camera> cameraList = new ArrayList<>();
        List<Lens> lensList = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int input = 1;

        cameraList.add(new Camera("sony", 12, 4, true));
        cameraList.add(new Camera("philips", 8, 5, false));
        cameraList.add(new Camera("fujitsu", 14, 6, true));

        lensList.add(new Lens(2,3));
        lensList.add(new Lens(4,6));


        //cam1.setLens(lens2);
        //cam2.setLens(lens3);
        //System.out.println(cam1.lens.maxFocalWidth);
        while(input ==1 || input == 2 || input == 3 || input == 4) {
            //TODO: Mini-User-Interface zur Auswahl der Funktionalitäten
            //TODO: [1] Linse erstellen
            //TODO: [2] Kamera erstellen
            //TODO: [3] Linse einer Kamera zuweisen
            //TODO: [4] Kamera + Infos ausgeben (Aufruf toString)
            System.out.println("Wähle:");
            System.out.println("Eingabe = 1 => Erstelle Linse");
            System.out.println("Eingabe = 2 => Erstelle Kamera");
            System.out.println("Eingabe = 3 => Linse einer Kamera zuweisen");
            System.out.println("Eingabe = 4 => Ausgabe einer Kamera");
            input = sc.nextInt();
            if (input == 1){
                createLens(lensList);
            }else if(input ==2){
                createCamera(cameraList);
            }else if(input ==3){
                setLensToCamera(cameraList, lensList);
            }else if(input ==4){

                for (Camera cam: cameraList) {
                    System.out.println(cameraList.indexOf(cam) + ": " + cam);
                }
            }else{
                System.out.println("Fatal Error");
            }





            // ausgabe anzahl camera
            //System.out.println(Camera.countCamera);
        }

    }

    private static void setLensToCamera(List<Camera> cameraList, List<Lens> lensList) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Bei welcher Cam willst du die Linse tauschen?");
        for (Camera cam: cameraList) {
            System.out.println(cameraList.indexOf(cam) + ": " + cam);
        }
        int index = sc.nextInt();
        Camera cam = cameraList.get(index);
        if(cam == null){
            System.out.println("Du hast keine Kamera gewählt!");
        }else{
            System.out.println("Welche Linse willst du einsetzen");
            for (Lens lens: lensList) {
                System.out.println(lensList.indexOf(lens) + ": " + lens);
            }
            int index1 = sc.nextInt();
            Lens lens = lensList.get(index1);
            if(lens == null) {
                System.out.println("Du hast keine Linse gewählt!");
            }else{
                System.out.println("Die Linse wurde der Kamera eingesetzt");
                cam.setLens(lens);
            }
        }

        //TODO: selbiges mit Linse



        //cam.setLens(lens);

    }

    private static void createCamera(List<Camera> cameraList) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Gib brand ein");
        String brand = sc.nextLine();
        System.out.println("Gib pixel ein");
        int pixel = sc.nextInt();
        System.out.println("Gib displaygröße ein");
        int displaySize = sc.nextInt();
        System.out.println("Gib Farbe => true/schwarz-weiß => false ein");
        boolean colored = sc.nextBoolean();
        cameraList.add(new Camera(brand, pixel, displaySize, colored));

    }
    private static void createLens(List<Lens> lensList) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Gib die minimale Brennweite ein");
        int minFocalWidth = sc.nextInt();
        System.out.println("Gib die maximale Brennweite ein");
        int maxFocalWidth = sc.nextInt();
        lensList.add(new Lens(minFocalWidth, maxFocalWidth));

    }
}
