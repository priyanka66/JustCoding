import java.util.Stack;

public class PostfixEvaluation {
    //2 3 1 * + 9 -

    static int evaluatePostfix(String exp) {
        Stack<Integer> st = new Stack<>();
        int result;
        for(int i=0; i<exp.length();i++) {
            char x = exp.charAt(i);
            if (Character.isDigit(x)) {
                st.push(x - '0');
            } else {
                int b = st.pop();
                int a = st.pop();

                switch (x){
                    case '+' :
                        st.push(a+b);
                        break;
                    case '-' :
                        st.push(a-b);
                        break;
                    case '*' :
                        st.push(a*b);
                        break;
                    case '/' :
                        st.push(a/b);
                        break;
                }

//                result =
            }

        }
        return st.pop();
    }
    public static void main(String[] args) {
        String exp = "231*+9-";
        int result = evaluatePostfix(exp);
        System.out.println("Result = " + result);

    }
}
