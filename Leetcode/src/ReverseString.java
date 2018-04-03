public class ReverseString {

    String reverseString(String s) {
        int i=0, j = s.length()-1;
        char[] rev = new  char[s.length()];
        for (i=0;i<s.length();i++){
            rev[j--] = s.charAt(i);
        }
        return String.valueOf(rev);
    }

    String reverseStringV1(String s) {
        char[] ret = new char[s.length()];
        int start = 0;
        int end = s.length()-1;
        s.trim();
        while(start<=end){
            ret[start] = s.charAt(end);
            ret[end] = s.charAt(start);
            start++;
            end--;
        }
        return String.valueOf(ret);
    }

    public static void main(String[] args){
        ReverseString r1 = new ReverseString();
        String s = "hello";
        System.out.println(r1.reverseStringV1(s));
    }
}

