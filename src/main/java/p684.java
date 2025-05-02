import java.util.ArrayList;
import java.util.List;

public class p684 {
    public int[] findRedundantConnection(int[][] edges) {
        int elen = edges.length;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i=0; i<elen+1; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i=0; i<elen; i++) {
            int a = edges[i][0];
            int b = edges[i][1];
            adj.get(a).add(b);
            adj.get(b).add(a);
        }
        boolean[] visited = new boolean[elen + 1];
        int[] from = new int[elen + 1];
        visited[1] = true;
        boolean[][] inCycle = new boolean[elen + 1][elen + 1];
        int cycleNode = dfs(1, -1, visited, adj, from);
        int cur = cycleNode;
        do {
            inCycle[cur][from[cur]] = true;
            inCycle[from[cur]][cur] = true;
            cur = from[cur];
        } while((cycleNode != cur));
        for (int i=0; i<elen; i++) {
            int a = edges[elen-i-1][0];
            int b = edges[elen-i-1][1];
            if (inCycle[a][b]) return edges[elen-i-1];
        }
        return new int[]{};
    }

    int dfs(int cur, int prev, boolean[] visited, List<List<Integer>> adj, int[] from) {
        int n = adj.get(cur).size();
        for (int i=0; i<n; i++) {
            int next = adj.get(cur).get(i);
            if (next == prev) continue;
            if (!visited[next]) {
                visited[next] = true;
                from[next] = cur;
                int tmp = dfs(next, cur, visited, adj, from);
                if (tmp > 0) return tmp;
            } else {
                from[next] = cur;
                return next;
            }
        }
        return -1;
    }
}
