package Medium;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {

    private List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<String>();
        int left = n, right = n;
        String paren = new String();
        generate(result,n,n,paren);
        return result;
    }

    public void generate(List<String> result, int left, int right, String paren) {
        if(left > right)
            return;
        if (left>0) generate(result, left-1,right, paren+'(');
        if (right > 0) generate(result, left, right-1, paren+')');
        if (left == 0 && right==0) {
            result.add(paren);
            return;
        }
        else return;
    }
    public static void main(String[] args) {
        GenerateParentheses g = new GenerateParentheses();
        int n = 2;
        System.out.println(g.generateParenthesis(n));
    }
}
