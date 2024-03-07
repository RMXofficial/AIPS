package kol1;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class ExamTerm2 {
    public static void deleteEven(SLL<Integer> list1)
    {
        SLLNode<Integer> tmp1=list1.getFirst();
        SLLNode<Integer> tmp2;
        int counter;
        while (tmp1 !=null){
            counter=0;
            tmp2=list1.getFirst();
            while (tmp2!=null){
                if (tmp1.element==tmp2.element){
                    counter++;
                }
                tmp2=tmp2.succ;
            }
            if (counter%2==0){
                tmp2=list1.getFirst();
                while (tmp2!=null){
                    if (tmp1.element==tmp2.element) {
                        list1.delete(tmp2);
                    }
                    tmp2=tmp2.succ;
                }
            }
            tmp1=tmp1.succ;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        SLL<Integer> list1 = new SLL<Integer>();

        for(int i=0;i<n;i++)
        {
            list1.insertLast(scanner.nextInt());
        }

        deleteEven(list1);
        System.out.println(list1);
    }
}
