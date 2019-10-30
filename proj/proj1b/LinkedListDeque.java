/** Deque (usually pronounced like “deck”) is an irregular acronym of double-ended queue. Double-ended
 * queues are sequence containers with dynamic sizes that can be expanded or contracted on both ends
 * (either its front or its back).
 * @author Fei Guo
 */

public class LinkedListDeque<T> implements Deque<T> {

    /**StuffNode is the nakedness linked-list within.*/
    private class StuffNode {
        public T item;
        public StuffNode next;
        public StuffNode prev;

        public StuffNode (T i, StuffNode n , StuffNode m) {
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
    @Override
    public void addFirst(T item){
        sentinel.next = new StuffNode (item, sentinel.next, sentinel);
        sentinel.next.next.prev = sentinel.next;
        size++;
    }

    @Override
    public void addLast(T item){
        sentinel.prev = new StuffNode (item, sentinel, sentinel.prev);
        sentinel.prev.prev.next = sentinel.prev;
        size++;
    }
    @Override
    public boolean isEmpty(){
        return size == 0;
    }

    @Override
    public int size(){
        return size;
    }

    @Override
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

    @Override
    public T removeFirst(){
        T res = sentinel.next.item;
        sentinel.next = sentinel.next.next;
        sentinel.next.prev = sentinel;
        size--;
        return res;
    }

    @Override
    public T removeLast(){
        T res = sentinel.prev.item;
        sentinel.prev = sentinel.prev.prev;
        sentinel.prev.next = sentinel;
        size--;
        return res;
    }

    @Override
    public T get(int index){
        if (index > size - 1){
            return null;
        }
        StuffNode p = sentinel;
        for (int i = 0; i <index; i++, p = p.next){
        }
        return p.next.item;
    }

    /** the LinkedListDeque is with little methord to recursive, but the StuffNode dose.*/
    public T getRecursiveHelper(int index, StuffNode p){
        if (index == 0) {
            return p.next.item;
        } return getRecursiveHelper(index - 1, p.next);
    }

    public T getRecursive(int index){
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
