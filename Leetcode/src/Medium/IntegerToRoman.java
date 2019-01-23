package Medium;

public class IntegerToRoman {
    public String intToRoman(int num) {
        StringBuilder result = new StringBuilder();
        int[] val =  {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] roman = {"M", "CM", "D","CD","C", "XC", "L", "XL", "X",  "IX", "V", "IV", "I"};
        for(int i=0;i<val.length;i++) {
            while ((num >= val[i])) {
                result.append(roman[i]);
                num -= val[i];
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        IntegerToRoman  r = new IntegerToRoman();
        int num = 1994;//MCMXCIV
        System.out.println(r.intToRoman(num));
    }
}
