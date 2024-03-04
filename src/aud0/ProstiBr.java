package aud0;

import java.util.Scanner;

public class ProstiBr {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int start=scanner.nextInt();
        int kraj=scanner.nextInt();
        int suma=0;
        for (int i = start; i < kraj; i++) {
            if (((i%2!=0)&&(i%3!=0)&&(i%5!=0)&&(i%7!=0))||((i==2)||(i==3)||(i==5)||(i==7))){
                System.out.print(i+" ");
                suma+=i;
            }
        }
        System.out.println();
        System.out.println(suma);
    }
}
