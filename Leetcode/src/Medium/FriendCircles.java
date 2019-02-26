package Medium;

public class FriendCircles {
    public int findCircleNum(int[][] M) {
        int count = 0;
        for (int i=0;i<M.length;i++) {
            for (int j=0;j<M[0].length;j++) {
                if (M[i][j] == 1) {
                    dfs(M,i);
                    count ++ ;
                }
            }
        }

        return count;
    }

    void dfs(int[][]M, int i) {
        if (M[i][i] == 1) {
            M[i][i] = 0;
            for (int j=0;j<M.length;j++) {
                if (M[i][j] == 1) {
                    M[i][j] = 0;
                    dfs(M,j);
                }
            }

        }
    }
    public static void main(String[] args) {
        int[][] M = {
                {1,0,0,1},
                {0,1,1,0},
                {0,1,1,1},
                {1,0,1,1}};
        FriendCircles f = new FriendCircles();
        System.out.println(f.findCircleNum(M));

    }
}
