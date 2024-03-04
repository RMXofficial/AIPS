package aud1;
class SLLNode<E> {
    protected E element;
    protected SLLNode<E> succ;

    public SLLNode(E elem, SLLNode<E> succ) {
        this.element = elem;
        this.succ = succ;
    }
}


class SLL<E> {
    private SLLNode<E> first;

    public SLL() {
        // Construct an empty SLL
        this.first = null;
    }

    public void deleteList() {
        first = null;
    }

    public int size() {
        int listSize = 0;
        SLLNode<E> tmp = first;
        while(tmp != null) {
            listSize++;
            tmp = tmp.succ;
        }
        return listSize;
    }

    @Override
    public String toString() {
        String ret = new String();
        if (first != null) {
            SLLNode<E> tmp = first;
            ret += tmp.element;
            while (tmp.succ != null) {
                tmp = tmp.succ;
                ret += "->" + tmp.element;
            }
        } else
            ret = "Prazna lista!!!";
        return ret;
    }

    public void insertFirst(E o) {
        SLLNode<E> ins = new SLLNode<E>(o, null);
        ins.succ = first;
        //SLLNode<E> ins = new SLLNode<E>(o, first);
        first = ins;
    }

    public void insertAfter(E o, SLLNode<E> node) {
        if (node != null) {
            SLLNode<E> ins = new SLLNode<E>(o, node.succ);
            node.succ = ins;
        } else {
            System.out.println("Dadenot jazol e null");
        }
    }
    public void insertBefore(E o, SLLNode<E> before) {

        if (first != null) {
            SLLNode<E> tmp = first;
            if(first==before){
                this.insertFirst(o);
                return;
            }
            //ako first!=before
            while (tmp.succ != before && tmp.succ!=null)
                tmp = tmp.succ;
            if (tmp.succ == before) {
                tmp.succ = new SLLNode<E>(o, before);;
            } else {
                System.out.println("Elementot ne postoi vo listata");
            }
        } else {
            System.out.println("Listata e prazna");
        }
    }

    public void insertLast(E o) {
        if (first != null) {
            SLLNode<E> tmp = first;
            while (tmp.succ != null)
                tmp = tmp.succ;
            tmp.succ = new SLLNode<E>(o, null);
        } else {
            insertFirst(o);
        }
    }

    public E deleteFirst() {
        if (first != null) {
            SLLNode<E> tmp = first;
            first = first.succ;
            return tmp.element;
        } else {
            System.out.println("Listata e prazna");
            return null;
        }
    }

    public E delete(SLLNode<E> node) {
        if (first != null) {
            SLLNode<E> tmp = first;
            if(first == node) {
                return this.deleteFirst();
            }
            while (tmp.succ != node && tmp.succ.succ != null)
                tmp = tmp.succ;
            if (tmp.succ == node) {
                tmp.succ = tmp.succ.succ;
                return node.element;
            } else {
                System.out.println("Elementot ne postoi vo listata");
                return null;
            }
        } else {
            System.out.println("Listata e prazna");
            return null;
        }

    }

    public SLLNode<E> getFirst() {
        return first;
    }

    public SLLNode<E> find(E o) {
        if (first != null) {
            SLLNode<E> tmp = first;
            while (!tmp.element.equals(o) && tmp.succ != null)
                tmp = tmp.succ;
            if (tmp.element.equals(o)) {
                return tmp;
            } else {
                System.out.println("Elementot ne postoi vo listata");
            }
        } else {
            System.out.println("Listata e prazna");
        }
        return null;
    }

    public void merge (SLL<E> in){
        if (first != null) {
            SLLNode<E> tmp = first;
            while(tmp.succ != null)
                tmp = tmp.succ;
            tmp.succ = in.getFirst();
        }
        else{
            first = in.getFirst();
        }
    }

    public void mirror() {
        if (first != null) {
            //m=nextsucc, p=tmp,q=next
            SLLNode<E> tmp = first;
            SLLNode<E> newsucc = null;
            SLLNode<E> next;

            while(tmp != null){
                next = tmp.succ;
                tmp.succ = newsucc;
                newsucc = tmp;
                tmp = next;
            }
            first = newsucc;
        }
    }
}
class Polinom implements Comparable<Polinom>{
    int koeficient;
    int stepen;

    public Polinom(int koeficient, int stepen) {
        this.koeficient = koeficient;
        this.stepen = stepen;
    }

    public int getKoeficient() {
        return koeficient;
    }

    public void setKoeficient(int koeficient) {
        this.koeficient = koeficient;
    }

    public int getStepen() {
        return stepen;
    }

    public void setStepen(int stepen) {
        this.stepen = stepen;
    }
    public Polinom soberi(Polinom p){
        Polinom nov=new Polinom(this.koeficient+p.koeficient,stepen);
        return nov;
    }

    @Override
    public int compareTo(Polinom p) {
        if (this.stepen>p.stepen)
        return 1;
        if(this.stepen<p.stepen)
            return -1;
        return 0;
    }
}
class PolinomList{
    SLL<Polinom> lista=new SLL<>();

    public PolinomList(SLL<Polinom> lista) {
        this.lista = lista;
    }
    public PolinomList soberi(PolinomList p){
        SLLNode<Polinom> tmp1=this.lista.getFirst();
        SLLNode<Polinom> tmp2=p.lista.getFirst();
        SLL<Polinom> finalna=new SLL<Polinom>();
        while (tmp1 != null && tmp2 != null){
            if (tmp1.element.compareTo(tmp2.element) > 0){
                finalna.insertLast(tmp1.element);
                tmp1=tmp1.succ;
            }
            if (tmp1.element.compareTo(tmp2.element) < 0){
                finalna.insertLast(tmp2.element);
                tmp2=tmp2.succ;
            }
            if (tmp1.element.compareTo(tmp2.element) == 0){
                Polinom nov=tmp1.element.soberi(tmp2.element);
                finalna.insertLast(nov);
                tmp1=tmp1.succ;
                tmp2=tmp2.succ;
            }
        }
        while (tmp1 != null){
            finalna.insertLast(tmp1.element);
            tmp1=tmp1.succ;
        }
        while (tmp2 != null){
            finalna.insertLast(tmp2.element);
            tmp2=tmp2.succ;
        }
        PolinomList krajna=new PolinomList(finalna);
        return krajna;
    }
}
public class DvaPolinoma {
    public static void main(String[] args) {
        SLL<Polinom>lista1=new SLL<>();
        SLL<Polinom>lista2=new SLL<>();
        for (int i = 3; i >= 0; i--) {
            lista1.insertLast(new Polinom(i,i));
            lista2.insertLast(new Polinom(i,i));
        }
        PolinomList p1=new PolinomList(lista1);
        PolinomList p2=new PolinomList(lista2);
        PolinomList finalen=p1.soberi(p2);
        SLLNode<Polinom> tmp= finalen.lista.getFirst();
        while (tmp!=null){
            System.out.print(tmp.element.koeficient + "x^"+tmp.element.stepen+"--->");
            tmp=tmp.succ;
        }
    }
}
