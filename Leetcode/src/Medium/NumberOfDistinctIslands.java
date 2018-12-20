package Medium;

import java.util.HashSet;
import java.util.Set;

public class NumberOfDistinctIslands {

    public int numDistinctIslands(int[][] grid) {
        Set<String> distinct = new HashSet<>();
        for(int i=0;i<grid.length;i++) {
            for (int j=0;j<grid[0].length;j++) {
                if (grid[i][j] == 1) {
                    String val = dfs(grid,i,j, new StringBuilder("f"));
                    distinct.add(val);
                }
            }
        }
        return distinct.size();
    }

    public String dfs(int[][] grid, int i, int j, StringBuilder s) {
        if (i<0 || i>= grid.length || j<0 || j>= grid[0].length || grid[i][j] != 1)
            return s.toString();
        grid[i][j] = 0;
        s.append(dfs(grid, i-1,j, new StringBuilder("u")));
        s.append(dfs(grid, i,j+1, new StringBuilder("r")));
        s.append(dfs(grid, i+1,j, new StringBuilder("d")));
        s.append(dfs(grid, i,j-1, new StringBuilder("l")));
        return s.toString();
    }

    public static void main(String[] args) {
        NumberOfDistinctIslands i = new NumberOfDistinctIslands();
        int [][] areaMap =
                {{0,0,0,0,1,1,1,1},
                        {0,0,0,1,1,1,1,1},
                        {0,0,1,1,1,1,1,1},
                        {0,1,1,1,1,1,1,1},
                        {1,1,1,1,0,0,1,1},
                        {1,1,1,0,0,0,0,1},
                        {1,1,1,0,0,0,0,1},
                        {1,1,1,1,0,0,1,1}};
        int[][] grid = {
                {1,1,0,1,1},
                {1,0,0,0,0},
                {0,0,0,0,1},
                {1,1,0,1,1}};
        System.out.println(i.numDistinctIslands(grid));
    }
}
