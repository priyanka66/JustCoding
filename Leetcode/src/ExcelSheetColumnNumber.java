public class ExcelSheetColumnNumber {

    int getExcelSheetColumnNumber(String s) {
        double sum = 0;
        int index=0;
        for(int i=s.length()-1;i>=0;i--) {
            double charVal = s.charAt(i) - 'A' + 1;
            sum = sum + (Math.pow(26,index) * charVal);
            index++;
        }
        return (int)sum;
    }
    public static void main(String[] args) {
        ExcelSheetColumnNumber e = new ExcelSheetColumnNumber();
        String s = "AB";
        System.out.println(e.getExcelSheetColumnNumber(s));
    }
}
