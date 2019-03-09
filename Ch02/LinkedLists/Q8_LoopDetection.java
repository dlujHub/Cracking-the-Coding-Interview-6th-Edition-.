package Ch02.LinkedLists;

/**
 * Loop Detection: Given a circular linked list, implement an algorithm that returns the node at the
 beginning of the loop.
 DEFINITION
 Circular linked list: A (corrupt) linked list in which a node's next pointer points to an earlier node, so
 as to make a loop in the linked list.
 EXAMPLE
 Input: A -) B -) C -) 0 -) E - ) C[the same C as earlier]
 Output: C
 */
public class Q8_LoopDetection {

    public static void main(String[] args) {
        LinkedList list = new LinkedList(); Node node = new Node(5);
        list.add(1);list.add(12);list.addN(node);list.add(12);list.add(21);list.addN(node);list.add(3);list.add(4);

        System.out.println(loopBeginAt(list));
    }

    private static Node loopBeginAt(LinkedList list) {
        Node slow = list.head;
        Node fast = slow;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            System.out.println(slow + " " + fast);
            if (slow == fast){
               break;
            }
        }

        if (fast == null || fast.next == null) {
            return null;
        }

        fast = list.head;
        while (fast != slow){
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }
}
