package Ch02.LinkedLists;


/**
 * Intersection: Given two (singly) linked lists, determine if the two lists intersect. Return the intersecting
 node. Note that the intersection is defined based on reference, not value. That is, if the kth
 node of the first linked list is the exact same node (by reference) as the jth node of the second
 linked list, then they are intersecting.
 */
public class Q7_Intersection {

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        LinkedList list2 = new LinkedList();

        Node node = new Node(10);
        Node node2 = new Node(11);
        Node node3 = new Node(6);
        list.addN(node);
        list.addN(node2);
        list.addN(node3);
        list2.addN(node);
        list2.addN(node2);
        list2.addN(node3);
        list.add(1);
        list.add(2);
        list2.add(4);

        list.display();
        list2.display();
        System.out.println(intersect(list, list2));

        list = new LinkedList();
        list.add(1);
        list.add(2);
        list2 = new LinkedList();
        list2.add(2);
        System.out.println(intersect(list, list2));

    }

    private static Node intersect(LinkedList listA, LinkedList listB) {
        if (listB == null || listA == null) {
            return null;
        }
        Node A = listA.head;
        Node B = listB.head;
        boolean nulA =false;
        boolean nulB = false;

        while (A != B){

            if (A.next == null) {
                if (nulA){
                    //doesn't has an intersection node
                    return null;
                } else{
                    nulA = true;
                }
                A = listB.head;
            } else {
                A = A.next;
            }

            if (B.next == null) {
                if (nulB){
                    //doesn't has an intersection node
                    return null;
                } else{
                    nulB = true;
                }
                B = listA.head;
            } else {
                B = B.next;
            }
        }
       return A;
    }

}
