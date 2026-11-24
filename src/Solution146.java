import java.util.LinkedHashMap;
import java.util.Map;

public class Solution146 {
    private final int capacity;
    private final Map<Integer, Integer> cache = new LinkedHashMap<>();

    public Solution146(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        Integer value = cache.remove(key);
        if (value != null) {
            cache.put(key, value);
            return value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (cache.remove(key) != null) {
            cache.put(key, value);
            return;
        }
        if (cache.size() == capacity) {
            Integer eldestKey = cache.keySet().iterator().next();
            cache.remove(eldestKey);
        }
        cache.put(key, value);
    }
}
