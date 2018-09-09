public class ReverseString {

  private String reverse (String s) {
      StringBuilder rev = new StringBuilder();
      for(int i=s.length()-1; i>=0; i--) {
          rev.append(s.charAt(i));
      }
      return rev.toString();
  }
  public static void main(String[] args) {
    ReverseString revS = new ReverseString();
    System.out.println(revS.reverse("hello hellohellohello hello hello hellohellohello hellohello hellohellohello hellohello hellohellohello hellohello hellohellohello hellohello hellohellohello hello "));
  }
}

