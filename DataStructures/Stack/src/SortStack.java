import java.util.Stack;

public class SortStack {


    static void insertSort(Stack<Integer> st, int a) {
        if (st.empty() || a > st.peek()) {
            st.push(a);
            return;
        }
        int x =  st.peek();
        st.pop();
        insertSort(st, a);
        st.push(x);
    }
    static void sortStack(Stack<Integer> st) {
        if(!st.empty()) {
            int a = st.peek();
            st.pop();
            sortStack(st);

            insertSort(st, a);
        }
    }
    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        st.push(4);
        st.push(2);
        st.push(1);
        st.push(3);
        System.out.println("Initial Stack" );
        System.out.println(st);
        sortStack(st);
        System.out.println("Sorted Stack" );
        System.out.println(st );

    }
}
