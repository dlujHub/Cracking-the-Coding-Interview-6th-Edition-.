package Ch02.LinkedLists;

import java.util.Stack;

/**
 * Intersection: Given two (singly) linked lists, determine if the two lists intersect. Return the intersecting
 node. Note that the intersection is defined based on reference, not value. That is, if the kth
 node of the first linked list is the exact same node (by reference) as the jth node of the second
 linked list, then they are intersecting.
 */
public class Q7_IntersectionCalcLength {

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

        list = new LinkedList();  Node nodee = new Node(5);
        list.addN(nodee);

        list2 = new LinkedList();
        list2.addN(nodee);list2.add(2);
        System.out.println("second");
        list.display();
        list2.display();
        System.out.println(intersect(list, list2));

    }

    private static Node intersect(LinkedList listA, LinkedList listB) {
        if (listB == null || listA == null) {
            return null;
        }
        Result resultA = lengthAndTail(listA);
        Result resultB = lengthAndTail(listB);

       Node currLong = (resultA.length > resultB.length) ? listA.head : listB.head;
        Node currShort = (resultA.length < resultB.length) ? listA.head : listB.head;

        if (resultA.tail != resultB.tail){
            return null;
        }
        Node kth = findKth(currLong, Math.abs(resultA.length - resultB.length));

        while (currShort != kth){
            currShort = currShort.next;
            kth = kth.next;
        }

        return currShort;
    }

    private static Node findKth(Node currLong, int k) {
        Node curr = currLong;
        for (int i = 0; i<k; i++){
            curr = curr.next;
        }
        return curr;
    }

    private static Result lengthAndTail(LinkedList list){

        int length = 0;
        Node tail = list.head;
        Node curr = tail;
        while (curr != null){
            tail = curr;
            curr = curr.next;
            length++;
        }
        return new Result(tail, length);
    }

   static class Result {
        Node tail;
        int length;

        Result(Node tail, int length){
            this.tail = tail;
            this.length = length;
        }
    }

}
