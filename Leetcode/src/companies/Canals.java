package companies;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class Canals {
    private int getNumCanals(int [][] areaMap) {
        int count =0;
        int min = Integer.MAX_VALUE;
        HashMap<Integer, Integer> hmap = new LinkedHashMap<>();
        int k=1;
        boolean start = false;
        for (int i = 0; i < areaMap.length; i++) {
            count=0;
            for (int j=0;j<areaMap[0].length;j++) {
                if (areaMap[i][j] == 0) {
                    count = dfs(areaMap,i,j);
                    System.out.println(count);
                    hmap.put(k, count);
                    k++;
                    System.out.println("count --- " + count);
                }
             }
//             if (count>1)
//                min = Math.min(min,count);
            }
            System.out.println(hmap);


        return min;
    }

    int dfs(int[][] areaMap, int i, int j){
        int count=0;
        if (i<0 || i >= areaMap.length || j<0 || j>=areaMap.length) return 0;
        areaMap[i][j] = 0;
        if (i >= 0 || i < areaMap.length || j >= 0 || j < areaMap.length) {
            if ((i >= 0 || i < areaMap.length || (j+1) >= 0 || (j+1) < areaMap.length) && areaMap[i][j+1] == 1) {
                dfs(areaMap, i, j+1);
                count++;
            }
            if ((i-1 >= 0 || i-1 < areaMap.length || j >= 0 || j < areaMap.length) && areaMap[i-1][j] == 1) {
                dfs(areaMap, i-1, j);
                count++;
            }
            if ((i+1 >= 0 || i+1 < areaMap.length || j >= 0 || j < areaMap.length) && areaMap[i+1][j] == 1) {
                dfs(areaMap, i+1, j);
                count++;
            }
            if ((i >= 0 || i < areaMap.length || j-1 >= 0 || j-1 < areaMap.length) && areaMap[i][j-1] == 1) {
                dfs(areaMap, i, j-1);
                count++;
            }
        }


        return count;
    }

    public static void main(String[] args) {
        Canals c = new Canals();
        int [][] areaMap = {
                    {1,1,1,1,1,1},
                    {0,0,1,1,0,1}};
//                    {0,0,1,1,0,1},
//                    {0,1,1,1,1,1},
//                    {1,1,1,1,1,1}};
//        int[][] areaMap = {
//                {1,0,1,1},
//                {0,1,1,0},
//                {1,1,0,0},
//                {1,0,0,0}};

//        int [][] areaMap =
//                       {{0,0,0,0,1,1,1,1},
//                        {0,0,0,1,1,1,1,1},
//                        {0,0,1,1,1,1,1,1},
//                        {0,1,1,1,1,1,1,1},
//                        {1,1,1,1,0,0,1,1},
//                        {1,1,1,0,0,0,0,1},
//                        {1,1,1,0,0,0,0,1},
//                        {1,1,1,1,0,0,1,1}};

        System.out.println(c.getNumCanals(areaMap));
    }
}
