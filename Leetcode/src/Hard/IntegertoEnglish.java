package Hard;

public class IntegertoEnglish {

    String[] lessThan20 = {"Zero" , "One", "Two",  "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    String[] tens = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    String[] thousands = {"", "Thousand", "Million", "Billion"};
    public String numberToWords(int num) {
        if (num == 0) return lessThan20[0];
        int i=0;
        String result = "";
        while (num >  0) {
            if (num % 1000 != 0) {
                result = convert(num % 1000) + thousands[i] + " " + result;
                System.out.println(result);
            }
            num /= 1000;
            i++;

        }
        return result.trim();
    }

    String convert(int num) {
        if (num == 0)
            return "";
        else if (num < 20)
            return lessThan20[num] + " ";
        else if (num < 100)
            return tens[num/10] + "  " + convert(num%10);
        else
            return lessThan20[num/100]  +  " Hundred " + convert(num%100);

    }

    public static void main(String[] args) {
        int num = 1234;
        IntegertoEnglish i = new IntegertoEnglish();
        System.out.println(i.numberToWords(num));
    }
}
