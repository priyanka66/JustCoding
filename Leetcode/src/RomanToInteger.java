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

    static int romanToInt(String s) {
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
    public static void main(String[] args) {
        String s = "MCMIV";
        int intVal = romanToInt(s);
        System.out.println("Integer value of the Roman Number " + s + " is " + intVal);

    }
}
