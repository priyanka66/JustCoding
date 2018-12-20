package Medium;

public class DecodeString {

    public String decodeString(String s) {
        if (s == null) return "";
        int len = s.length();
        if (len <= 3) {
            return s;
        }
        for (int i = len - 1; i >= 0; i--) {
            if (s.charAt(i) == '[') {
                int j = i+1, k = i;
                while (s.charAt(j) != ']') {
                    j++;
                }
                while (k >= 1 && Character.isDigit(s.charAt(k-1))) {
                    k--;
                }
                String substr = s.substring(i+1, j);
                int num = Integer.parseInt(s.substring(k, i));
                StringBuilder sb = new StringBuilder();
                while (num != 0) {
                    sb.append(substr);
                    num--;
                }
                s = s.substring(0, k) + sb.toString() + s.substring(j+1, s.length());
                i = k;
            }
        }
        return s;
    }
    public static void main(String[] args) {
        DecodeString d = new DecodeString();
        System.out.println(d.decodeString("3[a]2[bc]"));
    }
}
