import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class c1976 {

    private static final int MOD = 1_000_000_007;

    // 제대로 다익스트라 풀이
    public int countPaths(int n, int[][] roads) {
        List<List<int []>> adj = new ArrayList<>();
        for (int i=0; i<n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i=0; i<roads.length; i++) {
            int a = roads[i][0];
            int b = roads[i][1];
            int c = roads[i][2];
            adj.get(a).add(new int[]{b, c});
            adj.get(b).add(new int[]{a, c});
        }
        // 정점, minDist
        PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> Long.compare(a[1], b[1]));
        pq.add(new long[]{0,0});
        long[] minDist = new long[n];
        Arrays.fill(minDist, Long.MAX_VALUE);
        minDist[0] = 0;

        int[] cnt = new int[n];
        cnt[0] = 1;

        while (!pq.isEmpty()) {
            long[] cur = pq.poll();
            int curNode = (int) cur[0];
            long curDist = cur[1];
            if (curDist > minDist[curNode]) continue;
            List<int[]> nexts = adj.get(curNode);
            for (int i=0; i<nexts.size(); i++) {
                int[] edge = nexts.get(i);
                int nextNode = edge[0];
                if (minDist[nextNode] > curDist + edge[1]) {
                    minDist[nextNode] = curDist + edge[1];
                    pq.add(new long[]{nextNode, curDist + edge[1]});
                    cnt[nextNode] = cnt[curNode];
                } else if (minDist[nextNode] == curDist + edge[1]) {
                    cnt[nextNode] += cnt[curNode];
                    cnt[nextNode] %= MOD;
                }
            }
        }
        return cnt[n-1];
    }

    // 첫 풀이, 어찌저찌 가지치기로 pass 했지만 1초 걸림
    // 다익스트라도 잘 못 구현한듯?
//    public int countPaths(int n, int[][] roads) {
//        List<List<Edge>> adj = new ArrayList<>();
//        for (int i=0; i<n; i++) {
//            adj.add(new ArrayList<>());
//        }
//        for (int i=0; i<roads.length; i++) {
//            int from = roads[i][0];
//            int to = roads[i][1];
//            int value = roads[i][2];
//            adj.get(from).add(new Edge(from, to, value));
//            adj.get(to).add(new Edge(to, from, value));
//        }
//        long[] dist = new long[n];
//        Arrays.fill(dist, 1000_000_000L * 200 + 1);
//        dist[0] = 0;
//        PriorityQueue<Edge> pq = new PriorityQueue<>();
//        for (int i=0; i<adj.get(0).size(); i++) {
//            pq.add(adj.get(0).get(i));
//        }
//        while (!pq.isEmpty()) {
//            Edge e = pq.poll();
//            if (dist[e.from] + e.value < dist[e.to]) {
//                dist[e.to] = dist[e.from] + e.value;
//
//                for (int i=0; i<adj.get(e.to).size(); i++) {
//                    pq.add(adj.get(e.to).get(i));
//                }
//            }
//        }
//
//        long shortestPath = dist[n-1];
//        int[] dp = new int[n];
//        Arrays.fill(dp, -1);
//        boolean[] visited = new boolean[n];
//        visited[0] = true;
//        return dfs(0, 0, adj, shortestPath, n-1, visited, dist, dp);
//    }
//
//    int dfs(int cur, long dist, List<List<Edge>> adj, long shortestPath, int destination, boolean[] visited, long[] distArr, int[] dp) {
//        if (destination == cur) {
//            if (dist == shortestPath) {
//                return 1;
//            }
//            return 0;
//        }
//        if (dp[cur] != -1) {
//            return dp[cur];
//        }
//        int ret = 0;
//        List<Edge> edges = adj.get(cur);
//        for (int i=0; i<edges.size(); i++) {
//            Edge e = edges.get(i);
//            if (!visited[e.to] && distArr[e.to] == dist + e.value) {
//                visited[e.to] = true;
//                ret += dfs(e.to, dist + e.value, adj, shortestPath, destination, visited, distArr, dp);
//                ret %= MOD;
//                visited[e.to] = false;
//            }
//        }
//        dp[cur] = ret;
//        return ret;
//    }
//
//    record Edge(int from, int to, int value) implements Comparable<Edge> {
//        @Override
//        public int compareTo(Edge o) {
//            return o.value - value;
//        }
//    }
}
