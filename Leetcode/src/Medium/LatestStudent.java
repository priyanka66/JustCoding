package Medium;

import java.util.*;

public class LatestStudent {

    String latestStudent(List<List<String>> attendanceData) {
        HashMap<String, Integer> dateMap = new HashMap<>();
        HashMap<String, Integer> nameMap = new HashMap<>();
        HashMap<String, Integer> count = new HashMap<>();
        String result = "";


        for (int i = 0; i< attendanceData.size(); i++) {
            System.out.println(attendanceData.get(i));
            if (dateMap.containsKey(attendanceData.get(i).get(0))) {
                    int oldVal = dateMap.get(attendanceData.get(i).get(0));
                    int val1 = Integer.parseInt((attendanceData.get(i).get(3)));
                    int val2 = Integer.parseInt((attendanceData.get(i).get(2)));
                    if ((val1-val2) > 0) {
                        dateMap.put(attendanceData.get(i).get(0), (oldVal+(val1-val2)));
                    }
                count.put(attendanceData.get(i).get(0), count.get(attendanceData.get(i).get(0))+1);
            } else {
                int val1 = Integer.parseInt((attendanceData.get(i).get(3)));
                int val2 = Integer.parseInt((attendanceData.get(i).get(2)));
                if ((val1-val2) > 0) {
                    dateMap.put(attendanceData.get(i).get(0), (val1-val2));
                }
                count.put(attendanceData.get(i).get(0),1);
            }
        }

        for (Map.Entry<String, Integer> entry : dateMap.entrySet()){
            int val = count.get(entry.getKey());
            entry.setValue(entry.getValue()/val);
        }

        for (int i=0;i<attendanceData.size();i++) {
            if (nameMap.containsKey(attendanceData.get(i).get(1))) {
                int val1 = Integer.parseInt((attendanceData.get(i).get(3)));
                int val2 = Integer.parseInt((attendanceData.get(i).get(2)));
                int relTime = dateMap.get(attendanceData.get(i).get(0));
                int old = nameMap.get(attendanceData.get(i).get(1));
                if (((val1-val2) > 0) && (val1-val2) > relTime ) {
                    nameMap.put(attendanceData.get(i).get(1), old + ((val1-val2)-relTime));
                }

            } else {
                int val1 = Integer.parseInt((attendanceData.get(i).get(3)));
                int val2 = Integer.parseInt((attendanceData.get(i).get(2)));
                int relTime = dateMap.get(attendanceData.get(i).get(0));
                if (((val1-val2) > 0) && (val1-val2) > relTime ) {
                    nameMap.put(attendanceData.get(i).get(1), ((val1-val2)-relTime));
                }
            }
        }
        int max = 0;
        for (Map.Entry<String, Integer> entry:nameMap.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
                result = entry.getKey();
            }
        }

        return result;
    }
    public static void main(String[] args) {
        LatestStudent l = new LatestStudent();
        List<List<String>> attendanceData = new ArrayList<List<String>>();
        List<String> data = Arrays.asList("09-01", "A" , "540", "570");
        attendanceData.add(data);
        data = Arrays.asList("09-01", "B" , "540", "543");
        attendanceData.add(data);
        data = Arrays.asList("09-01", "C" , "540", "530");
        attendanceData.add(data);
        data = Arrays.asList("09-02", "A" , "540", "580");
        attendanceData.add(data);
        data = Arrays.asList("09-02", "B" , "540", "580");
        attendanceData.add(data);
        data = Arrays.asList("09-02", "C" , "540", "595");
        attendanceData.add(data);

        System.out.println(l.latestStudent(attendanceData));
    }
}
