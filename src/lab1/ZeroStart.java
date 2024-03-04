package lab1;

import java.util.Scanner;

public class ZeroStart {
    static void PushZero(int arr[],int n){
        int []temp=new int[n];
        int count=0;
        for (int i = 0; i < n; i++) {
            if (arr[i]==0){
                temp[count]=arr[i];
                count++;
            }
        }
        for (int i = 0; i < n; i++) {
            if (arr[i]!=0){
                temp[count]=arr[i];
                count++;
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.print(temp[i]+" ");
        }
    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int []arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i]=scanner.nextInt();
        }
        System.out.println("Transformiranata niza e:");
        PushZero(arr,n);
    }
}
