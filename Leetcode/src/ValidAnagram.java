public class ValidAnagram {

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        if (s == null && t == null) return false;
        int charCount[] = new int[26];
        for (int i =0; i<s.length();i++) {
            charCount[s.charAt(i) - 'a'] ++;
            charCount[t.charAt(i) - 'a'] --;
        }
        for(int count:charCount) {
            if (count!=0) return false;
        }
        return true;
    }
    public static void main(String[] args) {
        ValidAnagram v1 = new ValidAnagram();
        String s = "abcdar";
        String t = "dbaca";
        if(v1.isAnagram(s, t)) System.out.println("Valid Anagram");
        else System.out.println("Not a Valid Anagram");
    }
}
