package companies;

import java.util.HashMap;

public class EmailDuplicate {

    int emailDuplicates(String[] L) {
        HashMap<String, Integer> email = new HashMap<>();
        for (int i=0;i<L.length;i++) {
            String[] str = L[i].split("@");
            String val = "";
            for (int j=0;j<str[0].length();j++) {
                if (str[0].charAt(j) != '+') {
                    if (str[0].charAt(j) != '.') {
                        val = val+ str[0].charAt(j);
                    }
                } else break;
            }

            String key = val+"@"+str[1];
            if (email.containsKey(key)){
                email.put(key,email.get(key)+1);
            } else {
                email.put(key,1);
            }

        }
        int result = 0;
        for (HashMap.Entry<String, Integer> entry : email.entrySet()) {
            if (entry.getValue() > 1) {
                result++;
            }
        }

        return result;
    }
    public static void main(String[] args) {
        EmailDuplicate e = new EmailDuplicate();
        String[] L = {"a.b@example.com", "x@example.com", "x@exa.mple.com",
                "ab+1@example.com", "y@example.com", "y@example.com","y@example.com",
                "y@exam.ple.com", "y+1111@exam.ple.com", "y+111@exam.ple.com"};
        System.out.println(e.emailDuplicates(L));
    }
}
