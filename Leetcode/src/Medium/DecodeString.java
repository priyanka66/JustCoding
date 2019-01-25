package Medium;

public class DecodeString {

    public String decodeString(String s) {
        if (s == null) return "";
        if (s.length() <= 3) return s;
        int len = s.length();
        for (int i=len-1;i>=0;i--) {
            if (s.charAt(i) == '[') {
                int j=i+1, k=i;
                while (s.charAt(j) != ']') j++;
                String str = s.substring(i+1, j);
                while (k>0 && Character.isDigit(s.charAt(k-1))) k--;
                int num = Integer.parseInt(s.substring(k,i));
                StringBuilder res = new StringBuilder();
                while (num > 0) {
                    res.append(str);
                    num--;
                }
                s = s.substring(0,k) + res.toString() + s.substring(j+1,s.length());
                i = k;
            }
        }
        return s;
    }
    public static void main(String[] args) {
        DecodeString d = new DecodeString();
        System.out.println(d.decodeString("3[z]2[2[y]pq4[2[jk]e1[f]]]ef"));
    }
}
