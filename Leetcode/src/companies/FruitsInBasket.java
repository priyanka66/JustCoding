package companies;

import java.util.HashMap;
import java.util.Map;

public class FruitsInBasket {
    public static int totalFruit(int[] tree) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        int max = 0;
        int left = 0;
        for(int i = 0; i < tree.length; i ++){
            hm.put(tree[i], hm.getOrDefault(tree[i], 0) + 1);
            while(hm.size() > 2){
                if(hm.get(tree[left]) == 1){
                    hm.remove(tree[left]);
                }else{
                    hm.put(tree[left], hm.get(tree[left]) - 1);
                }
                left ++;
            }
            max = Math.max(max, i - left + 1);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] tree = {0,1,6,6,4,4,6};
        System.out.println(totalFruit(tree));
    }
}
