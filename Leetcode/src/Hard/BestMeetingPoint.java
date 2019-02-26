package Hard;


import java.util.ArrayList;
import java.util.List;

public class BestMeetingPoint {

    public int minTotalDistance(int[][] grid) {
        if (grid.length == 0) return 0;
        int height = grid.length, width = grid[0].length;
        List<Integer> coord = new ArrayList<>();
        for (int i=0;i<width;i++) {
            for (int j=0;j<height;j++) {
                if (grid[j][i] == 1) coord.add(i);
            }
        }

        int sum=0;
        int median = coord.get(coord.size()/2);
        for (int x:coord) sum+= Math.abs(median-x);

        coord.clear();
        for (int i=0;i<height;i++) {
            for (int j=0;j<width;j++) {
                if (grid[i][j] == 1) coord.add(i);
            }
        }
        median = coord.get(coord.size()/2);
        for (int x:coord) sum+= Math.abs(median-x);

        return sum;
    }

    public static void main(String[] args) {
        BestMeetingPoint m = new BestMeetingPoint();
        int[][] grid = {
                {1, 0, 0, 0, 1},
                {0, 0, 0, 0, 0},
                {0, 0, 1, 0, 0}};

        System.out.println(m.minTotalDistance(grid));

    }
}
