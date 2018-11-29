package Easy;

public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        String s = strs[0];
        for (int i=1; i<strs.length;i++) {
            while (strs[i].indexOf(s) != 0) {
                s = s.substring(0,s.length()-1);
                if (s.isEmpty()) return "";
            }
        }
        return s;
    }

    public String longestCommonPrefixV2(String[] strs) {

        if (strs.length == 0  || strs == null ) {
            return "";
        }
        int index = 0;
        Character ch;
        while(true) {
            ch=null;
            for (int i=0;i<strs.length;i++) {
                if (index > strs[i].length()) {
                    return strs[i].substring(0,index);
                }
                if (ch == null) {
                    ch = strs[i].charAt(index);
                } else if (ch !=  strs[i].charAt(index)) {
                    return strs[i].substring(0,index);
                }
            }
            index++;
        }
    }

    public static void main(String[] args){
        LongestCommonPrefix l = new LongestCommonPrefix();
        String[] strs = {"flower","flow","flight"};
        System.out.println(l.longestCommonPrefix(strs));
        System.out.println(l.longestCommonPrefixV2(strs));
    }
}
