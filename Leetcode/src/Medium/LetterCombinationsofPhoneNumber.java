package Medium;

import java.util.LinkedList;
import java.util.List;

public class LetterCombinationsofPhoneNumber {


    private List<String> letterCombinations(String digits) {
        LinkedList<String> result = new LinkedList<>();
        if (digits.length() == 0) return result;

        String[] map = {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        result.add("");
        for(int i=0;i<digits.length();i++) {
            int x = Character.getNumericValue(digits.charAt(i));
            while (result.peek().length() == i) {
                String val =  result.remove();
                for (char c : map[x].toCharArray()) {
                    result.add(val+c);
                }
            }
        }

        return result;
    }
    public static void main(String[] args) {
        LetterCombinationsofPhoneNumber l = new LetterCombinationsofPhoneNumber();
        String digits = "23";

        System.out.println(l.letterCombinations(digits));
    }
}
