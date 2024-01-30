package Woche8;

import java.util.HashSet;
import java.util.Set;

public class MengenLehre {

    public static HashSet unionMethod(HashSet a, HashSet b){
        HashSet <Integer> result= new HashSet<>(a);
        result.addAll(b);

        return result;
    }
    public static HashSet intersectionMethod(HashSet<Integer> a, HashSet<Integer> b){
        HashSet <Integer> result= new HashSet<>(a);
        result.retainAll(b);

        return result;
    }
    public static HashSet relativecomplementMethod(HashSet<Integer> a, HashSet<Integer> b){
        HashSet <Integer> result= new HashSet<>(a);

        result.removeAll(b);

        return result;
    }

    public static void main(String[] args) {
        // ausgangs sets a,b,c
        HashSet <Integer> A = new HashSet<>();
        A.addAll(Set.of(1,3,5));
        HashSet <Integer> B = new HashSet<>();
        B.addAll(Set.of(3,5,7));
        HashSet <Integer> C = new HashSet<>();
        C.addAll(Set.of(5,7,9));

        // speicherung der manipulierten sets
        //vereinigung
        HashSet <Integer> union = unionMethod(A, B);
        unionMethod(union, C);



        //durchschnittsmenge
        HashSet <Integer> intersection = intersectionMethod(A, B);
        intersection = intersectionMethod(intersection, C);

        //differenzenmenge
        HashSet <Integer> difference = relativecomplementMethod(A, B);
        difference = relativecomplementMethod(difference, C);


        System.out.println(difference);







    }
}
