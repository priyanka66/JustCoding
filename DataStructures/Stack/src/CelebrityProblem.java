import java.util.Stack;

public class CelebrityProblem {

    static boolean aKnowsB (int a, int b) {
        int knownMapping[][] = { {0,0,1,0},
                                 {0,1,1,0},
                                 {0,1,0,0},
                                 {0,0,1,0}
        };

        boolean known = (knownMapping[a][b] == 1) ? true : false;

        return known;
    }

    static int findCelebrity(int n) {
        Stack<Integer> st = new Stack<>();
        for (int i=0; i<n ; i++){
            st.push(i);
        }
        while (st.size() >1 ) {
            int a = st.pop();
            int b = st.pop();
            if (aKnowsB(a,b)) {
                st.push(b);
            } else {
                st.push(a);
            }
        }
        int c = st.pop();
        for (int i=0; i<n; i++) {
            if (i != c && (!(aKnowsB(i,c))|| (aKnowsB(c,i))))
                return -1;
        }

        return c;

    }
    public static void main (String[] args) {
        int n = 4;
        int result = findCelebrity(n);
        if (result == -1) {
            System.out.println("No celebrity ");
        } else {
            System.out.println("The celebrity id is  " +  result);
        }
    }
}


