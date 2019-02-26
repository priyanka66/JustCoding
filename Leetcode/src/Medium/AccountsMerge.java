package Medium;

import java.util.*;

public class AccountsMerge {

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        List<List<String>> result = new ArrayList<>();
        if (accounts.size() == 0) return result;
        HashMap<String, String>  emailMap = new HashMap<>();
        HashMap<String, Set<String>> graph = new HashMap<>();
        for (List<String> account:accounts) {
            String name = account.get(0);
            for (int i=1;i<account.size();i++) {
                if (!graph.containsKey(account.get(i)))
                    graph.put(account.get(i), new HashSet<>());
                emailMap.put(account.get(i), name);
                if (i==1) continue;
                graph.get(account.get(i)).add(account.get(i-1));
                graph.get(account.get(i-1)).add(account.get(i));
            }
        }

        Set<String> visited = new HashSet<>();
        for (String email : emailMap.keySet()) {
            if (visited.add(email)) {
                List<String> users = new ArrayList<>();
                getAllUsers(users, graph, email, visited);
                users.add(0, emailMap.get(email));
                result.add(users);
            }
        }

        return result;
    }

    void getAllUsers(List<String> users, HashMap<String, Set<String>> graph, String email, Set<String> visited) {
        users.add(email);
        for (String next:graph.get(email)) {
            if (visited.add(next)) {
                getAllUsers(users, graph, next, visited);
            }
        }
    }

    public static void main(String[] args) {
        AccountsMerge a = new AccountsMerge();
        List<List<String>> accounts = new ArrayList<>();
        List<String> account = new ArrayList<>();
        account.add("John");
        account.add("johnsmith@mail.com");
        account.add("john00@mail.com");
        accounts.add(account);
        account = new ArrayList<>();

        account.add("John");
        account.add("johnnybravo@mail.com");
        accounts.add(account);
        account = new ArrayList<>();

        account.add("John");
        account.add("johnsmith@mail.com");
        account.add("john_newyork@mail.com");
        accounts.add(account);
        account = new ArrayList<>();

        account.add("Mary");
        account.add("mary@mail.com");
        accounts.add(account);

        System.out.println(a.accountsMerge(accounts));
    }

}
