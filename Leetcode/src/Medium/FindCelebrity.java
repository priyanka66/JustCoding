package Medium;

public class FindCelebrity {

    int[][] matrix = {{1,0,0}, {0,1,0}, {0,0,1}};

    public int findCelebrity(int n) {
        int candidate = 0;
        for (int i=1;i<n;i++) {
            if (knows(candidate, i)) candidate=i;
        }

        for (int i=0;i<n; i++) {
            if (i!=candidate && (knows(candidate, i) || !(knows(i, candidate)))) return -1;
        }

        return candidate;
    }

    public boolean knows (int i, int j) {
        if (matrix[i][j] == 1) return true;
        return false;
    }
    public static void main(String[] args) {
        FindCelebrity c = new FindCelebrity();
        int n = 3;
        System.out.println(c.findCelebrity(n));

    }
}
