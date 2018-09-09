public class CountAndSay {

    public String countAndSay(int n) {
        StringBuilder result = new StringBuilder();
        String temp = "1";
        while (n>1) {
            int count = 1;
            for(int i = 1;i< temp.length(); i++) {
                if (temp.charAt(i) ==  temp.charAt(i-1)) count ++;
                else {
                    result.append(count).append(temp.charAt(i-1));
                    count = 1;
                }
            }
            result.append(count).append(temp.charAt(temp.length()-1));
            temp = result.toString();
            result.setLength(0);
            n--;
        }
        return temp;

    }
    public static void main(String[] args) {
        CountAndSay c = new CountAndSay();
        System.out.println(c.countAndSay(5));
    }
}
