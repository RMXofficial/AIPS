package Listi;

public class JoinSortedSLL<E extends Comparable<E>> {
    public SLL<E> joinsortedLists(SLL<E> firstList,SLL<E> secondList){
        SLL<E> result=new SLL<>();
        SLLNode<E> tmpfirst=firstList.getFirst();
        SLLNode<E> tmpsecond=secondList.getFirst();
        while (tmpfirst!= null && tmpsecond!= null){
            if (tmpfirst.element.compareTo(tmpsecond.element)>0){
                result.insertLast(tmpfirst.element);
                tmpfirst=tmpfirst.succ;
            }
            if (tmpfirst.element.compareTo(tmpsecond.element)<0){
                result.insertLast(tmpsecond.element);
                tmpsecond=tmpsecond.succ;
            }
            else {
                result.insertLast(tmpfirst.element);
                result.insertLast(tmpsecond.element);
                tmpfirst=tmpfirst.succ;
                tmpsecond=tmpsecond.succ;
            }
            while(tmpfirst !=null){
                result.insertLast(tmpfirst.element);
                tmpfirst=tmpfirst.succ;
            }
            while(tmpsecond !=null){
                result.insertLast(tmpsecond.element);
                tmpsecond=tmpsecond.succ;
            }
            return result;
        }

        return null;
    }
}
