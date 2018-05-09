package Ch02.LinkedLists;

/**
 * Return Kth to Last: Implement an algorithm to find the kth to last element of a singly linked list.
 *
 */
public class Q2_ReturnKthToLast {

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.add(8);
        list.add(1);
        list.add(18);
        list.add(25);
        list.add(25);
        list.add(1);

        list.display();
        System.out.println(kthLast(list, 2));
    }


    private static Node kthLast(LinkedList list, int key){
        Node fast = list.head;
        Node slow = list.head;
        for(int i =1; i<key; i++) {
            if(fast.next == null) {
            throw new IndexOutOfBoundsException("Out of bounds");
            }
            fast = fast.next;
        }
        while (fast.next != null){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
