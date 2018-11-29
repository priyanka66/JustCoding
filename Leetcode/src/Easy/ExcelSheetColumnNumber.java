package Easy;

public class ExcelSheetColumnNumber {

    private int getExcelSheetColumnNumber(String s) {
        double sum=0;
        int index=0;
        for (int i=s.length()-1;i>=0;i--){
            int val = s.charAt(i) - 'A' + 1;
            sum = sum + (Math.pow(26,index) * val);
            index++;
        }
        return (int)sum;
    }
    public static void main(String[] args) {
        ExcelSheetColumnNumber e = new ExcelSheetColumnNumber();
        String s = "BB";
        System.out.println(e.getExcelSheetColumnNumber(s));
    }
}
