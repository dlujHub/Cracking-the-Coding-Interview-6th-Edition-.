package Ch02.LinkedLists;

import java.util.ArrayList;

/**
 * Palindrome: Implement a function to check if a linked list is a palindrome.
 */
public class Q6_PalindromeArray {


    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.add(1);list.add(12);list.add(2);

        list.display();
        System.out.println(isPalindrome(list));
    }

    private static boolean isPalindrome(LinkedList list) {
        ArrayList<Node> arr = new ArrayList<>();
        Node curr = list.head;
        while (curr != null) {
            arr.add(curr);
            curr = curr.next;
        }

        for (int i =0, j=arr.size()-1; i<arr.size()/2; i++, j--){
            if (arr.get(i).data != arr.get(j).data){
                return false;
            }
        }
        return true;
    }
}
