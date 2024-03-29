package problems.medium.dsu;

import java.util.*;

public class AccountsMerge {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        DSU dsu = new DSU();
        Map<String, String> emailToName = new HashMap<>();
        Map<String, Integer> emailToID = new HashMap<>();
        int id = 0;
        for (List<String> account: accounts) {
            String name = "";
            for (String email: account) {
                if (name == "") {
                    name = email;
                    continue;
                }
                emailToName.put(email, name);
                if (!emailToID.containsKey(email)) {
                    emailToID.put(email, id++);
                }
                dsu.union(emailToID.get(account.get(1)), emailToID.get(email));
            }
        }

        Map<Integer, List<String>> result = new HashMap<>();
        for (String email: emailToName.keySet()) {
            int index = dsu.find(emailToID.get(email));
            result.computeIfAbsent(index, x -> new ArrayList<>()).add(email);
        }
        for (List<String> component: result.values()) {
            Collections.sort(component);
            component.add(0, emailToName.get(component.get(0)));
        }
        return new ArrayList<>(result.values());
    }
}

class DSU {
    int[] parent;
    DSU() {
        parent = new int[10001];
        for (int i = 0; i < 10001; i++) {
            parent[i] = i;
        }
    }

    public void union(int x, int y) {
        parent[find(x)] = find(y);
    }

    public int find(int x) {
        if (parent[x] == x) {
            return x;
        }
        parent[x] = find(parent[x]);
        return parent[x];
    }
}