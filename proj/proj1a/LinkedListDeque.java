/** Deque (usually pronounced like “deck”) is an irregular acronym of double-ended queue. Double-ended
 * queues are sequence containers with dynamic sizes that can be expanded or contracted on both ends
 * (either its front or its back).
 * @author Fei Guo
 */

public class LinkedListDeque<LochNess> {

    /**StuffNode is the nakedness linked-list within.*/
    private class StuffNode {
        public LochNess item;
        public StuffNode rest;
        public StuffNode prev;

        public StuffNode(LochNess i, StuffNode n , StuffNode m) {
            item = i;
            rest = n;
            prev = m;
        }
    }


/** a way without sentinel*/
    private StuffNode first;
    private StuffNode last;
    private int size;

    public LinkedListDeque(LochNess x){
        first = new StuffNode(x, null, null);
        size = 1;
        last = first;
    }

    public LinkedListDeque(){
        first = null;
        size = 0;
        last = first;
    }


    public void addFirst(LochNess item){
        if (first == null){
            first = new StuffNode(item, null, null);
            size = 1;
            last = first;
        }
        else {
//            first.prev = first;
            first = new StuffNode(item, first, null);
            first.rest.prev = first;
            size++;
        }
    }

    public void addLast(LochNess item){
        if (first == null){
            first = new StuffNode(item, null, null);
            size = 1;
            last = first;
        }
        else {
            last.rest = new StuffNode(item, null, last);
            last = last.rest;
            size++;
        }
    }

    public boolean isEmpty(){
        if (size == 0){
            return true;
        }
        return false;
    }

    public int size(){
        return size;
    }

    public void printDeque(){
        StuffNode p = first;
        String res = "";
        while (p != null){
            res += p.item + " ";
            System.out.print(p.item);
            p = p.rest;
            if (p != null){
                System.out.print(' ');
            }
        }
//        System.out.println(res);
    }

    /**the remove parts are ugly because I didn't use sentinel for them */
    public LochNess removeFirst(){
        if(first != null && first.rest != null){
            LochNess res = first.item;
            first = first.rest;
            first.prev = null;
            size--;
            return res;
        }
        else if(first.rest == null){
            size--;
            return null;
        }return null;
    }

    public LochNess removeLast(){
        if (last != null && last.prev != null){
            LochNess res = last.item;
            last = last.prev;
            last.rest = null;
            size--;
        }
        else if (last.prev == null){
            size--;
            return null;
        }return null;
    }

    public LochNess get(int index){
        if (size == 0){
            return null;
        }
        StuffNode p = first;
        for (int i = 0; i < index; i++){
            if (p.rest == null){
                return null;
            }
            p = p.rest;
        }
        return p.item;
    }

    /** the LinkedListDeque is with little methord to recursive, but the StuffNode dose.*/
    public LochNess getRecursiveHelper(int index, StuffNode p){
        if (p == null){
            return null;
        }
        else if (index == 0) {
            return p.item;
        } return getRecursiveHelper(index - 1, p.rest);


    }

    public LochNess getRecursive(int index){
        if (size == 0){
            return null;
        }
        return getRecursiveHelper(index, first);
    }

    /**It seems have to be a static, I don't know why, and I don't know haw to make it generic type
     * whatever, it is just for test, and I will find them out later */
    public static LinkedListDeque of(Integer... args){
        LinkedListDeque result, p;
        if (args.length > 0) {
            result = new LinkedListDeque(args[0]);
        } else {
            result = new LinkedListDeque();
            return null;
        }
        int k;
        for (k = 1; k < args.length; k += 1) {
            result.addLast(args[k]);
        }
        return result;
    }

}
