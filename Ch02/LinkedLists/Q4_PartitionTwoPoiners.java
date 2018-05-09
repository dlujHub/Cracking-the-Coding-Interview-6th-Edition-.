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
public class Q4_PartitionTwoPoiners {

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
        partition(list, 5);
        list.display();
    }

    private static void partition(LinkedList list, int p) {
        Node tail = list.head;
        Node head = list.head;
        Node curr = list.head;

        while (curr != null){
            Node next = curr.next;
            if (curr.data < p) {
                curr.next = head;
                head = curr;
            } else {
                curr.next = null;
                tail.next = curr;
                tail = curr;
            }
            curr = next;
        }

        list.head = head;
    }


}
