package Easy;

public class PowerOfTwo {

    public static boolean isPowerOfTwo(int n){
        if (n<=0) return false;
        while (n%2 == 0) {
            n = n/2;
        }
        if (n==1) return true;
        else return false;
    }
    public static void main(String[] args){
        int n = 65;
        if (isPowerOfTwo(n)) System.out.println("YES");
        else System.out.println("NO");
    }
}
