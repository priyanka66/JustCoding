package Easy;

public class SquareRoot {

    static int mySqrt(int x) {
        if (x==0 || x == 1) return x;
        int start = 1, end = x, num = 0;
        while (start<=end) {
            int mid = (start + end) / 2;
            if (x == mid*mid) return mid;
            // Exceeds time limit if the condition is x < mid*mid
            if (x/mid < mid) {
                end = mid - 1;
            } else {
                start = mid + 1;
                num = mid;
            }
        }

        return num;
    }
    public static void main(String[] args) {
        int x = 8;
        int result = mySqrt(x);
        System.out.println("Square root of " + x + " is " + result);
    }
}
