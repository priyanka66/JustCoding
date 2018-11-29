package Easy;

public class AddStrings {

    private String addStrings (String num1, String num2) {
        int i=num1.length()-1, j= num2.length()-1;
        int carry=0, sum=0;
        StringBuilder result = new StringBuilder();
        while (i>=0 || j>=0) {
           int a = (i<0) ? 0 : num1.charAt(i--)-'0';
           int b = (j<0) ? 0 : num2.charAt(j--)-'0';

           sum = a+b+carry;
           if (sum>9) carry=1;
           else carry = 0;
           result.append(sum%10);
        }
        if (carry == 1) result.append(1);
        return result.reverse().toString();
    }
    public static void main(String[] args) {
        AddStrings a = new AddStrings();
        String num1 = "9";
        String num2 = "99";

        System.out.println(a.addStrings(num1, num2));


    }
}
