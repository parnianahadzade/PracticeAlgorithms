package com.personal;

import java.util.Stack;

//ImplementQueueUsingStacks
public class ImplementQueueUsingStacks {

    public static void main(String[] args) {
        ImplementQueueUsingStacks myQueue = new ImplementQueueUsingStacks();
        myQueue.push(1);
        myQueue.push(2);

        System.out.println(myQueue.peek());
        System.out.println(myQueue.pop());
        System.out.println(myQueue.empty());

    }

    private final Stack<Integer> inStack;
    private final Stack<Integer> outStack;

    public ImplementQueueUsingStacks() {
        inStack = new Stack<>();
        outStack = new Stack<>();
    }

    public void push(int x) {
        inStack.push(x);
    }

    public int pop() {
        if (outStack.isEmpty()){
            while (!inStack.isEmpty()){
                outStack.push(inStack.pop());
            }
        }
        return outStack.pop();
    }

    public int peek() {
        if (outStack.isEmpty()){
            while (!inStack.isEmpty()){
                outStack.push(inStack.pop());
            }
        }
        return outStack.peek();
    }

    public boolean empty() {
        return inStack.isEmpty() && outStack.isEmpty();
    }

    /**
     * Your MyQueue object will be instantiated and called as such:
     * MyQueue obj = new MyQueue();
     * obj.push(x);
     * int param_2 = obj.pop();
     * int param_3 = obj.peek();
     * boolean param_4 = obj.empty();
     */
}
