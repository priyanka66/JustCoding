package Easy;

import java.util.Stack;

public class QueueUsingStack {

    Stack<Integer> st1;
    Stack<Integer> st2;

    QueueUsingStack() {
        st1 = new Stack<>();
        st2 = new Stack<>();
    }

    public void push(int x) {
        st1.push(x);
    }

    public int pop() {
        if (!st2.isEmpty()) {
            return st2.pop();
        } if (st2.isEmpty()) {
            if (!st1.isEmpty()) {
                while (!st1.isEmpty()) {
                    st2.push(st1.pop());
                }
                return st2.pop();
            } else {
                empty();
            }
        }

        return -1;
    }

    public int peek() {
        if (!st2.isEmpty()) {
            return st2.peek();
        } else {
            if (!st1.isEmpty()) {
                while (!st1.isEmpty()) {
                    st2.push(st1.pop());
                }

                return st2.peek();
            }
        }

        return -1;
    }

    public boolean empty() {
        if (!st2.isEmpty()) return false;
        else {
            if (st1.isEmpty()) return true;
            else {
                while (!st1.isEmpty()) {
                    st2.push(st1.pop());
                }
                return false;
            }
        }
    }

    public static void main(String[] args) {
        QueueUsingStack queue = new QueueUsingStack();
        queue.push(1);
        queue.push(2);
        System.out.println(queue.peek());  // returns 1
        System.out.println(queue.pop());   // returns 1
        System.out.println(queue.empty()); // returns false

    }
}
