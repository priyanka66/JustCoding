package Medium;

import java.util.Arrays;

public class DailyTemperatures {

    public int[] dailyTemperatures(int[] T) {
        int[] result = new int[T.length];
        result[T.length-1] = 0;
        for (int i=result.length-2;i>=0;i--) {
            int cur = i+1;
            while (cur<result.length && result[cur]!= 0 && T[cur] <= T[i]){
                cur += result[cur];
            }
            if (T[cur] > T[i]) {
                result[i] = cur-i;
            } else if (result[cur]  == 0){
                result[i] = 0;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        DailyTemperatures d = new DailyTemperatures();
        int[] T = {73,74, 75,71,69,72,76,73};
        System.out.println(Arrays.toString(d.dailyTemperatures(T)));
    }
}
