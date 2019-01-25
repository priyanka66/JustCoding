package Medium;

import java.util.*;

public class TaskScheduler {

    public int leastInterval(char[] tasks, int n) {
        if (tasks.length == 0) return 0;
        Map<Character, Integer> hmap = new HashMap<>();
        for (char c:tasks) {
            hmap.put(c, hmap.getOrDefault(c, 0)+1);
        }
        PriorityQueue<Map.Entry<Character, Integer>> queue = new PriorityQueue<>(
                (a,b) -> a.getValue() !=  b.getValue() ? b.getValue()-a.getValue() : a.getKey()-b.getKey());
        queue.addAll(hmap.entrySet());
        int count = 0;
        while (!queue.isEmpty()) {
            int k = n+1;
            List<Map.Entry> temp = new ArrayList<>();
            while (!queue.isEmpty() && k >0) {
                Map.Entry<Character, Integer> cur = queue.poll();
                cur.setValue(cur.getValue()-1);
                temp.add(cur);
                k--;
                count++;
            }
            for (Map.Entry<Character, Integer> val : temp) {
                if (val.getValue() > 0) {
                    queue.add(val);
                }
            }

            if (queue.isEmpty()) break;
            if (k>0) count+=k;
        }

        return count;
    }

    public static void main(String[] args) {
        TaskScheduler t = new TaskScheduler();
        char[] tasks = {'A','A','A','B','B','B'};
        int n = 2;
        System.out.println(t.leastInterval(tasks, n));
    }
}
