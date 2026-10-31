public class Solution743 {
    public int networkDelayTime(int[][] times, int n, int k) {
        int[][] graph = new int[times.length][3];
        for (int i = 0; i < times.length; i++) {
            graph[i][0] = times[i][0] - 1;
            graph[i][1] = times[i][1] - 1;
            graph[i][2] = times[i][2];
        }
        Dijkstra d = new Dijkstra(graph, n, k - 1);
        int[] dist = d.distance;
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                return -1;
            }
            res = Math.max(res, dist[i]);
        }
        return res;
    }
}