package Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class ExclusiveTimeofFunctions {

    public int[] exclusiveTime(int n, List<String> logs) {
        int[] time = new int[n];
        Stack<int[]> st = new Stack<>();
        for (int i=0;i<logs.size();i++) {
            String[] cur = logs.get(i).split(":");
            if (cur[1].equals("start")) {
                st.push(new int[]{(Integer.valueOf(cur[0])), Integer.valueOf(cur[2])});
            } else {
                int[] pop = st.pop();
                int runTime = Integer.parseInt(cur[2]) - pop[1] + 1;
                time[pop[0]] += (runTime);
                if (st.size() > 0) {
                    time[st.peek()[0]] -= runTime;
                }
            }

        }

        return time;
    }

    public static void main(String[] args) {
        ExclusiveTimeofFunctions t = new ExclusiveTimeofFunctions();
        int n = 2;
        List<String> logs = new ArrayList<>();
        logs.add("0:start:0");
        logs.add("1:start:2");
        logs.add("1:end:5");
        logs.add("0:end:6");
        System.out.println(Arrays.toString(t.exclusiveTime(n, logs)));
    }
}