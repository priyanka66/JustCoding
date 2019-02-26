package Medium;

import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Queue;

public class CheapestFlightsWithinKStops {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        if  (flights.length == 0) return -1;
        HashMap<Integer, HashMap<Integer, Integer>> hmap = new HashMap<>();
        for (int[] flight : flights) {
            if (!hmap.containsKey(flight[0])) {
                hmap.put(flight[0], new HashMap<>());
            }
            hmap.get(flight[0]).put(flight[1], flight[2]);
        }
        PriorityQueue<int[]> queue = new PriorityQueue<>((a,b)->a[0]-b[0]);
        queue.offer(new int[]{0, src, K+1});
        while (!queue.isEmpty()) {
            int[] top = queue.poll();
            int price = top[0];
            int city  = top[1];
            int stops = top[2];
            if (dst == city)  return price;
            if (stops > 0) {
                HashMap<Integer, Integer> connectedCities = hmap.getOrDefault(city, new HashMap<>());
                for (int next:connectedCities.keySet())  {
                    queue.add(new int[]{price + connectedCities.get(next), next, stops-1});
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        CheapestFlightsWithinKStops f = new CheapestFlightsWithinKStops();
        int n = 3,  src = 0, dst = 2, K = 1;
        int[][] flights = {{0,1,100},{1,2,100},{0,2,500}};
        System.out.println(f.findCheapestPrice(n, flights, src, dst, K));

    }
}
