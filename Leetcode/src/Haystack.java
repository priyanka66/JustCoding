import java.util.LinkedList;
import java.util.Queue;

public class Haystack {

    static int strStr(String haystack, String needle) {
        int hayLength = haystack.length();
        int needleLength = needle.length();
        System.out.println(hayLength);
        System.out.println(needleLength);
        if (needleLength > hayLength) return -1;
        if (needleLength == 0) return 0;
        for(int i=0; i<=hayLength-needleLength;i++) {

            if (haystack.substring(i, i+needle.length()).equals(needle)) return i;
        }
        return -1;
    }
    public static void main(String[] args) {
       String haystack = "a";
       String needle = "a";
       int result = strStr(haystack, needle);
       System.out.println(result);
    }
}
