package lab1;

import java.util.Scanner;

public class ReverseWord {
    public static String Reverse(String word){
        StringBuilder reversed=new StringBuilder();
        for (int i = word.length()-1; i >= 0; i--) {
            reversed.append(word.charAt(i));
        }
        return reversed.toString();
    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        String word=null;
        for (int i = 0; i < n; i++) {
            word=scanner.next();
            Reverse(word);
            System.out.println(Reverse(word));
        }
    }
}
