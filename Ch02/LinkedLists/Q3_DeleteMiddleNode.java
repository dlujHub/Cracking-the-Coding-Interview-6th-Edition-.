package Ch02.LinkedLists;

/**
 * Delete Middle Node: Implement an algorithm to delete a node in the middle (i.e., any node but
 the first and last node, not necessarily the exact middle) of a singly linked list, given only access to
 that node.
 EXAMPLE
 Input: the node c from the linked list a - >b- >c - >d - >e- >f
 Result: nothing is returned, but the new linked list looks like a - >b- >d - >e- >f
 */
public class Q3_DeleteMiddleNode {

    private static void deleteInMiddle(Node del) {
        if (del == null || del.next == null) {
            return;
        }
        del.data = del.next.data;
        del.next = del.next.next;
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.add(8);
        list.add(1);
        list.add(18);
        list.add(2);
        list.add(25);
        list.add(1);

        list.display();
        Node curr = list.head;
        for (int i = 0; i<4; i++) {
            curr = curr.next;
        }
        System.out.println("Delete " + curr);

        deleteInMiddle(curr);
        list.display();
    }
}
