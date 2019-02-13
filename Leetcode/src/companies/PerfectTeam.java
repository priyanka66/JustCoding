package companies;

import java.util.HashMap;
import java.util.Map;

public class PerfectTeam {

    private int differentTeams(String skills) {
        if (skills.length() == 0 || skills == null) return 0;
        int max_count  = (skills.length()/5);
        String check = "pmcbzp";
        HashMap<Character, Integer> hmap =  new HashMap<>();
        for (int i = 0; i<check.length(); i++) {
            hmap.put(check.charAt(i), 0);
        }
        for (int i =0; i<skills.length();i++) {
            if (hmap.containsKey(skills.charAt(i))) {
                hmap.put(skills.charAt(i),hmap.get(skills.charAt(i))+1);
            } else {
                hmap.put(skills.charAt(i), 1);
            }
        }

        int min = max_count;
        for (Map.Entry<Character, Integer> entry : hmap.entrySet()) {
            if (entry.getValue() < min) {
                min =  entry.getValue();
            }
            if (min == 0) return 0;
        }

        return min;
    }

    public static void main(String[] args) {
        PerfectTeam p = new PerfectTeam();
        String skills = "pcmbzzzz";
        System.out.println(p.differentTeams(skills));
    }
}
