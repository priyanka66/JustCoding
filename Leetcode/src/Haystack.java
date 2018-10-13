import java.util.LinkedList;
import java.util.Queue;

public class Haystack {

    private int strStr(String haystack, String needle) {
        int hayLength = haystack.length();
        int needleLength = needle.length();
        if (needleLength > hayLength) return -1;
        if (needleLength == 0) return 0;
        for(int i=0; i<=hayLength-needleLength;i++) {

            if (haystack.substring(i, i+needle.length()).equals(needle)) return i;
        }
        return -1;
    }

    private int strStrV2(String haystack, String needle) {
        if (needle.length() == 0) return 0;
        if (needle.length() > haystack.length()) return -1;
        int i=0,j=0;
        while (i < haystack.length()) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
            } else {
                i = i - j + 1;
                j = 0;
            }
            if (j == needle.length()) {
                return i-j;
            }
        }
        return -1;

    }

    public static void main(String[] args) {
        Haystack h = new Haystack();
        String haystack = "mississippi";
        String needle = "issip";
        int result = h.strStr(haystack, needle);
        System.out.println(result);
        System.out.println(h.strStrV2(haystack, needle));
    }
}
