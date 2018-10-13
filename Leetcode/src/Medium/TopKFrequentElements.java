package Medium;

import jdk.nashorn.api.tree.Tree;

import java.util.*;

public class TopKFrequentElements {

    private List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> result = new ArrayList<>();
        if (k==0 || nums.length ==0) return result;
        Map<Integer, Integer> freq = new HashMap<>();

        for(int i=0;i<nums.length;i++) {
            if (freq.containsKey(nums[i])) {
                freq.put(nums[i], freq.get(nums[i])+1);
            }
            else freq.put(nums[i],1);
        }
        List<Map.Entry<Integer, Integer>>  num = new ArrayList<Map.Entry<Integer, Integer>>(freq.entrySet());


        Collections.sort(num, new Comparator() {
            public int compare(Object o1, Object o2) {
               return ((Comparable) ((Map.Entry) (o2)).getValue())
                       .compareTo(((Map.Entry) (o1)).getValue());
            }
        });
        for(Map.Entry<Integer,Integer> entry: num) {
            if (k>0) {
                result.add(entry.getKey());
                k--;
            }
            else break;
        }
        return result;
    }

    private List<Integer> topKFrequentV2(int[] nums, int k) {
        List<Integer> result = new ArrayList<>();
        if (nums.length == 0 || k == 0) return result;
        HashMap<Integer, Integer> treeMap =  new HashMap<>();
        for (int i=0;i<nums.length;i++) {
            if (treeMap.containsKey(nums[i])) {
                treeMap.put(nums[i], treeMap.get(nums[i])+1);
            } else {
                treeMap.put(nums[i], 1);
            }
        }
        List<Map.Entry<Integer, Integer>> num = new ArrayList<Map.Entry<Integer, Integer>>(treeMap.entrySet());
        Collections.sort(num, new Comparator(){
            public int compare(Object o1, Object o2) {
                return ((Comparable) ((Map.Entry) o2).getValue()).
                        compareTo((Comparable) ((Map.Entry) o1).getValue());
            }
        });

        for (Map.Entry<Integer, Integer> entry: num) {
            if (k>0) {
                result.add(entry.getKey());
                k--;
            }
            else break;
        }

        return result;

    }
    public static void main(String[] args) {
        TopKFrequentElements t = new TopKFrequentElements();
        int[] nums = {1,1,1,2,2,3};
        int k = 2;
        System.out.println(t.topKFrequent(nums,k));
        System.out.println(t.topKFrequentV2(nums,k));
    }
}