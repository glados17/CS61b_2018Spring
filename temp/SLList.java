public class SLList {
    private class IntNode {
        public int item;
        public IntNode next;
    public IntNode(int item, IntNode next) {
        this.item = item;
        this.next = next;
    }
    }
    
    private IntNode first;
    
    public void addFirst(int x) {
    first = new IntNode(x, first);
    }

    public void insert(int item, int position) {
        IntNode current_node = first;
        if (position == 0 || first == null) {
            addFirst(item);
            return;
        }
        while (position > 1 && currentNode.next != null) {
        position--;
        currentNode = currentNode.next;
        }
        IntNode newNode = new IntNode(item, currentNode.next);
        currentNode.next = newNode;
    }
    // Add another method to the SLList class that reverses the elements. Do this using
    // the existing IntNodes (you should not use new).
    // public void reverse() {
    //     IntNode frontOfReversed = null;
    //     IntNode nextNodeToAdd = first;
    //     while (nextNodeToAdd != null) {
    //         IntNode remainderOfOriginal = nextNodeToAdd.next;
    //         nextNodeToAdd.next = frontOfReversed;
    //         frontOfReversed = nextNodeToAdd;
    //         nextNodeToAdd = remainderOfOriginal;
    //     }
    //     first = frontOfReversed;
    // }
    

public void reverse() {
        first = reverseRecursiveHelper(first);
        }
        private IntNode reverseRecursiveHelper(IntNode front) {
            if (front == null || front.next == null) {
            return front;
            } else {
            IntNode reversed = reverseRecursiveHelper(front.next);
            front.next.next = front;
            front.next = null;
            return reversed;
            }
        }

public static void reverse(int[] arr) {
    if (arr == null)
}


    public static void main(String[] args) {
    }
}
    