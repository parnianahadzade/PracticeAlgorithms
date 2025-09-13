package com.personal;

import java.util.ArrayDeque;
import java.util.Queue;

//Queue<Integer> q = new ArrayDeque<>(); // or LinkedList
//
//q.offer(1);     // [1]
//q.offer(2);     // [1, 2]   (1 is at front)
//int a = q.peek();  // 1, queue still [1, 2]
//int b = q.poll();  // removes 1, queue now [2]
//boolean e = q.isEmpty(); // false

public class ImplementStackUsingQueues {

    public static void main(String[] args) {
        ImplementStackUsingQueues obj = new ImplementStackUsingQueues();
        obj.push(1);
        obj.push(2);

        System.out.println("top = " + obj.top());
        System.out.println("pop = " + obj.pop());
        System.out.println(obj.empty());
    }

    private final Queue<Integer> q1;
    private final Queue<Integer> q2;

    public ImplementStackUsingQueues() {
        q1 = new ArrayDeque<>();
        q2 = new ArrayDeque<>();
    }

    public void push(int x) {
        q1.offer(x);
    }

    public int pop() {
        //removing everything till 2
        int n = q1.size();
        for (int i=0 ; i < n-1; i++){
            q2.offer(q1.poll());
        }

        int ans = q1.poll();

        while (!q2.isEmpty()){
            q1.offer(q2.poll());
        }

        return ans;
    }

    public int top() {
        //removing everything till 2
        int n = q1.size();
        for (int i=0 ; i < n-1; i++){
            q2.offer(q1.poll());
        }

        int ans = q1.poll();
        q2.offer(ans);

        while (!q2.isEmpty()){
            q1.offer(q2.poll());
        }

        return ans;
    }

    public boolean empty() {
        return q1.isEmpty() && q2.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
