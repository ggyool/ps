import java.util.*;

public class p2493 {
    public int magnificentSets(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            int a = edges[i][0];
            int b = edges[i][1];
            adj.get(a).add(b);
            adj.get(b).add(a);
        }
        Map<Integer, Integer> group = new HashMap<>();
        int groupNum = 1;
        boolean[] visited = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                if (!checkPossible(i, visited, adj, n, group, groupNum++)) {
                    return -1;
                }
            }
        }
        Map<Integer, Integer> diameterPerGroup = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            int g = group.get(i);
            int dist = calcMaxDistance(i, adj, n);
            diameterPerGroup.compute(g, (k, v) -> {
                if (v == null || dist > v) {
                    return dist;
                }
                return v;
            });
        }
        int ans = 0;
        for (Integer key : diameterPerGroup.keySet()) {
            ans += (diameterPerGroup.get(key) + 1);
        }
        return ans;
    }

    private boolean checkPossible(int start, boolean[] visited, List<List<Integer>> adj, int n, Map<Integer, Integer> group, int groupNum) {
        Queue<Integer> q = new ArrayDeque<>();
        q.add(start);
        int[] color = new int[n + 1];
        Arrays.fill(color, -1);
        color[start] = 1;
        while (!q.isEmpty()) {
            int cur = q.poll();
            group.put(cur, groupNum);
            for (int i = 0; i < adj.get(cur).size(); i++) {
                int next = adj.get(cur).get(i);
                if (!visited[next]) {
                    visited[next] = true;
                    color[next] = color[cur] * -1;
                    q.add(next);
                } else if (color[cur] == color[next]) {
                    return false;
                }
            }
        }
        return true;
    }

    private int calcMaxDistance(int start, List<List<Integer>> adj, int n) {
        Queue<Integer> q = new ArrayDeque<>();
        q.add(start);
        int[] dist = new int[n + 1];
        int ret = 0;
        Arrays.fill(dist, -1);
        dist[start] = 0;
        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int i = 0; i < adj.get(cur).size(); i++) {
                int next = adj.get(cur).get(i);
                if (dist[next] == -1) {
                    dist[next] = dist[cur] + 1;
                    ret = Math.max(ret, dist[next]);
                    q.add(next);
                }
            }
        }
        return ret;
    }
}
