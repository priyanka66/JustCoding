package Easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SwapStrings {

    public static void main(String[] args) {
        String a = "Hello";
        String b = "World";
        System.out.println("a - " + a);
        System.out.println("b - " + b);

        a = a+b;
        b = a.substring(0, a.length()-b.length());
        a = a.substring(b.length());

        System.out.println("a - " + a);
        System.out.println("b - " + b);

        String str = "00000123569";
        int i=0;
        while (str.charAt(i) == '0') i++;

        StringBuilder s = new StringBuilder(str);
        s.replace(0,i,"");

        System.out.println("str - " + s.toString());

        Integer[] arr = {3,2,1,4,5,6};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        Arrays.sort(arr, Collections.reverseOrder());
        System.out.println(Arrays.toString(arr));

        Integer[] nums = {3,2,1,4,5,6};
        Arrays.parallelSort(nums);
        Arrays.stream(nums)
                .forEach(n->System.out.println(n));

        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        Integer[] l1 = list.stream().toArray(Integer[]::new);
        Integer[] l2 = {2,3,4};
        for (Integer x : l1)
            System.out.print(x + " ");

        System.out.println(Arrays.equals(l1, l2));
    }
}
