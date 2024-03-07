package kol1;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class MainClass
{
    public static void deleteDuplicates(SLL<Integer> lista,int key)
    {
        SLLNode<Integer> tmp1=lista.getFirst();
        SLLNode<Integer> tmp2=lista.getFirst();
        while (tmp1 !=null){
            if (tmp1.element==key){
                tmp2=tmp1;
            }
            tmp1=tmp1.succ;
        }
        lista.delete(tmp2);
    }
    public static void main(String[] args)
    {
        SLL<Integer> lista = new SLL<>();
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        for(int i=0;i<n;i++)
        {
            lista.insertLast(input.nextInt());
        }
        int key = input.nextInt();
        deleteDuplicates(lista,key);
        System.out.println(lista);


    }
}
