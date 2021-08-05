package problems.medium.graph;

import java.util.*;

public class ReconstructItinerary {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, LinkedList<String>> flightMap = new HashMap<>();
        for (List<String> ticket: tickets) {
            String src = ticket.get(0);
            String dest = ticket.get(1);
            if (!flightMap.containsKey(src)) {
                flightMap.put(src, new LinkedList<>());
            }
            flightMap.get(src).add(dest);
        }

        flightMap.forEach((key, value) -> Collections.sort(value));
        LinkedList<String> result = new LinkedList<>();
        dfs("JFK", flightMap, result);
        return result;
    }

    private void dfs(String src, Map<String, LinkedList<String>> flightMap, LinkedList<String> result) {
        if (flightMap.containsKey(src)) {
            LinkedList<String> destList = flightMap.get(src);
            while (!destList.isEmpty()) {
                String dest = destList.pollFirst();
                dfs(dest, flightMap, result);
            }
        }
        result.offerFirst(src);
    }
}
