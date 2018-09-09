import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class MinStack {
    List<Integer>st = new ArrayList<Integer>();

    public void push(int x) {
        st.add(x);
    }
    public void pop() {
        if (st.size() == 0) return;
        st.remove(st.size() -1);
    }

    public int top() {
        if (st.size() == 0) return -1;
        return st.get(st.size()-1);
    }

    public int getMin() {
        if (st.size()== 0) return  -1;
        return st.get(st.indexOf(Collections.min(st)));
    }

    public static void main(String[] args) {
        MinStack st = new MinStack();
        st.push(1);
        st.push(4);
        st.push(3);
        st.push(10);
        System.out.println(st.top());
        st.pop();
        System.out.println(st.top());
        System.out.println(st.getMin());

    }
}
