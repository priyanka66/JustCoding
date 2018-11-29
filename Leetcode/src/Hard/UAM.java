package Hard;

import java.util.*;

public class UAM {

    public static class Record {

        long userId;
        long time;
        Record(long userId, long time) {
            this.userId = userId;
            this.time = time;
        }

        public long getUserId() {
            return userId;
        }

        public long getTime() {
            return time;
        }

        @Override
        public String toString() {
            return "Record{" +
                    "userId=" + userId +
                    ", time=" + time +
                    '}';
        }
    }
    public double getMinutes(long millisec) {
        return Math.round( (((millisec)/ (1000))/60.0));
    }

    public HashMap<Integer, Integer> calculateUAM(List<Record> input) {
        Collections.sort(input, new Comparator<Record>() {
            @Override
            public int compare(Record o1, Record o2) {
                if (o1.getTime() < o2.getTime()) return -1;
                if (o1.getTime() == o2.getTime()) return 0;
                else return 1;
            }
        });

        System.out.println(input.toString());

        HashMap<Integer, Integer> uMap = new LinkedHashMap<Integer, Integer>();
        for (int i = 0; i < input.size()-1; i++) {
            System.out.print(input.get(i).userId + " ");
            System.out.println(getMinutes(input.get(i).time));
            if (input.get(i).getTime() != input.get(i+1).getTime()) {
                if (uMap.containsKey((int)input.get(i).userId)) {
                    uMap.put((int)input.get(i).userId, uMap.get((int)input.get(i).userId)+1);
                } else {
                    uMap.put((int)input.get(i).userId, 1);
                }
            } else {
                if (input.get(i).userId != input.get(i+1).userId) {
                    if (uMap.containsKey((int)input.get(i).userId)) {
                        uMap.put((int)input.get(i).userId, uMap.get((int)input.get(i).userId) +1);
                    } else {
                        uMap.put((int)input.get(i).userId, 1);
                    }
                } else continue;
            }
        }

        return uMap;

    }

    public static void main(String args[]) throws Exception {
//        /* Enter your code here. Read input from STDIN. Print output to STDOUT */

        UAM s = new UAM();
        List<Record> input = new ArrayList<>();
        Record r = new Record(20, 100100);
        input.add(r);
        r = new Record(20, 10010000);
        input.add(r);
        r = new Record(20, 1001000);
        input.add(r);
        r = new Record(20, 10010000);
        input.add(r);
        r = new Record(20, 100110);
        input.add(r);
        r = new Record(21, 100110);
        input.add(r);
        r = new Record(22, 1001000);
        input.add(r);
        r = new Record(21, 100100);
        input.add(r);

        HashMap<Integer, Integer> uMap = s.calculateUAM(input);

    }
}
