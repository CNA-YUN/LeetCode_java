import java.util.*;

class Solution1606 {
    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
        int[] cnt = new int[k];
        TreeSet<Integer> idle = new TreeSet<>(); // 空闲服务器编号，有序
        for (int i = 0; i < k; i++)
            idle.add(i);

        // 忙碌堆：int[]{结束时间, 服务器编号}，按结束时间排序
        PriorityQueue<int[]> busy = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        for (int i = 0; i < arrival.length; i++) {
            int t = arrival[i];

            // 1. 释放所有已结束的服务器
            while (!busy.isEmpty() && busy.peek()[0] <= t) {
                idle.add(busy.poll()[1]);
            }

            if (idle.isEmpty())
                continue; // 无空闲服务器，丢弃请求

            // 2. 从 i % k 开始找第一个空闲服务器，找不到则绕回 0
            Integer s = idle.ceiling(i % k);
            if (s == null)
                s = idle.first();

            idle.remove(s);
            cnt[s]++;
            busy.offer(new int[] { t + load[i], s });
        }

        // 3. 收集处理次数最多的服务器
        int max = 0;
        for (int x : cnt)
            max = Math.max(max, x);
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            if (cnt[i] == max)
                ans.add(i);
        }
        return ans;
    }
}
