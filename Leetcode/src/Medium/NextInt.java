package Medium;

import java.util.Arrays;

public class NextInt {

    private int nextMax(String num) {
        char[] nums = num.toCharArray();
        int i, result = 0;
        for (i =nums.length-1;i> 0;i--) {
            if (nums[i-1] < nums[i]) {
                char x = nums[i-1];
                nums[i-1]= nums[i];
                nums[i] = x;
                break;
            }
        }
        System.out.println(Arrays.toString(nums));
        if (i>0) {
            int j = 0;
            while (j<nums.length) {
                result = (result*10) + nums[j] -'0';
                j++;
            }
        } else {
            result = 0;
        }

        return result;
    }

    public static void main(String[] args) {
        NextInt n = new NextInt();
        String line = "132";
        System.out.println(n.nextMax(line));
        char[] first  = line.toCharArray();
        Arrays.sort(first);
        for (int i=Integer.parseInt(line)+1;;i++) {
            String s = String.valueOf(i);
            char[] next = s.toCharArray();
            Arrays.sort(next);
            char[] nextTemp = new char[first.length];
            nextTemp = Arrays.copyOfRange(next,next.length-first.length, next.length);
            if (Arrays.equals(first, nextTemp)) {
                System.out.println(i);
                break;
            }

        }

    }
}
