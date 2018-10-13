package Medium;

import java.util.Arrays;

public class CheckCharacters {
    public static void main(String[] args) {
        String index="abcdefghijklmnopqrstuvwxyz";
        String s = "A quick";
        s = s.toLowerCase().trim();
        int[] exits = new int[26];
        for (int i=0;i<s.length();i++) {
            if ('a' <= s.charAt(i) && s.charAt(i) <= 'z') {
                exits[s.charAt(i)-'a'] = 1;
            }
        }
        String result = new String();
        System.out.println(result);
        for (int i=0;i<exits.length;i++) {
            if (exits[i]==0) {
                result += index.charAt(i);
            }
        }

        System.out.println(result);


    }
}

//    public static boolean checkPangram (String str)
//    {
//        // Create a hash table to mark the
//        // characters present in the string
//        // By default all the elements of
//        // mark would be false.
//        boolean[] mark = new boolean[26];
//
//        // For indexing in mark[]
//        int index = 0;
//
//        // Traverse all characters
//        for (int i = 0; i < str.length(); i++)
//        {
//            // If uppercase character, subtract 'A'
//            // to find index.
//            if ('A' <= str.charAt(i) &&
//                    str.charAt(i) <= 'Z')
//
//                index = str.charAt(i) - 'A';
//
//                // If lowercase character, subtract 'a'
//                // to find index.
//            else if('a' <= str.charAt(i) &&
//                    str.charAt(i) <= 'z')
//
//                index = str.charAt(i) - 'a';
//
//            // Mark current character
//            mark[index] = true;
//        }
//
//        // Return false if any character is unmarked
//        for (int i = 0; i <= 25; i++)
//            if (mark[i] == false)
//                return (false);
//
//        // If all characters were present
//        return (true);