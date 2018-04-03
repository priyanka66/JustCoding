public class PowerOfThree {

    public static boolean isPowerOfThree(int n){
        if (n <=0 ) return false;
        while (n%3 == 0) {
            n = n/3;
        }
        return n == 1? true:false;
    }
    public static void main(String[] args) {
        int n = 28;
        if(isPowerOfThree(n)) System.out.println("YES");
        else System.out.println("NO");
    }
}
