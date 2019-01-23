package Medium;

public class ReverseWordsStringII {

    public void reverseWords(char[] str) {
        if (str.length == 0 || str == null) return;
        int i=0, j=str.length;
        swap(str, i, j-1);
        System.out.println(str);
        int start = 0;
        while (i<j) {
            while (i<j && str[i]!=' ') i++;
            swap(str, start, i-1);
            i++;
            start=i;
        }
    }

    void swap(char[] str, int i, int j) {
        while (i<j) {
            char x = str[i];
            str[i++] = str[j];
            str[j--] = x;
        }
    }

    public static void main(String[] args) {
        ReverseWordsStringII s = new ReverseWordsStringII();
        char[] str = {'t','h','e', ' ','s', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e'};
        s.reverseWords(str);
        System.out.println(str);
    }
}
