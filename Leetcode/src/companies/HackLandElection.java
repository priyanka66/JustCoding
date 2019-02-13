package companies;

import java.util.HashMap;

public class HackLandElection {

    String electionWinner(String[] votes) {
        int count = Integer.parseInt(votes[0]);
        HashMap<String, Integer> hmap = new HashMap<>();
        for (int i=1;i<=count;i++) {
            hmap.put(votes[i], hmap.getOrDefault(votes[i],0)+ 1);
        }

        int max=0;
        String winner = null;
        for (HashMap.Entry<String, Integer> vote : hmap.entrySet()) {
            if (max < vote.getValue()) {
                max = vote.getValue();
                winner = vote.getKey();
            } else if (max == vote.getValue()) {
                if (winner.compareTo(vote.getKey()) < 0) {
                    winner = vote.getKey();
                }

            }
        }
        return winner;

    }
    public static void main(String[] args) {
        HackLandElection h = new HackLandElection();
        String[] votes = {"10", "Alex", "Michael", "Harry", "Dave", "Michael", "Victor", "Harry","Alex","Mary", "Mary"};
        System.out.print(h.electionWinner(votes));

    }
}
