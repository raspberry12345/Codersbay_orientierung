package Woche17;



import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args)  {
        try{
            view view1 = new view();
            view1.start();
        }catch (IOException e){
            e.getMessage();
        }

    }
}
