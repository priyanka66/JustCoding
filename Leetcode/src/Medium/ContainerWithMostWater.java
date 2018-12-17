//package Medium;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//import java.util.ListIterator;
//
//public class ContainerWithMostWater {
//
//    private int maxArea(int[] height) {
//        if (height.length == 0) return 0;
//        int start=0, end=height.length-1, area=0;
//        System.out.println(end);
//
//
//        while (start<end){
//            if (height[start] < height[end]) {
//                area = Math.max(area, height[start] * (end-start));
//                start++;
//            }
//            else {
//                area = Math.max(area, height[end] * (end-start));
//                end--;
//            }
//
//        }
//
//        return area;
//    }
//    public static void main(String[] args) {
//        ContainerWithMostWater c = new ContainerWithMostWater();
//        int[] height = {1,8,6,2,5,4,8,3,7};
////        System.out.println(c.maxArea(height));
//
//
//        List<List<Integer>> input = new ArrayList<>();
//        List<Integer> data = Arrays.asList(2,13);
//        input.add(data);
//        data = Arrays.asList(5,3);
//        input.add(data);
//        data = Arrays.asList(10,8);
//        input.add(data);
//        data = Arrays.asList(13,4);
//        input.add(data);
//        data = Arrays.asList(15,0);
//        input.add(data);
//        data = Arrays.asList(17,10);
//        input.add(data);
//        data = Arrays.asList(20,5);
//        input.add(data);
//        data = Arrays.asList(25,9);
//        input.add(data);
//        data = Arrays.asList(28,7);
//        input.add(data);
//        data = Arrays.asList(31,0);
//        input.add(data);
//
//        System.out.println(input);
//
//        int[] val = new int[input.size()];
//        for (int i=0 ;i<=input.size()-1;i++) {
//            val[i] = input.get(i).get(1);
//
//        }
//        int start=0, end = input.size()-1, area=0;
//        while (start<end) {
//
//            if (input.get(start).get(1)< input.get(end).get(1)) {
//
//                if (input.get(start).get(1) == 0 || input.get(end).get(1) == 0) {
//                    start++;
//                    continue;
//                }
//                area = Math.max(area,Math.abs((input.get(end).get(1)- input.get(start).get(1))  *  (input.get(end).get(0)- input.get(start).get(0))));
//                start++;
//            } else {
//
//
//                if (input.get(start).get(1) == 0 || input.get(end).get(1) == 0) {
//                    end--;
//                    continue;
//                }
//                area =  Math.max(area,Math.abs((input.get(end).get(1)- input.get(start).get(1))  *  (input.get(end).get(0)- input.get(start).get(0))));
//
//                end--;
//            }
//        }
//
//        System.out.println(area);
//    }
//}
