package Easy;

import java.util.HashMap;

public class StrobogrammaticNumber {

    public boolean isStrobogrammatic(String num) {
        HashMap<Integer, Integer> hmap = new HashMap<>();
        hmap.put(1,1);
        hmap.put(6,9);
        hmap.put(8,8);
        hmap.put(9,6);
        hmap.put(0,0);

        int i=0,j=num.length()-1;
        while (i<=j) {
            if (hmap.get(num.charAt(i)-'0') != num.charAt(j)) return false;
            i++;
            j--;
        }

        return true;
    }

    public static void main(String[] args) {
        StrobogrammaticNumber s = new StrobogrammaticNumber();
        String num = "96";
        System.out.println(s.isStrobogrammatic(num));
    }
}
