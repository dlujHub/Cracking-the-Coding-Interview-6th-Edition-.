package Ch03.StacksAndQueues;

import java.util.NoSuchElementException;

public class Q4_QueueViaStacks {

    public static void main(String[] args) {
        MyQueue queue = new MyQueue();
        queue.push(1);
        queue.push(2);
        queue.push(3);
        queue.display();
        System.out.println(queue.remove());
        queue.display();
        queue.push(4);
        queue.push(5);
        System.out.println(queue.remove());
        queue.display();
        queue.push(6);
        System.out.println(queue.remove());
        System.out.println(queue.remove());
        System.out.println(queue.remove());
        System.out.println(queue.remove());
        queue.display();
    }
}

class MyQueue {
    private Stack stack1 = new Stack();
    private Stack stack2 = new Stack();

    public void push(int item) {
        stack1.push(item);
    }

    public int remove(){
        if (stack2.isEmpty()){
            while (!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }

        if (stack2.isEmpty()){
            throw new NoSuchElementException();
        }
        return stack2.pop();
    }

    public void display() {
        System.out.println("Stack 1 = " + stack1);
        System.out.println("Stack 2 = " + stack2);
    }
}