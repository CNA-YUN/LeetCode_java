import java.util.ArrayList;
import java.util.List;

public class Solution51 {
    List<List<String>> ans = new ArrayList<>();
    int[] map;
    boolean[] visited;

    public List<List<String>> solveNQueens(int n) {
        map = new int[n];
        visited = new boolean[n];
        dfs(0, n);
        return ans;
    }

    private void dfs(int id, int n) {
        if (id == n) {
            fillans(map);
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                boolean ok = true;
                for (int r = 0; r < id; r++) {
                    if (Math.abs(map[r] - i) == id - r) { // 同一对角线：行差 == 列差
                        ok = false;
                        break;
                    }
                }
                if (!ok)
                    continue;
                visited[i] = true;
                map[id] = i;
                dfs(id + 1, n);
                visited[i] = false;
            }
        }
    }

    private void fillans(int[] mapper) {
        int n = mapper.length;
        List<String> tmp = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++) {
                sb.append(j == mapper[i] ? 'Q' : '.');
            }
            tmp.add(sb.toString());
        }
        ans.add(tmp);
    }

}
