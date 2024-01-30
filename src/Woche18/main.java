package Woche18;
import javax.naming.InvalidNameException;
import Woche16.Personmanage;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class main {
    public static void main(String[] args) {
        Personmanage personmanage1 = new Personmanage();
        try{
            personmanage1.checkInput();
        }catch (InvalidNameException e){
            System.out.println(e.getMessage());

        }

    }
}
