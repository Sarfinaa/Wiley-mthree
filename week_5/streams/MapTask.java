package week_5.streams;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MapTask {
    public static void main(String[] args) {
        // Without using Collections
        Map<Integer, String> map1 = new HashMap<>();
        Map<Integer, String> map2 = new HashMap<>();
        map1.put(1, "A");
        map1.put(2, "B");
        map2.put(1, "C");
        map2.put(2, "D");
        Map<Integer, List<String>> map = new HashMap<>();
        map1.forEach((k, v) -> {
            map.put(k, new ArrayList<>());
            map.get(k).add(v);
        });
        map2.forEach((k, v) -> {
            map.get(k).add(v);
        });
        System.out.println(map);

        // With Collections
        Stream<Map.Entry<Integer, String>> stream = Stream.concat(map1.entrySet().stream(), map2.entrySet().stream());
        Map<Integer, List<String>> streamMap = stream.collect(
                Collectors.groupingBy(Map.Entry::getKey, Collectors.mapping(Map.Entry::getValue, Collectors.toList())));
        System.out.println(streamMap);
    }
}
