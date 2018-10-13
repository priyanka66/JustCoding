package Medium;

public class MaxAreaofIsland {

    private int maxAreaOfIsland(int[][] grid) {
        int m=grid.length,n=grid[0].length, maxArea=0;

        for(int i=0;i<grid.length;i++) {
            for (int j=0;j<grid[0].length;j++) {
                if (grid[i][j] == 1) {
                    maxArea = Math.max(maxArea, dfs(i,j,m,n, grid));
                }
            }
        }

        return maxArea;
    }

    private int dfs(int i, int j, int m, int n, int[][] grid) {
        if (i<0 || i>=m || j<0 || j>=n || grid[i][j] == 0) return 0;
        grid[i][j]=0;

        int top = dfs(i-1,j,m, n, grid);
        int down = dfs(i+1, j, m, n, grid);
        int left = dfs(i, j-1, m, n, grid);
        int right = dfs(i,j+1, m, n, grid);

        return top+down+left+right+1;
    }

    public static void main(String[] args) {
        MaxAreaofIsland m = new MaxAreaofIsland();
        int[][] grid = {
                {0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}};


        System.out.println(m.maxAreaOfIsland(grid));

    }
}
