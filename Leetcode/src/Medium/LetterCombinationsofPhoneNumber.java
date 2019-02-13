package Medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class LetterCombinationsofPhoneNumber {


    private List<String> letterCombinations(String digits) {
        LinkedList<String> result = new LinkedList<>();
        if (digits.length() == 0) return result;

        String[] map = {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        result.add("");
        for(int i=0;i<digits.length();i++) {
            int x = digits.charAt(i)-'0';
            while (result.peek().length() == i) {
                String val =  result.remove();
                for (char c : map[x].toCharArray()) {
                    result.add(val+c);
                }
            }
        }

        return result;
    }

    HashMap<Character, String> digitMap = new HashMap<>();
    LetterCombinationsofPhoneNumber() {
        digitMap.put('2', "abc");
        digitMap.put('3', "def");
        digitMap.put('4', "ghi");
        digitMap.put('5', "jkl");
        digitMap.put('6', "mno");
        digitMap.put('7', "pqrs");
        digitMap.put('8', "tuv");
        digitMap.put('9', "wxyz");
    }
    private List<String> letterCombinationsV2 (String digits) {
        List<String> result = new ArrayList<>();
        if (digits.length() == 0 || digits == null) return result;
        letterCombinationsV2(digits, result, 0,"");
        return result;
    }

    void letterCombinationsV2(String digits, List<String> result, int index, String temp) {
        if (index == digits.length()) {
            result.add(temp);
            return;
        }
        String str = digitMap.get(digits.charAt(index));
        for (int i=0;i<str.length();i++) {
            letterCombinationsV2(digits, result, index+1, temp+str.charAt(i));
        }
    }


    public static void main(String[] args) {
        LetterCombinationsofPhoneNumber l = new LetterCombinationsofPhoneNumber();
        String digits = "23";

        System.out.println(l.letterCombinations(digits));
        System.out.println(l.letterCombinationsV2(digits));
    }
}
