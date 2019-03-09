package Ch02.LinkedLists;

/**
 * Sum Lists: You have two numbers represented by a linked list, where each node contains a single
 digit. The digits are stored in reverse order, such that the 1 's digit is at the head of the list. Write a
 function that adds the two numbers and returns the sum as a linked list.
 EXAMPLE
 Input: (7-) 1 -) 6) + (5 -) 9 -) 2) .That is,617 + 295.
 Output: 2 -) 1 -) 9. That is, 912.
 FOLLOW UP
 Suppose the digits are stored in forward order. Repeat the above problem.
 EXAMPLE
 Input: (6 -) 1 -) 7) + (2 -) 9 -) 5).That is,617 + 295.
 Output: 9 -) 1 -) 2. That is, 912.
 Hints: #
 */
public class Q5_SumLists {


    private static LinkedList addNumbersForwardOrder(LinkedList list1, LinkedList list2) {
        LinkedList nr1 = new LinkedList();
        LinkedList nr2 = new LinkedList();
        nr1.head = list1.head;
        nr2.head = list2.head;
        LinkedList sum = new LinkedList();
        int len1 = len(nr1);
        int len2 = len(nr2);
        if (len1 > len2){
            addZeros(nr2, len1 - len2);
        } else if (len1 < len2){
            addZeros(nr1, len2 - len1);
        }

        int rem = addUtilRecur(nr1.head, nr2.head, sum);
        if (rem != 0 ){
            sum.add(rem);
        }
        return sum;
    }

    private static void addZeros(LinkedList nr, int zeros) {
        while (zeros --> 0){
            nr.add(0);
        }
    }


    private static int len(LinkedList nr2) {
        Node curr = nr2.head;
        int size = 0;
        while (curr != null){
            size++;
            curr = curr.next;
        }
        return size;
    }


    private static int addUtilRecur(Node curr1, Node curr2, LinkedList sum) {
        if (curr1 == null && curr2 == null) {
            return 0;
        }
        int sumCurr;
        int remainder;

        if (curr1.next == null && curr2.next == null){
            sumCurr = curr1.data + curr2.data;
            remainder = (sumCurr - (sumCurr % 10))/10;
            sum.add(sumCurr % 10);
            return remainder;
        } else if (curr1.next == null){
           curr2 = juptAtEnd(curr2, sum);
        } else if (curr2.next == null){
            curr1 = juptAtEnd(curr1, sum);
        }

        sumCurr = addUtilRecur(curr1.next, curr2.next, sum) + curr1.data + curr2.data;
        remainder = (sumCurr - sumCurr % 10)/10;
        sum.add(sumCurr % 10);

        return remainder;

    }

    private static Node juptAtEnd(Node curr1, LinkedList sum) {
        while (curr1.next != null) {
            curr1 = curr1.next;
        }
        return curr1;
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        LinkedList list2 = new LinkedList();
        list.add(7);list.add(1);list.add(9);
        list2.add(5);list2.add(9);list2.add(2);
        list.display();
        list2.display();
        System.out.println("=======Forward order");
        addNumbersForwardOrder(list, list2).display();
        System.out.println("=======Reverse order");
        addNumbersReverseOrder(list, list2).display();
        System.out.println("=======next=========");
        list = new LinkedList();
        list2 = new LinkedList();
        list.add(1);list.add(9);
        list2.add(4);list2.add(9);
        list.display();
        list2.display();
        System.out.println("=======Forward order");
        addNumbersForwardOrder(list, list2).display();
        System.out.println("=======Reverse order");
        addNumbersReverseOrder(list, list2).display();
        System.out.println("=======next=========");
        System.out.println("== diff length");
        list.add(2);list.add(3);
        list.display();
        list2.display();
        System.out.println("=======Forward order");
        addNumbersForwardOrder(list, list2).display();
        System.out.println("=======Reverse order");
        addNumbersReverseOrder(list, list2).display();

        System.out.println("=======next=========");
        list = new LinkedList();
        list2 = new LinkedList();
        list.add(9); list.add(9);
        list2.add(9);list2.add(9);list2.add(9);
        list.display();
        list2.display();
        System.out.println("=======Forward order");
        addNumbersForwardOrder(list, list2).display();
        System.out.println("=======Reverse order");
        addNumbersReverseOrder(list, list2).display();



    }

    private static LinkedList addNumbersReverseOrder(LinkedList list, LinkedList list2) {
        LinkedList sum = new LinkedList();
        sum.head = reverseUtil(list.head, list2.head, 0);
        return sum;
    }

    private static Node reverseUtil(Node curr1, Node curr2, int carry) {
        if (curr1 == null && curr2 == null && carry == 0){
            return null;
        }
        int value = carry;
        if (curr1 != null) {
            value += curr1.data;
        }
        if (curr2 != null) {
            value += curr2.data;
        }
        Node result = new Node(value % 10);

        if (curr1 != null || curr2 != null){
            result.next = reverseUtil(curr1 == null ? null : curr1.next,
                                    curr2 == null ? null : curr2.next,
                                    value > 9 ? 1 : 0);
        }
        return result;
    }
}
