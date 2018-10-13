public class ReverseBits {

    private int reverseBits(int n) {
        if(n == 0) return 0;
        int res = 0;
        for(int i = 0; i < 32; i++) {
            res <<= 1;
            if((n & 1) == 1) {
                res += 1;
            }
            n >>= 1;
        }
        return res;
    }
    public static void main(String[] args) {
        ReverseBits r = new ReverseBits();
        int n = -805306368;
        System.out.println(r.reverseBits(n));
    }
}
