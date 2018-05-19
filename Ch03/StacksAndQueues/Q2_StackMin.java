package Ch03.StacksAndQueues;


import java.util.EmptyStackException;

/**
 * Stack Min: How would you design a stack which, in addition to push and pop, has a function min
 which returns the minimum element? Push, pop and min should all operate in 0(1) time.

 */
public class Q2_StackMin{


    public static void main(String[] args) {
        MyStack stack = new MyStack();
        stack.push(5);
        System.out.println(stack.min());
        stack.push(3);
        System.out.println(stack.min());
        stack.push(12);
        System.out.println(stack.min());
        stack.pop();
        System.out.println(stack.min());
        stack.push(1);
        System.out.println(stack.min());
    }
}


class MyStack {

    private Node top;

    public void push(int item) {
        Node node = new Node(item);
        if (top == null) {
            node.minSoFar = node.data;
        } else{
            if (top.minSoFar > node.data){
                node.minSoFar = node.data;
            } else{
                node.minSoFar = top.minSoFar;
            }
        }
        node.next = top;
        top = node;
    }

    public int min(){
        if (top == null){
            throw new EmptyStackException();
        }
        return top.minSoFar;
    }

    public int pop() {
        if (top == null) {
            throw new EmptyStackException();
        }
        int item = top.data;
        top = top.next;
        return item;
    }

    public int peek() {
        if (top == null){
            throw new EmptyStackException();
        }
        return top.data;
    }

    public boolean isEmpty(){
        return top == null;
    }

    private class Node{
        private int data;
        private int minSoFar;
        private Node next;

        private Node(int data){
            this.data = data;
        }
    }
}