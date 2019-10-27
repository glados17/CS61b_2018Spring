/** Deque (usually pronounced like “deck”) is an irregular acronym of double-ended queue. Double-ended
 * queues are sequence containers with dynamic sizes that can be expanded or contracted on both ends
 * (either its front or its back).
 * @author Fei Guo
 */

public class LinkedListDeque<LochNess> {

    /**StuffNode is the nakedness linked-list within.*/
    private class StuffNode {
        public LochNess item;
        public StuffNode next;
        public StuffNode prev;

        public StuffNode (LochNess i, StuffNode n , StuffNode m) {
            item = i;
            next = n;
            prev = m;
        }
    }


    /** a way without sentinel*/
    private StuffNode sentinel;
    private StuffNode sentinelBack;
    private int size;

    public LinkedListDeque() {
        sentinel = new StuffNode(null, null, null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
        size = 0;
    }

//    public LinkedListDeque(LochNess x){
//        new LinkedListDeque();
//        addFirst(x);
//    }

    public void addFirst(LochNess item){
        sentinel.next = new StuffNode (item, sentinel.next, sentinel);
        sentinel.next.next.prev = sentinel.next;
        size++;
    }

    public void addLast(LochNess item){
        sentinel.prev = new StuffNode (item, sentinel, sentinel.prev);
        sentinel.prev.prev.next = sentinel.prev;
        size++;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public int size(){
        return size;
    }

    public void printDeque(){
        StuffNode p = sentinel.next;
        while (p.next != sentinel){
            System.out.print(p.item);
            System.out.print(' ');
            p = p.next;
        }
        System.out.println(p.item);
        System.out.print(' ');
    }

    public LochNess removeFirst(){
        LochNess res = sentinel.next.item;
        sentinel.next = sentinel.next.next;
        size--;
        return res;
    }

    public LochNess removeLast(){
        LochNess res = sentinel.prev.item;
        sentinel.prev = sentinel.prev.prev;
        size--;
        return res;
    }

    public LochNess get(int index){
        if (index > size - 1){
            return null;
        }
        StuffNode p = sentinel;
        for (int i = 0; i <index; i++, p = p.next){
        }
        return p.next.item;
    }

    /** the LinkedListDeque is with little methord to recursive, but the StuffNode dose.*/
    public LochNess getRecursiveHelper(int index, StuffNode p){
        if (index == 0) {
            return p.next.item;
        } return getRecursiveHelper(index - 1, p.next);
    }

    public LochNess getRecursive(int index){
        if (size == 0){
            return null;
        }
        return getRecursiveHelper(index, sentinel);
    }

    /**It seems have to be a static, I don't know why, and I don't know haw to make it generic type
     * whatever, it is just for test, and I will find them out later */
    public static LinkedListDeque of(Integer... args){
        LinkedListDeque result = new LinkedListDeque();
        for (int i = 0; i < args.length; i++){
            result.addLast(args[i]);
        }
        return result;
    }
}
