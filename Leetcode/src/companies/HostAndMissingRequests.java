package companies;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class HostAndMissingRequests {

    public static void main(String[] args) throws Exception {
        String filename = "filename.txt";
        BufferedReader br = new BufferedReader(new FileReader("/Users/priyanka/Desktop/file.txt"));
        HashMap <String, Integer> hostName = new HashMap<>();
        try {
            String st;
            while ((st = br.readLine()) != null) {
                String s = st.split(" ")[0];
                hostName.put(s, hostName.getOrDefault(s, 0)+1);
            }
        } finally {
            br.close();
        }

        String outFile = "records_" + filename;
        PrintWriter writer = new PrintWriter(outFile);
        try {
            for (HashMap.Entry<String, Integer> names : hostName.entrySet()) {
                String val = names.getKey() + " " + names.getValue();
                writer.println(val);
            }
        } finally {
            writer.close();
        }


    }
}
