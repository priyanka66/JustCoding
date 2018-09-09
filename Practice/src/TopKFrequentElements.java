import java.util.*;

public class TopKFrequentElements {

    private List<Integer> topKFrequent(int[] nums, int k) {

        List<Integer> result = new ArrayList<>();
        if (nums.length == 0 || k <=0) return  result;

        Map<Integer, Integer> freq = new HashMap<Integer, Integer>();

        for (int i: nums) {
            if (freq.containsKey(i)) {
                freq.put(i, freq.get(i)+1);
            }
            else freq.put(i,1);
        }

        List<Map.Entry<Integer, Integer>> entries = new ArrayList<Map.Entry<Integer, Integer>>(freq.entrySet());

//        System.out.println(entries);

        Collections.sort(entries, new Comparator(){
            public int compare(Object o1, Object o2) {
                return ((Comparable) ((Map.Entry) (o2)).getValue())
                        .compareTo(((Map.Entry)(o1)).getValue());
            }
        });

        System.out.println(entries);
        for (Map.Entry<Integer, Integer> entry : entries) {
            if (k>0) {
                result.add(entry.getKey());
                k--;
            }
            else
                break;
        }

        System.out.println(result);
        return result;
    }

    public static void main(String[] args) {
        TopKFrequentElements t = new TopKFrequentElements();
        int[] nums = {1,1,1,2,2,3};
        int k = 2;
        System.out.println(t.topKFrequent(nums,k));
    }
}
