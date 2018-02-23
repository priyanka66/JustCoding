import java.util.Stack;

public class ReverseStack {
    static  Stack<Integer> st = new Stack<>();

    static void insertIntoStack(int x) {
        if (st.empty()) {
            st.push(x);
        } else {
            int a = st.peek();
            st.pop();
            insertIntoStack(x);
            st.push(a);
        }
    }
    static void reverse(){
        if(st.size() > 0) {
            int x = st.peek();
            st.pop();
            reverse();
            insertIntoStack(x);
        }
    }
    public static void main(String[] args) {
        st.push(1);
        st.push(2);
        st.push(3);
        st.push(4);
        System.out.println("Initial stack elements");
        System.out.println(st);
        reverse();
        System.out.println("Final stack elements");
        System.out.println(st);

    }
}
