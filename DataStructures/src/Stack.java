import java.util.Queue;
import java.util.LinkedList;
// Implement stack using a queue
public class Stack {
    Queue<Integer> q = new LinkedList<>();
    void push (int val) {
        int size = q.size();
        q.add(val);
        for (int i=0; i< size ; i++) {
            int x = q.remove();
            q.add(x);
        }
    }

    int pop() {
        if (q.isEmpty()) {
            System.out.println("No elements");
            return -1;
        }
         int x = q.remove();
        return x;
    }

    public static void main(String[] args) {
        Stack s = new Stack();
        s.push(2);
        s.push(3);
        s.push(4);
        System.out.println(s.pop());
    }
}
