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

        List<Map.Entry<Integer, Integer>> num = new ArrayList<>(freq.entrySet());
        Collections.sort(num, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                if (o2.getValue() > o1.getValue()) return 1;
                else if (o2.getValue() == o2.getValue()) return 0;
                else return -1;
            }
        });

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

    public static void main(String[] args) {
        TopKFrequentElements t = new TopKFrequentElements();
        int[] nums = {1,1,1,2,2,3};
        int k = 2;
        System.out.println(t.topKFrequent(nums,k));
        System.out.println(t.topKFrequentV2(nums,k));
    }
}
