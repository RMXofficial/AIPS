package kol1;
import java.util.Scanner;

class Athlete {
    private int id;
    private double time;

    public Athlete(int id, double time) {
        this.id = id;
        this.time = time;
    }

    public int getId()
    {
        return id;
    }

    public double getTime() {
        return time;
    }

    @Override
    public String toString() {
        return String.valueOf(id);
    }
}


public class Race {

    //todo: implement function
    public static void competition(SLL<Athlete> prevWin, SLL<Athlete> currWin)
    {
        SLLNode<Athlete> tmp1=prevWin.getFirst();
        SLLNode<Athlete> tmp2=currWin.getFirst();
        double WorstTime=0;
        while (tmp1 !=null){
            if (tmp1.element.getTime()>WorstTime){
                WorstTime= tmp1.element.getTime();
            }
            tmp1=tmp1.succ;
        }
        while (tmp2!=null){
            if (tmp2.element.getTime()>WorstTime){
                currWin.delete(tmp2);
            }
            tmp2=tmp2.succ;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int prevWinnersCount = Integer.parseInt(scanner.nextLine());
        int currYearRunnersCount = Integer.parseInt(scanner.nextLine());
        SLL<Athlete> prevWinners = new SLL<Athlete>();
        SLL<Athlete> currYearRunners = new SLL<Athlete>();

        for (int i = 0; i < prevWinnersCount; i++) {
            String line = scanner.nextLine();
            String[] parts = line.split("\\s+");
            prevWinners.insertLast(new Athlete(Integer.parseInt(parts[0]), Double.parseDouble(parts[1])));
        }

        for (int i = 0; i < currYearRunnersCount; i++) {
            String line = scanner.nextLine();
            String[] parts = line.split("\\s+");
            currYearRunners.insertLast(new Athlete(Integer.parseInt(parts[0]), Double.parseDouble(parts[1])));
        }

        competition(prevWinners, currYearRunners);
        System.out.println(currYearRunners.toString());
    }
}