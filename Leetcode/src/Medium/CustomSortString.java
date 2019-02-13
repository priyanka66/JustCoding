package Medium;

public class CustomSortString {

    public String customSortString(String S, String T) {
      int[] count = new int[26];
      for (char c : T.toCharArray()) {
          count[c-'a']++;
      }
      StringBuilder result = new StringBuilder();
      for (char c: S.toCharArray()) {
          if (count[c-'a'] > 0) {
              result.append(c);
              count[c-'a']--;
          }
      }

      for (char c='a'; c<='z';c++) {
          if (count[c-'a'] > 0) {
              result.append(c);
              count[c-'a']--;
          }
      }
      return result.toString();
    }

    public static void main(String[] args) {
        CustomSortString s = new CustomSortString();
        String S = "cba";//"kqep"
        String  T = "abcd";//"pekeq";
        System.out.println(s.customSortString(S,T));
    }
}
