package Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class CourseScheduleII {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] order  = new int[numCourses];
        int index = 0;
        int[] inDegree = new int[numCourses];
        ArrayList[] graph = new ArrayList[numCourses];
        for (int i=0;i<numCourses;i++) {
            graph[i] = new ArrayList();
        }
        for (int i=0;i<prerequisites.length;i++) {
            inDegree[prerequisites[i][0]]++;
            graph[prerequisites[i][1]].add(prerequisites[i][0]);
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i=0;i<numCourses;i++) {
            if (inDegree[i] == 0) {
                order[index++] = i;
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            int course = queue.poll();
            for (int i=0;i<graph[course].size();i++) {
                int next = (int) graph[course].get(i);
                inDegree[next]--;
                if (inDegree[next] == 0) {
                    order[index++] = next;
                    queue.offer(next);
                }
            }
        }

        if (index ==  numCourses) return order;
        return new int[]{};
    }

    public static void main(String[] args) {
        CourseScheduleII c = new CourseScheduleII();
        int numCourses = 4;
        int[][] prerequisites =/* {{0,1},{1,0}};*/{{1,0}, {2,0}, {3,1},{3,2}};
        System.out.println(Arrays.toString(c.findOrder(numCourses, prerequisites)));
    }
}
