package Medium;

public class UniqueTrees {

    public int numTrees(int n) {
        if (n == 0) return 1;
        int[] T = new int[n+1];
        T[0] = 1;
        T[1] = 1;
        for (int i=2;i<=n;i++)  {
            for (int j=0;j<i;j++) {
                T[i] += T[j] * T[i-j-1];
            }
        }

        return T[n];
    }

    public static void main(String[] args) {
        UniqueTrees t = new UniqueTrees();
        System.out.println(t.numTrees(5));
    }
}
