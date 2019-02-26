package Medium;

import java.util.*;

public class CourseSchedule {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int count = 0;
        int[] inDegree = new int[numCourses];
        ArrayList[] graph = new ArrayList[numCourses];
        Queue<Integer> queue = new LinkedList<>();
        for (int i=0;i<numCourses;i++) {
            graph[i] = new ArrayList();
        }
        for (int i=0;i<prerequisites.length;i++) {
            inDegree[prerequisites[i][1]] ++;
            graph[prerequisites[i][0]].add(prerequisites[i][1]);
        }

        for (int i=0;i<numCourses;i++) {
            if (inDegree[i] == 0)  {
                queue.offer(i);
                count++;
            }
        }

        while (!queue.isEmpty()) {
            int course = queue.poll();
            for (int i=0;i<graph[course].size();i++) {
                int next = (int) graph[course].get(i);
                inDegree[next] --;
                if (inDegree[next] == 0) {
                    queue.offer(next);
                    count++;
                }
            }
        }

        if (count == numCourses) return true;
        return false;
    }

    public static void main(String[] args) {
        CourseSchedule c = new CourseSchedule();
        int numCourses = 2;
        int[][] prerequisites = {{1,0}, {0,1}};
        System.out.println(c.canFinish(numCourses, prerequisites));
    }
}
