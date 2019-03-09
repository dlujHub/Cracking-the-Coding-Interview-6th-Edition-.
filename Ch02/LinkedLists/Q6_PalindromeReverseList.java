package Ch02.LinkedLists;

import java.util.Stack;

/**
 * Palindrome: Implement a function to check if a linked list is a palindrome.
 */
public class Q6_PalindromeReverseList {


    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.add(1);list.add(12);list.add(5);list.add(12);list.add(1);

        list.display();
        System.out.println(isPalindrome(list));
    }

    private static boolean isPalindrome(LinkedList list) {
        Stack<Node> stack = new Stack<>();
        Node curr = list.head;
        Node fast = list.head;
        while (fast != null && fast.next != null) {
            stack.add(curr);
            curr = curr.next;
            fast = fast.next.next;
        }
        if (fast != null) {
            curr = curr.next;
        }
        while (curr != null) {
            if (curr.data != stack.pop().data){
                return false;
            }
            curr = curr.next;
        }
        return true;
    }
}
