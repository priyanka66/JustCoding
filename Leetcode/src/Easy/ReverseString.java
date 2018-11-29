package Easy;

public class ReverseString {

  private String reverse (String s) {
      StringBuilder rev = new StringBuilder();
      for(int i=s.length()-1; i>=0; i--) {
          rev.append(s.charAt(i));
      }
      return rev.toString();
  }

  private String reverseV1(String s) {
      int i=0,j=s.length()-1;
      char str[] = s.toCharArray();
      char temp ;
      while (i<j) {
          temp = str[i];
          str[i] = str[j];
          str[j] = temp;
          i++;
          j--;
      }

      return String.valueOf(str);
  }
  public static void main(String[] args) {
    ReverseString revS = new ReverseString();
    String s = "A man, a plan, a canal: Panama";
    System.out.println(revS.reverse(s));
    System.out.println(revS.reverseV1(s));
  }
}

