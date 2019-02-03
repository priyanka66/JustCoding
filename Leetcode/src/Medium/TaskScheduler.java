package Medium;

import java.util.*;

public class TaskScheduler {

    public int leastInterval(char[] tasks, int n) {
       if (n == 0) return 0;
       HashMap<Character, Integer> hmap = new HashMap<>();
       for (char task:tasks) {
           hmap.put(task,hmap.getOrDefault(task, 0)+1);
       }
       PriorityQueue<Map.Entry<Character, Integer>> queue = new PriorityQueue<>(
               (a,b)->a.getValue()!=b.getValue()? b.getValue()-a.getValue() : a.getKey()-b.getKey());

       queue.addAll(hmap.entrySet());
       int count = 0;
       while (!queue.isEmpty()) {
           int k = n+1;
           List<Map.Entry> temp = new ArrayList<>();
           while (!queue.isEmpty() && k >0) {
               Map.Entry<Character, Integer> task = queue.poll();
               task.setValue(task.getValue()-1);
               temp.add(task);
               k--;
               count++;
           }

           for (Map.Entry<Character, Integer> val : temp) {
               if (val.getValue() > 0) queue.offer(val);
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
