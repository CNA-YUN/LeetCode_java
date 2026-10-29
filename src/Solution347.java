import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

class Solution347 {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int x : nums) {
            cnt.put(x, cnt.getOrDefault(x, 0) + 1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(
                (a, b) -> Integer.compare(a.getValue(), b.getValue()));
        for (Map.Entry<Integer, Integer> e : cnt.entrySet()) {
            pq.offer(e);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = pq.poll().getKey();
        }
        return res;
    }

    public int[] topKFrequent_bucketsort(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int x : nums) {
            cnt.put(x, cnt.getOrDefault(x, 0) + 1);
        }
        Map<Integer, List<Integer>> bucketMap = new HashMap<>();
        for (Map.Entry<Integer, Integer> e : cnt.entrySet()) {
            int freq = e.getValue();
            bucketMap.computeIfAbsent(freq, key -> new ArrayList<>()).add(e.getKey());

        }
        int id = k - 1;
        int[] res = new int[k];
        for (int i = n; i > 0; i--) {
            List<Integer> list = bucketMap.get(i);

            if (list == null)
                continue; // 跳过空桶
            for (int num : list) { // 直接遍历
                if (id < 0)
                    break;
                res[id--] = num;
            }
            if (id < 0)
                break; // 已凑齐 k 个，提前结束，避免无谓遍历剩余桶
        }
        return res;
    }
}