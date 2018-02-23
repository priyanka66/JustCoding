import java.util.Stack;

public class NextGreater {

    static void getNextGreater(int num[]) {
        int nextGreater;
        for (int i=0; i<num.length; i++) {
            nextGreater = -1;
            for (int j=i+1; j<num.length ;j++) {
                if (num[j] > num[i]) {
                    nextGreater = num[j];
                    break;
                }
            }
            System.out.println(num[i] + " ---> " + nextGreater);
        }
    }

    static void getNextGreaterUsingStack(int num[]) {
        Stack<Integer> st = new Stack<>();
        st.push(num[0]);
        int nextGreater, element;
        for (int i=1 ;i < num.length; i++) {
            nextGreater = num[i];
            while ( !st.empty() && num[i] > st.peek()) {
               element =  st.pop();
               System.out.println( element + " ---> " + num[i]);
            }

            if (!st.empty() && st.peek() > nextGreater) st.push(nextGreater);

            st.push(nextGreater);
        }
        while (!st.empty()) {
            System.out.println(st.pop() + "   -- > " + "-1");
        }
    }
    public static void main(String[] args) {
        int number[] = {4,5,2,25};
        //getNextGreater(number);
        getNextGreaterUsingStack(number);
    }
}
