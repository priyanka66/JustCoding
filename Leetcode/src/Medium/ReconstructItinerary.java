package Medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class ReconstructItinerary {
    public List<String> findItinerary(String[][] tickets) {
        List<String> result =  new ArrayList<>();
        if (tickets.length == 0) return result;
        HashMap<String, PriorityQueue<String>> hmap = new HashMap<>();
        for (String[] ticket: tickets) {
            if (!hmap.containsKey(ticket[0])) {
                hmap.put(ticket[0], new PriorityQueue<>((a,b)->a.compareTo(b)));
            }
            hmap.get(ticket[0]).offer(ticket[1]);
        }
        findItinerary("JFK", hmap, result);
        System.out.println(hmap);
        return result;
    }

    void findItinerary(String dest, HashMap<String, PriorityQueue<String>> hmap, List<String> result) {
        PriorityQueue<String> next = hmap.get(dest);
        while (next != null && !next.isEmpty()) {
            findItinerary(next.poll(), hmap, result);
        }

        result.add(0, dest);
    }
    public static void main(String[] args) {
        ReconstructItinerary i = new ReconstructItinerary();
        String[][] tickets = {
                {"JFK","SFO"},
                {"JFK","ATL"},
                {"SFO","ATL"},
                {"ATL","JFK"},
                {"ATL","SFO"}};
        System.out.println(i.findItinerary(tickets));
    }
}
