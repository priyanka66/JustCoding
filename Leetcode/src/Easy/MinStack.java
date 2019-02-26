package Easy;

import java.util.Map;
import java.util.Stack;

public class MinStack {
    private Node top;

    private class Node {
        int val;
        int min;
        Node next;

        private Node(int x) {
            val = x;
            min = x;
            next = null;
        }

    }

    private void push(int x) {
        if (top == null) {
            top = new Node(x);
        } else {
            Node temp = new Node(x);
            temp.min = Math.min(top.min, x);
            temp.next = top;
            top = temp;
        }
    }

    private int getMin() {
        if (top == null)  return -1;
        else {
            return top.min;
        }
    }

    private void pop() {
        if (top == null) return;
        else {
            top = top.next;

        }
    }

    private int top() {
        if (top == null) return -1;
        else return top.val;
    }

    Stack<Integer> st;
    int min;

    MinStack() {
        st = new Stack<>();
        min = Integer.MAX_VALUE;
    }

    public void pushV2(int x) {
        if (x<=min) {
            st.push(min);
            min = x;
        }
        st.push(x);
    }

    private void popV2() {
       if (st.pop()  == min) min = st.pop();
    }

    private int topV2() {
        return st.peek();
    }

    private int getMinV2() {
        return min;
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
//        minStack.push(-2);
//        minStack.push(0);
//        minStack.push(-3);
//        System.out.println(minStack.getMin());  // --> Returns -3.
//
//        minStack.pop();
//        System.out.println(minStack.top());     // --> Returns 0.
//        System.out.println(minStack.getMin());   //--> Returns -2.


        minStack.pushV2(2);
        minStack.pushV2(1);
        minStack.pushV2(0);
        minStack.pushV2(3);
        System.out.println(minStack.getMinV2());  // --> Returns -3.

        minStack.popV2();
        System.out.println(minStack.topV2());     // --> Returns 0.
        System.out.println(minStack.getMinV2());
        minStack.popV2();
        System.out.println(minStack.getMinV2());
        minStack.popV2();

    }
}
