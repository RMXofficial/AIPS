package kol14;

import java.util.Scanner;

class SLLNode {
    String name;
    int price;
    SLLNode succ;

    public SLLNode(String name, int price, SLLNode succ) {
        this.name = name;
        this.price = price;
        this.succ = succ;
    }

    @Override
    public String toString() {
        return name;
    }
}

class SLL {
    SLLNode first;

    public SLL() {
        this.first = null;
    }

    public void insertFirst(String name, int price) {
        SLLNode ins = new SLLNode(name, price, first);
        first = ins;
    }

    public void insertLast(String name, int price) {
        if (first != null) {
            SLLNode tmp = first;
            while (tmp.succ != null)
                tmp = tmp.succ;
            SLLNode ins = new SLLNode(name, price, null);
            tmp.succ = ins;
        } else {
            insertFirst(name, price);
        }
    }

    @Override
    public String toString() {
        StringBuilder ret = new StringBuilder();
        if (first != null) {
            SLLNode tmp = first;
            ret.append(tmp).append("\n");
            while (tmp.succ != null) {
                tmp = tmp.succ;
                ret.append(tmp).append("\n");
            }
        } else
            ret = new StringBuilder("NO ELEMENTS");
        return ret.toString();
    }
    public int delete(SLLNode node) {
        if (first != null) {
            SLLNode tmp = first;
            while (tmp.succ != node && tmp.succ.succ != null)
                tmp = tmp.succ;
            if (tmp.succ == node) {
                tmp.succ = tmp.succ.succ;
                return node.price;
            } else {
                System.out.println("Elementot ne postoi vo listata");
                return 0;
            }
        } else {
            System.out.println("Listata e prazna");
            return 0;
        }
    }
}

public class CakeShop {

    public static void removeCakes(SLL cakes) {
        // TODO: implement method
        SLLNode tmp1=cakes.first;
        int suma=0;
        int brTorti=0;
        double prosek=0;
        while (tmp1!=null){
            suma+=tmp1.price;
            brTorti++;
            tmp1=tmp1.succ;
        }
        prosek=1.00*suma/brTorti;
        tmp1=cakes.first;
        while (tmp1!=null){
            if (prosek< tmp1.price){
                cakes.delete(tmp1);
            }
            tmp1=tmp1.succ;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        SLL cakes = new SLL();

        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine();
            String[] parts = line.split("\\s+");
            cakes.insertLast(parts[0], Integer.parseInt(parts[1]));
        }

        removeCakes(cakes);
        System.out.println(cakes.toString());
    }
}