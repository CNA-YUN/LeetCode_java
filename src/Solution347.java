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
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((a, b) -> a.getValue() - b.getValue());
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
        List<Integer>[] buckets = new List[nums.length + 1];
        for (Map.Entry<Integer, Integer> e : cnt.entrySet()) {
            int freq = e.getValue();
            if (buckets[freq] == null) {// 先建桶
                buckets[freq] = new ArrayList<>();
            }
            buckets[freq].add(e.getKey());
        }
        int id = k - 1;
        int[] res = new int[k];
        for (int i = n; i > 0; i--) {
            List<Integer> list = buckets[i];
            if (list == null)
                continue; // 跳过空桶
            for (int num : list) { // 直接遍历
                if (id < 0)
                    break;
                res[id--] = num;
            }
        }
        return res;
    }
}