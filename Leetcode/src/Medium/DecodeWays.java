package Medium;

public class DecodeWays {

    private int numDecodings(String s) {
        if (s.length() == 0 || s == null) return 0;
        int prev = 1, cur = s.charAt(0) == '0' ?0:1;
        for (int i=1;i<s.length();i++) {
            int temp = cur;
            if (s.charAt(i-1) == '1' || s.charAt(i-1) == '2' && s.charAt(i) <='6') {
                if (s.charAt(i) == '0') {
                    cur = prev;
                } else {
                    cur = cur+prev;
                }
            } else if (s.charAt(i) == '0') {
                cur = 0;
            }

            prev = temp;
        }

        return cur;
    }
    public static void main(String[] args) {
        DecodeWays d = new DecodeWays();
        String s = "26";
        System.out.println(d.numDecodings(s));
    }
}
