package Ch02.LinkedLists;

/**
 * Partition: Write code to partition a linked list around a value x, such that all nodes less than x come
 before all nodes greater than or equal to x. lf x is contained within the list, the values of x only need
 to be after the elements less than x (see below). The partition element x can appear anywhere in the
 "right partition"; it does not need to appear between the left and right partitions.
 EXAMPLE
 Input: 3 -> 5 -> 8 -> 5 -> 10 -> 2 -> 1 [partition = 5)
 Output: 3 -> 1 -> 2 -> 10 -> 5 -> 5 -> 8
 Hints: #
 */
public class Q4_Partition {

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.add(1);
        list.add(2);
        list.add(10);
        list.add(5);
        list.add(8);
        list.add(5);
        list.add(3);

        list.display();
        partition(list, 500);
        list.display();
    }

    private static void partition(LinkedList list, int p) {
        LinkedList less = new LinkedList();
        Node tailLess = list.head;
        LinkedList greater = new LinkedList();

        Node curr = list.head;
        while(curr != null) {
            Node temp = curr.next;
            if (curr.data < p) {
                if (less.head == null){
                    tailLess = curr;
                }
                less.addN(curr);

            } else{
                greater.addN(curr);
            }
            curr = temp;
        }

        if (less.head == null){
            list.head = greater.head;
            return;
        }
        tailLess.next = greater.head;
        list.head = less.head;


    }
}
