package Hard;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestDistanceFromAllBuildings {

    public static class Node {
        int r;
        int c;
        int distance=0;
        Node(int r,int c, int distance) {
            this.r = r;
            this.c = c;
            this.distance = distance;
        }
    }


    public int shortestDistance(int[][] grid) {
        if (grid.length == 0) return 0;
        int[][] distance = new int[grid.length][grid[0].length];
        int[][] visitCount = new int[grid.length][grid[0].length];
        int houseCount = 0;
        int[][] moves = {{1,0},{-1,0},{0,1},{0,-1}};

        for (int r=0;r<grid.length;r++) {
            for (int c=0;c<grid[0].length;c++) {
                if (grid[r][c] == 1) {
                    houseCount++;
                    Queue<Node> queue = new LinkedList<>();
                    queue.add(new Node(r,c,0));
                    boolean[][] visited = new boolean[grid.length][grid[0].length];
                    while (!queue.isEmpty()) {
                        Node pos = queue.poll();
                        distance[pos.r][pos.c] += pos.distance;
                        visitCount[pos.r][pos.c]++;
                        for (int[] move : moves) {
                            if (pos.r+move[0] >=0 &&
                                    pos.r+move[0] < grid.length &&
                                    pos.c+move[1] >=0 &&
                                    pos.c+move[1] < grid[0].length &&
                                    !visited[pos.r+move[0]][pos.c+move[1]] &&
                                    grid[pos.r+move[0]][pos.c+move[1]] == 0) {
                                visited[pos.r+move[0]][pos.c+move[1]] = true;
                                queue.add(new Node(pos.r+move[0],pos.c+move[1], pos.distance+1));
                            }
                        }
                    }
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for (int r=0;r<grid.length;r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == 0 && visitCount[r][c] == houseCount) {
                    min = Math.min(min, distance[r][c]);
                }
            }
        }

        return min == Integer.MAX_VALUE ? -1:min;
    }


    public static void main(String[] args) {
        ShortestDistanceFromAllBuildings s  = new ShortestDistanceFromAllBuildings();
        int[][] grid = {
                {1,0,2,0,1},
                {0,0,0,0,0},
                {0,0,1,0,0}};
        System.out.println(s.shortestDistance(grid));
    }
}
