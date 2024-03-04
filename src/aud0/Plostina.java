package aud0;

import java.util.Scanner;

public class Plostina {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("vnesete 1 za krug i 0 za kvadrat");
        int KiliK=scanner.nextInt();
        if (KiliK==1){
            System.out.println("vnesete radius na krug");
            double r=scanner.nextDouble();
            double plostina=r*r*Math.PI;
            double perimetar=r*2*Math.PI;
            System.out.println("perimetarot e: "+perimetar+" so radius "+r);
            System.out.println("plostinata e: "+plostina+" so radius "+r);
        }
        else {
            System.out.println("vnesete strana ");
            double a=scanner.nextDouble();
            double perimetar=a*4;
            double plostina=a*a;
            System.out.println("permetarot e: "+perimetar+" so strana "+a);
            System.out.println("plostina e: "+plostina+" so strana "+a);
        }
    }
}
