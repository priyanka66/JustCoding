package Easy;

public class VerifyAlienDictionary {

    public boolean isAlienSorted(String[] words, String order) {
        int[] orders = new int[26];
        for (int i=0;i<order.length();i++) {
            orders[order.charAt(i)-'a'] = i;
        }

        for (int i=0;i<words.length-1;i++) {
            int index = 0;
            boolean flag = false;
            while (index < Math.min(words[i].length(), words[i+1].length())) {
                if (orders[words[i].charAt(index)-'a'] < orders[words[i+1].charAt(index)-'a']) {
                    flag = true;
                    break;
                }
                if (orders[words[i].charAt(index)-'a'] > orders[words[i+1].charAt(index)-'a']) {
                    return false;
                }
                index++;
            }

            if (words[i].length() > words[i+1].length() && !flag) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        VerifyAlienDictionary a = new VerifyAlienDictionary();
        String[] words = {"hello", "leetcode"};
        String order = "hlabcdefgijkmnopqrstuvwxyz";
        System.out.println(a.isAlienSorted(words, order));
    }
}
