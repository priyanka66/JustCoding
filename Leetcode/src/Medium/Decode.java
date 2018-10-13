package Medium;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class Decode {

        public static void main(String[] args) throws IOException {
            InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
            BufferedReader in = new BufferedReader(reader);
            String line;
            while ((line = in.readLine()) != null) {
                System.out.println(line);
            }
            int c2=0;
            if (line.charAt(0) == '0') {
                c2 = 0;
            } else {
                c2=1;
            }
            int c1=1;
            // 123 => (2 , 12)
            //10
            for (int i=1;i<line.length();i++) {
                if (line.charAt(i) =='0') c2=0;
                //26 16
                if ((line.charAt(i-1) =='0' || line.charAt(i-1) =='1') && line.charAt(i) <='6') {
                    int c=c2;
                    c2=c1+c2;
                    c1=c;
                } else {
                    c1=c2;
                }
            }

            System.out.println(c2);
        }

}
