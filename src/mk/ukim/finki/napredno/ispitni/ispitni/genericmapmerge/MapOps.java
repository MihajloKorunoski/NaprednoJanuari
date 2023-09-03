package mk.ukim.finki.napredno.ispitni.ispitni.genericmapmerge;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

class MapOps {

    public static <K extends Comparable<K>, V> Map<K, V> merge(Map<K, V> left, Map<K, V> right, MergeStrategy<V> mergeStrategy) {
        Map<K, V> resultMap = new TreeMap<>();
        Set<K> commonKeys = new HashSet<>(left.keySet());
        commonKeys.retainAll(right.keySet());

        for (K key : commonKeys) {
            resultMap.put(key, mergeStrategy.merge(left.get(key), right.get(key)));
        }

        left.forEach(resultMap::putIfAbsent);
        right.forEach(resultMap::putIfAbsent);

        return resultMap;
    }
}
