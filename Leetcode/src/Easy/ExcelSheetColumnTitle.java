package Easy;

public class ExcelSheetColumnTitle {

    String convertToTitle(int n) {
        StringBuilder res = new StringBuilder();
        while (n>0) {
            int val = (n-1) % 26;
            char x = (char) (val + 'A');
            res.append(Character.toString(x));
            n = (n-1)/26;
        }

        return res.reverse().toString();
    }
    public static void main(String[] args) {
        ExcelSheetColumnTitle e = new ExcelSheetColumnTitle();
        int n = 701;
        System.out.println(e.convertToTitle(n));
    }
}
