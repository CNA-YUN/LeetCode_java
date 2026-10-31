import java.util.Arrays;
import java.util.PriorityQueue;

public class Dijkstra {
    /**
     * 迪杰斯特拉算法：从一点到各点最短路径问题
     * 
     * @param graph  形状为[e][3],表示有 e 条边,每条边为(u,v,weight),表示从u->v的权重为weight
     * @param n      个顶点
     * @param origin 源点序号,范围为[0...n-1]
     */
    public int[] distance;

    Dijkstra(int[][] graph, int n, int origin) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        distance = new int[n];
        Arrays.fill(distance, Integer.MAX_VALUE);
        boolean[] visited = new boolean[n];
        distance[origin] = 0;
        pq.offer(new int[] { distance[origin], origin });
        while (!pq.isEmpty()) {
            int[] tmp_node = pq.poll();
            if (tmp_node[0] > distance[tmp_node[1]]) {
                continue;
            }
            visited[tmp_node[1]] = true;
            for (int[] edge : graph) {
                if (edge[0] == tmp_node[1] && !visited[edge[1]]) {
                    if (distance[edge[1]] > distance[tmp_node[1]] + edge[2]) {
                        distance[edge[1]] = distance[tmp_node[1]] + edge[2];
                        pq.offer(new int[] { distance[edge[1]], edge[1] });
                    }
                }
            }
        }
    }
}
