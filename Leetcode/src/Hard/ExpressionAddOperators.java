package Hard;

import java.util.ArrayList;
import java.util.List;

public class ExpressionAddOperators {

    List<String> result = new ArrayList<>();

    public List<String> addOperators(String num, int target) {
        for (int i=1;i<=num.length();i++) {
            if (i>=2 && num.charAt(0) == '0') continue;
            dfs(num.substring(i), num.substring(0,i), target, 0, Long.parseLong(num.substring(0,i)), true);
        }

        return result;
    }

    public void dfs(String s, String trace, int target, long prev, long current, boolean sign) {
        long sum = sign ? prev+current : prev-current;
        if (s.length() == 0) {
            if (sum == (long) target) result.add(trace);
            return;
        }
        for (int i=1;i<=s.length();i++) {
            if (i>=2 && s.charAt(0) == '0') continue;
            int val = Integer.parseInt(s.substring(0,i));
            dfs(s.substring(i), trace+"+"+val, target, sum, val, true);
            dfs(s.substring(i), trace+"-"+val, target, sum, val, false);
            dfs(s.substring(i), trace+"*"+val, target, prev, current*val, sign);

        }
    }

    public static void main(String[] args) {
        ExpressionAddOperators e = new ExpressionAddOperators();
        String num = "123";
        int target = 6;
        System.out.println(e.addOperators(num, target));
    }
}
