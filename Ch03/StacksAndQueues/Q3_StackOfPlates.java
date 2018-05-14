package Ch03.StacksAndQueues;

import java.util.ArrayList;
import java.util.EmptyStackException;

/**
 * Stack of Plates: Imagine a (literal) stack of plates. If the stack gets too high, it might topple.
 Therefore, in real life, we would likely start a new stack when the previous stack exceeds some
 threshold. Implement a data structure SetOfStacks that mimics this. SetOfStacks should be
 composed of several stacks and should create a new stack once the previous one exceeds capacity.
 SetOfStacks. push () and SetOfStacks. pop () should behave identically to a single stack
 (that is, pop ( ) should return the same values as it would if there were just a single stack).
 FOLLOW UP
 Implement a function popAt (int index) which performs a pop operation on a specific sub-stack.

 */
public class Q3_StackOfPlates {


    public static void main(String[] args){
        StackOfPlates stackOfPlates = new StackOfPlates();
        stackOfPlates.push(6);stackOfPlates.push(5);stackOfPlates.push(4);
        System.out.println(stackOfPlates.toString());
        stackOfPlates.push(3);stackOfPlates.push(2);stackOfPlates.push(1);
        System.out.println(stackOfPlates.toString());
        stackOfPlates.push(0);
        System.out.println(stackOfPlates.toString());
        System.out.println(" pop " + stackOfPlates.pop() + " and " + stackOfPlates.pop());
        System.out.println(stackOfPlates.toString());
        System.out.println(" pop idx 0 - " + stackOfPlates.popAt(0) + " and idx 1 - " + stackOfPlates.popAt(1));
        System.out.println(stackOfPlates.toString());
        System.out.println(" pop idx 0 2 times " + stackOfPlates.popAt(0) + " " + stackOfPlates.popAt(0));
        System.out.println(stackOfPlates.toString());
    }

}

class StackOfPlates {
    private final int THRESHOLD = 3;
    private ArrayList<Stack> listOfStacks = new ArrayList<>();

    public void push(int item){
        Stack stack;
        if (listOfStacks.isEmpty()) {
           stack = new Stack();
           listOfStacks.add(stack);
        } else {
           stack = listOfStacks.get(listOfStacks.size()-1);
        }
        if (stack.getSize() >= THRESHOLD) {
            stack = new Stack();
            listOfStacks.add(stack);
        }
        stack.push(item);
    }

    public int pop(){
        if (listOfStacks.isEmpty()) {
            throw new EmptyStackException();
        }
        Stack stack = listOfStacks.get(listOfStacks.size()-1);
        int item = stack.pop();
        if (stack.isEmpty()) {
            listOfStacks.remove(listOfStacks.size()-1);
        }
        return item;
    }

    public int popAt(int idx) {
        if (listOfStacks.isEmpty()) {
            throw new EmptyStackException();
        }
        if (idx < 0 || idx > listOfStacks.size() - 1){
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        Stack stack = listOfStacks.get(idx);
        int item = stack.pop();
        if (stack.isEmpty()) {
            listOfStacks.remove(idx);
        }
        return item;

    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("List of stacks (size ").append(listOfStacks.size()).append("):\n");
        for (Stack stack: listOfStacks) {
            sb.append(stack).append("\n");
        }
        return sb.toString();
    }
}

class Stack {
    private Node top;
    private int size;

    public int getSize() {
        return size;
    }

    class Node{
        private int data;
        private Node next;

        private Node(int data){
            this.data = data;
        }
    }

    public void push(int item) {
        Node node = new Node(item);
        node.next = top;
        top = node;
        size++;
    }

    public int pop() {
        if (top == null) {
            throw new EmptyStackException();
        }
        int item = top.data;
        top = top.next;
        size--;
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node curr = top;
        while (curr != null) {
            sb.append(curr.data).append(" ");
            curr = curr.next;
        }
        return sb.toString();
    }
}
