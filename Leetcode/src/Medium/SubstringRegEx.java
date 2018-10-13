package Medium;

public class SubstringRegEx {

    public static int isMatch() {
        String line = "helello,lolo";
        String[] parts = line.split(",");

        String haystack = parts[0];
        String needle = parts[1];
        if (needle.length() == 0) return 0;
        if (needle.length() > haystack.length()) return -1;
        int i=0,j=0;
        while (i < haystack.length()) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
            } else if (needle.charAt(j) == '*' && needle.charAt(j-1) != '\\') {
                    i = (needle.length()-j);
                    j++;
            }
            else {
                i = i + 1;
                j = 0;
            }
            if (j == needle.length()) {
                return 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String p = "Hello";
        String s  = "llo";
        System.out.println(isMatch());
    }
}
