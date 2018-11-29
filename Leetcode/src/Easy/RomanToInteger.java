package Easy;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class RomanToInteger {

    static int getInt(char c) {
        switch (c) {
            case 'I' : return 1;
            case 'V' : return 5;
            case 'X' : return 10;
            case 'L' : return 50;
            case 'C' : return 100;
            case 'D' : return 500;
            case 'M' : return 1000;
        }
        return -1;
    }

    private int romanToInt(String s) {
        int result =0;
        for (int i=0; i<s.length(); i++) {
            int s1 = getInt(s.charAt(i));
            if (i+1 < s.length()) {
                int s2 = getInt(s.charAt(i+1));
                if (s1 >= s2) {
                    result = result+s1;
                } else {
                    result = result + s2 - s1;
                    i++;
                }
            } else {
                result = result + s1;
                i++;
            }
        }

        return result;
    }

    private int romanToIntV1(String s) {
        if (s.length() == 0) return 0;
        HashMap<Character, Integer> roman = new LinkedHashMap<>();
        insertRoman(roman);
        int sum = 0;
        for (int i=0; i<s.length();i++) {
            int val = roman.get(s.charAt(i));
            if ((i<s.length()-1) && (roman.get(s.charAt(i+1)) > val)) {
                val = roman.get(s.charAt(i+1)) - val;
                i++;
            }
            sum += val;
        }

        return sum;
    }

    private void insertRoman(HashMap<Character, Integer> roman) {
        roman.put('I',1);
        roman.put('V',5);
        roman.put('X',10);
        roman.put('L',50);
        roman.put('C',100);
        roman.put('D',500);
        roman.put('M',1000);


    }
    public static void main(String[] args) {
        String s = "MCMIV";
        RomanToInteger r = new RomanToInteger();
        int intVal = r.romanToInt(s);
        System.out.println("Integer value of the Roman Number " + s + " is " + intVal);
        System.out.println(r.romanToIntV1(s));

    }
}
