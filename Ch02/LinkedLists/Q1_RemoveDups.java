package Ch02.LinkedLists;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;

/**
 * Remove Dups: Write code to remove duplicates from an unsorted linked list.
 *
 */
public class Q1_RemoveDups {


    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.add(8);list.add(8);list.add(8);
        list.add(8);
        list.add(1);
        list.add(18);
        list.add(25);
        list.add(25);
        list.add(1);
        list.add(1);
        list.add(1); list.add(1);

        list.display();
        removeDubs(list);
        list.display();
    }

    private static void removeDubs(LinkedList list){

        HashSet<Integer> set = new HashSet<>();
        Node curr = list.head;
        Node prev = list.head;
        while (curr != null) {
            if (!set.contains(curr.data)) {
                set.add(curr.data);
                prev = curr;
            } else{
               prev.next = curr.next;
            }
            curr = curr.next;
        }

    }
}

class LinkedList {
   Node head;

    LinkedList(){
        this.head = null;
    }

    public void add(int key) {
        Node node = new Node(key);
       addN(node);
    }

    public void addN(Node node) {
        node.next = head;
        head = node;
    }

    public void display() {
        Node curr = head;
        while (curr!=null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
        System.out.println();
    }

}

class Node {

    int data;
    Node next;

    Node(int key) {
        this.data = key;
        this.next = null;
    }

    @Override
    public String toString() {
        return Integer.toString(data);
    }

}