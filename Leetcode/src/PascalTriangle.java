import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {

    public static List<List<Integer>> generate(int n) {
        if (n <=0 ) return new ArrayList<List<Integer>>();
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for (int i=0; i<n;i++) {
            ArrayList<Integer> inner = new ArrayList<Integer>();
            int j=0;
            while (j<i+1) {
                inner.add(choose(i,j));
                j++;
            }
            result.add(inner);
        }
        return result;
    }

    public static int choose(int n, int k) {
        if (k == 0 ) return 1;
        return (n * choose(n-1,k-1)/k);
    }
    public static void main(String[] args) {
        int n = 6;
        System.out.println(generate(n));
    }
}
