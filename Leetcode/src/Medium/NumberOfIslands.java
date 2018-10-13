package Medium;

public class NumberOfIslands {

    private int numIslands(char[][] grid) {
        if (grid.length == 0) return 0;
        int count=0;
        for (int i=0;i<grid.length;i++) {
            for (int j=0;j<grid[0].length;j++) {
                if (grid[i][j] == '1') {
                    dfs(grid,i,j);
                    count++;
                }
            }
        }

        return count;
    }

    private void dfs(char[][] grid, int i, int j) {
        if (i<0 || i>=grid.length || j<0 || j>=grid[0].length || grid[i][j] != '1') return;

        grid[i][j] = '0';
        dfs(grid, i, j+1);
        dfs(grid, i-1, j);
        dfs(grid, i+1, j);
        dfs(grid, i, j-1);
    }

    public static void main(String[] args) {
        NumberOfIslands i = new NumberOfIslands();
        char[][] grid = {
                {'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'}};

        System.out.println(i.numIslands(grid));
    }
}
