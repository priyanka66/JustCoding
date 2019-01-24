package Medium;

import java.util.*;

public class TopKFrequentElements {

    private List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> result = new ArrayList<>();
        if (k==0 || nums.length ==0) return result;
        Map<Integer, Integer> freq = new HashMap<>();

        for (int num:nums) {
            freq.put(num, freq.getOrDefault(num,0)+1);
        }

        List<Map.Entry<Integer, Integer>> num = new ArrayList<>(freq.entrySet());
        System.out.println(num);
//        num.sort(new Comparator<Map.Entry<Integer, Integer>>() {
//            @Override
//            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
//                return o2.getValue()-o1.getValue();
//            }
//        });
//        Collections.sort(num, new Comparator() {
//            @Override
//            public int compare (Object o1, Object o2) {
//                return (((Comparable)((Map.Entry)(o2)).getValue())
//                        .compareTo(((Map.Entry)(o1)).getValue()));
//            }
//        });
        num.sort((o1, o2)-> o2.getValue()-o1.getValue());
        System.out.println(num);
        for (Map.Entry<Integer, Integer> n : num) {
            if (k>0) {
                result.add(n.getKey());
                k--;
            } else
                break;
        }

        return result;

    }

    private List<Integer> topKFrequentV2(int[] nums, int k) {
        Map<Integer, Integer> numCountMap = new HashMap<>();
        for (int num : nums) {
            numCountMap.put(num, numCountMap.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k, Comparator.comparingInt(num -> numCountMap.get(num)));
        for (int num : numCountMap.keySet()) {
            minHeap.offer(num);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        return new ArrayList<>(minHeap);
    }

    private List<Integer> topKFrequentV3(int[] nums, int k) {
        List<Integer> result = new ArrayList<>();
        Map<Integer, Integer>  hmap = new HashMap<>();
        for(int num:nums) {
            hmap.put(num, hmap.getOrDefault(num,0)+1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>((a,b) -> b.getValue()-a.getValue());
        for (Map.Entry<Integer, Integer> entry : hmap.entrySet()) {
            queue.offer(entry);
        }

        while (result.size() < k) {
            result.add(queue.poll().getKey());
        }

        return result;
    }
    public static void main(String[] args) {
        TopKFrequentElements t = new TopKFrequentElements();
        int[] nums = {1,1,1,2,2,3,3,3};
        int k = 2;
        System.out.println(t.topKFrequent(nums,k));
        System.out.println(t.topKFrequentV2(nums,k));
        System.out.println(t.topKFrequentV3(nums,k));
    }
}
