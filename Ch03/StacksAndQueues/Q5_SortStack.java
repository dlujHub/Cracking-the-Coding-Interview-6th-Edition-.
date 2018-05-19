package Ch03.StacksAndQueues;

import java.util.Random;
import java.util.Stack;

/**
 * Sort Stack: Write a program to sort a stack such that the smallest items are on the top. You can use
 an additional temporary stack, but you may not copy the elements into any other data structure
 (such as an array). The stack supports the following operations: push, pop, peek, and isEmpty.

 */
public class Q5_SortStack {

    public static void main(String[] args){
        Stack<Integer> stack = new Stack<>();

        stack.push(6);
        stack.push(7);
        stack.push(4);
        stack.push(5);
        stack.push(9);

        System.out.println(stack);
        stack = sort(stack);
        System.out.println(stack);

        //random
        stack = new Stack<>();
        Random rand = new Random();
        for (int i = 0; i<100; i++) {
            int item = rand.nextInt(100);
            stack.push(item);
        }
        System.out.println(stack);
        stack = sort(stack);
        System.out.println(stack);
    }

    public static Stack<Integer> sort(Stack<Integer> stack){
        Stack<Integer> stack2 = new Stack<>();
        while (!stack.isEmpty()){
            int temp = stack.pop();
            if (stack2.isEmpty() || stack2.peek() > temp) {
                stack2.push(temp);
            } else {
                int count = 0;
                while (!stack2.isEmpty() && stack2.peek() < temp){
                    count++;
                    stack.push(stack2.pop());
                   }
                stack2.push(temp);
                while (count-->0){
                    stack2.push(stack.pop());
                }
            }

        }
        return stack2;
    }

}
