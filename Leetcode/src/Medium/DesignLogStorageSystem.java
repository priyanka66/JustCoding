package Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class DesignLogStorageSystem {

    HashMap<Integer, String> logs;
    List<Integer> result;
    public DesignLogStorageSystem() {
        logs = new HashMap<Integer, String>();
        result = new ArrayList<>();
    }

    public void put(int id, String timestamp) {
        logs.put(id, timestamp);
    }

    public List<Integer> retrieve(String s, String e, String gra) {
        int index = 0;
        switch (gra) {
            case "Year":
                index = 4;
                break;
            case "Month":
                index = 7;
                break;
            case "Day":
                index = 10;
                break;
            case "Hour":
                index = 13;
                break;
            case "Minute":
                index = 16;
                break;
            case "Second":
                index = 19;
                break;
        }
        s = s.substring(0,index);
        e = e.substring(0,index);

        for(Integer i: logs.keySet()) {
            String s1 =  logs.get(i).substring(0,index);
            if (s1.compareTo(s) >= 0 && s1.compareTo(e) <=0) result.add(i);

        }
        return result;

    }
    public static void main(String[] args) {
        DesignLogStorageSystem log = new DesignLogStorageSystem();
        log.put(1, "2017:01:01:23:59:59");
        log.put(2, "2017:01:01:22:59:59");
        log.put(3, "2016:01:01:00:00:00");
        List<Integer> res = log.retrieve("2016:01:01:01:01:01","2017:01:01:23:00:00","Hour");

        System.out.println(res);

    }
}
