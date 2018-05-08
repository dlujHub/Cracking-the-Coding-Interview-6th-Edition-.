package Ch02.LinkedLists;


/**
 * Remove Dups: Write code to remove duplicates from an unsorted linked list.
 *How would you solve this problem if a temporary buffer is not allowed?

 */
public class Q1_RemoveDupsNoBuffer {


    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.add(8);
        list.add(8);list.add(8);
        list.add(8);
        list.add(1);
        list.add(18);
        list.add(25);
        list.add(25);
        list.add(1);
        list.add(1);
        list.add(1); list.add(1);

        list.display();
        removeDubsNoBuffer(list);
        list.display();
    }

    private static void removeDubsNoBuffer(LinkedList list){

        Node curr = list.head;
        Node fast;
        while (curr != null) {
            fast = curr;

            while (fast.next != null){
                if (fast.next.data == curr.data){
                    fast.next = fast.next.next;
                } else {
                    fast = fast.next;
                }

            }
            curr = curr.next;
        }

    }
}

