package kol1;
import java.util.Scanner;

public class Students {
    public static void removeStudent(SLL<Student> students) {
        SLLNode<Student> tmp1=students.getFirst();
        SLLNode<Student> tmp2=students.getFirst();
        int minPoeni=100;
        while (tmp1!=null){
            if (minPoeni>tmp1.element.getPoints()){
               minPoeni=tmp1.element.getPoints();
               tmp2=tmp1;
            }
            tmp1=tmp1.succ;
        }
        students.delete(tmp2);
    }
    public static void main(String[] args) {
        SLL<Student> studenti = new SLL<>();
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        for(int i=0;i<n;i++)
        {
            int index = input.nextInt();
            String name = input.next();
            int points = input.nextInt();

            Student s1 = new Student(index,name,points);
            studenti.insertLast(s1);
        }
        removeStudent(studenti);
        System.out.println(studenti.toString());
    }
}
class Student
{
    private int index;
    private String name;
    private int points;

    public Student(int index, String name, int points) {
        this.index = index;
        this.name = name;
        this.points = points;
    }

    public int getIndex() {
        return index;
    }

    public String getName() {
        return name;
    }

    public int getPoints() {
        return points;
    }

    @Override
    public String toString() {
        return String.valueOf(name);
    }
}
