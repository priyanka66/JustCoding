public class AddBinary {

    public String addBinary(String a, String b) {
        int carry = 0;
        if (a.length() == 0) return b;
        if (b.length() == 0) return a;
        StringBuilder result = new StringBuilder();
        int i = a.length()-1;
        int j = b.length()-1;
        while (i>=0 || j>=0) {
            int sum = carry;
            if (i>=0) sum = sum + a.charAt(i--) - '0';
            if (j>=0) sum = sum + b.charAt(j--) - '0';

            carry = sum/2;
            sum = sum %2;
            result.append(sum);
        }
        if (carry != 0) result.append(carry);
        return result.reverse().toString();
    }

    public static void main(String[] args) {
        AddBinary a1 = new AddBinary();
        String a = "11";
        String b = "10";
        System.out.println(a1.addBinary(a,b));
    }

}
