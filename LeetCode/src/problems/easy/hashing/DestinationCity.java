package problems.easy.hashing;

import java.util.*;

public class DestinationCity {
    public String destCity(List<List<String>> paths) {
        Set<String> sources = new HashSet<>();
        for (List<String> cities : paths) {
            sources.add(cities.get(0));
        }

        for (List<String> cities : paths) {
            if (!sources.contains(cities.get(1))) {
                return cities.get(1);
            }
        }
        return "";
    }
}
