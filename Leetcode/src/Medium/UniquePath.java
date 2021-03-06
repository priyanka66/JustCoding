package Medium;

public class UniquePath {

    private int uniquePaths(int m, int n) {
        if (m==0 || n==0) return 0;
        int [][] paths = new int[m][n];
        for (int i=0;i<m;i++) paths[i][0] = 1;
        for (int i=0;i<n;i++) paths[0][i] = 1;

        for (int i=1;i<m;i++) {
            for (int j=1;j<n;j++) {
                paths[i][j] = paths[i-1][j] + paths[i][j-1];
            }
        }

        return paths[m-1][n-1];
    }

    public static void main(String[] args) {
        UniquePath p = new UniquePath();
        int m=7, n=3;
        System.out.println(p.uniquePaths(m,n));
    }

}
