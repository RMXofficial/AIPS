package aud0;

import java.util.Scanner;

public class ParniBroevi {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int start = scanner.nextInt();
        int kraj = scanner.nextInt();
        System.out.println("vnesete 1 za neparni i 0 za parni");
        int izbor = scanner.nextInt();
        for (int i = start; i < kraj; i++) {
            if (izbor == 0) {
                if (i % 2 == 0) {
                    System.out.print(i + " ");
                }
            } else{
                if (i%2!=0){
                    System.out.print(i+ " ");
                }
            }
        }
    }
}
