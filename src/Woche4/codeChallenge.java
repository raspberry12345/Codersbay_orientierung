package Woche4;

public class codeChallenge {
    public static void main(String[] args) {
        int[] a = {2,4,6,8,7,3};
        int safe =0;

        for (int i=0; i<(a.length)/2; i++){
            safe = a[i];
            a[i]=a[a.length-1-i];
            a[a.length-1-i]=safe;
        }

        for (int j=0; j<6;j++){
            System.out.println(a[j]);
        }

        int multiplikator = 9;
        int multiplikand = 12;
        int sum=0;

        do {


            if (!(multiplikator%2==0)&&!(multiplikator==0)){
                sum = sum + multiplikand;
            }
            multiplikator = multiplikator/2;
            multiplikand = multiplikand*2;

        }while(!(multiplikator==0));


        System.out.println(sum);

    }
}
