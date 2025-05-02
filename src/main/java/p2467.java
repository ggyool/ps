import java.util.*;

public class p2467 {

    // bfs 2번 돌리는 방법으로 풀었는데 dpeth를 구해서 그런가 여전히 오래 걸림
    public int mostProfitablePath(int[][] edges, int bob, int[] amount) {
        int n = amount.length;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            int[] edge = edges[i];
            int a = edge[0];
            int b = edge[1];
            adj.get(a).add(b);
            adj.get(b).add(a);
        }

        Map<Integer, Integer> depth = new HashMap<>();
        boolean[] visited = new boolean[n];
        visited[0] = true;
        depth.put(0, 0);
        fillDepth(0, adj, depth, visited);
        int[] bobDist = new int[n];
        Arrays.fill(bobDist, -1);
        bobBfs(bob, bobDist, adj, depth);


        int[] aliceSum = new int[n];
        Arrays.fill(aliceSum, -1);
        return aliceBfs(aliceSum, bobDist, adj, depth, amount);
    }

    int aliceBfs(int[] aliceSum, int[] bobDist, List<List<Integer>> adj, Map<Integer, Integer> depth, int[] amount) {
        if (bobDist[0] == 0) {
            return amount[0] / 2;
        }
        int ret = Integer.MIN_VALUE;
        Queue<Integer> q = new LinkedList<>();
        aliceSum[0] = amount[0];
        q.add(0);
        int turn = 0;
        while (!q.isEmpty()) {
            int qSize = q.size();
            for (int t=0; t<qSize; t++) {
                int cur = q.poll();
                List<Integer> nexts = adj.get(cur);
                boolean isLeaf = true;
                for (int i = 0; i < nexts.size(); i++) {
                    int next = nexts.get(i);
                    if (depth.get(cur) + 1 == depth.get(next)) {
                        isLeaf = false;
                        if (turn + 1 == bobDist[next]) {
                            aliceSum[next] = aliceSum[cur] + amount[next] / 2;
                        } else if (bobDist[next] == -1 || turn + 1 < bobDist[next]) {
                            aliceSum[next] = aliceSum[cur] + amount[next];
                        } else {
                            aliceSum[next] = aliceSum[cur];
                        }
                        q.add(next);
                    }
                }
                if (isLeaf) {
                    ret = Math.max(ret, aliceSum[cur]);
                }
            }
            turn++;
        }
        return ret;
    }


    void bobBfs(int bob, int[] dist, List<List<Integer>> adj, Map<Integer, Integer> depth) {
        Queue<Integer> q = new LinkedList<>();
        dist[bob] = 0;
        q.add(bob);
        while (!q.isEmpty()) {
            int cur = q.poll();
            List<Integer> nexts = adj.get(cur);
            for (int i = 0; i < nexts.size(); i++) {
                int next = nexts.get(i);
                if (depth.get(cur) - 1 == depth.get(next)) {
                    dist[next] = dist[cur] + 1;
                    q.add(next);
                }
            }
        }
    }

    void fillDepth(int cur, List<List<Integer>> adj, Map<Integer, Integer> depth, boolean[] visited) {
        List<Integer> nexts = adj.get(cur);
        for (int i = 0; i < nexts.size(); i++) {
            int next = nexts.get(i);
            if (!visited[next]) {
                visited[next] = true;
                depth.put(next, depth.get(cur) + 1);
                fillDepth(next, adj, depth, visited);
            }
        }
    }


    // 아래는 첫 풀이: 백트래킹으로 풀었는데 풀면서도 정해가 아니란걸 알았는데 edge수가 적어서 시간초과 안날꺼라고 생각하고 품
    // 노드별 depth를 구함.
    // alice 는 depth가 증가하는 방향으로만 이동 가능하고. bob은 반대

    // 풀고나니 0->leaf, leaf->0으로 경우의 수가 여러가지라고 생각했는데 하나였음
//    public int mostProfitablePath(int[][] edges, int bob, int[] amount) {
//        if (bob == 0) {
//            return amount[0] / 2;
//        }
//        int n = amount.length;
//        List<List<Integer>> adj = new ArrayList<>();
//        for (int i = 0; i < n; i++) {
//            adj.add(new ArrayList<>());
//        }
//        for (int i = 0; i < edges.length; i++) {
//            int[] edge = edges[i];
//            int a = edge[0];
//            int b = edge[1];
//            adj.get(a).add(b);
//            adj.get(b).add(a);
//        }
//
//        Map<Integer, Integer> depth = new HashMap<>();
//        boolean[] visited = new boolean[n];
//        visited[0] = true;
//        depth.put(0, 0);
//        fillDepth(0, adj, depth, visited);
//
//        int[] ans = new int[]{Integer.MIN_VALUE};
//        int tmp = amount[0];
//        amount[0] = 0;
//        amount[bob] = 0;
//        solve(0, bob, tmp, ans, adj, depth, amount);
//        return ans[0];
//    }
//
//    void solve(int alice, int bob, int aliceSum, int[] ans, List<List<Integer>> adj, Map<Integer, Integer> depth, int[] amount) {
//        List<Integer> aliceNexts = adj.get(alice);
//        List<Integer> bobNexts = adj.get(bob);
//        boolean isLeafNode = true;
//        for (int i = 0; i < aliceNexts.size(); i++) {
//            int aliceNext = aliceNexts.get(i);
//            if (depth.get(alice) + 1 == depth.get(aliceNext)) {
//                isLeafNode = false;
//                break;
//            }
//        }
//        if (isLeafNode) {
//            ans[0] = Math.max(ans[0], aliceSum);
//            return;
//        }
//        if (depth.get(bob) == 0) {
//            for (int i = 0; i < aliceNexts.size(); i++) {
//                int aliceNext = aliceNexts.get(i);
//                if (depth.get(alice) + 1 != depth.get(aliceNext)) continue;
//                int a = amount[aliceNext];
//                amount[aliceNext] = 0;
//                solve(aliceNext, bob, aliceSum + a, ans, adj, depth, amount);
//                amount[aliceNext] = a;
//            }
//            return;
//        }
//        for (int i = 0; i < aliceNexts.size(); i++) {
//            for (int j = 0; j < bobNexts.size(); j++) {
//                int aliceNext = aliceNexts.get(i);
//                int bobNext = bobNexts.get(j);
//                if (depth.get(alice) + 1 != depth.get(aliceNext)) continue;
//                if (depth.get(bob) - 1 != depth.get(bobNext)) continue;
//
//                if (aliceNext == bobNext) {
//                    int tmp = amount[aliceNext];
//                    amount[aliceNext] = 0;
//                    solve(aliceNext, bobNext, aliceSum + tmp / 2, ans, adj, depth, amount);
//                    amount[aliceNext] = tmp;
//
//                } else {
//                    int a = amount[aliceNext];
//                    int b = amount[bobNext];
//                    amount[aliceNext] = 0;
//                    amount[bobNext] = 0;
//                    solve(aliceNext, bobNext, aliceSum + a, ans, adj, depth, amount);
//                    amount[aliceNext] = a;
//                    amount[bobNext] = b;
//                }
//            }
//        }
//    }
//
//    void fillDepth(int cur, List<List<Integer>> adj, Map<Integer, Integer> depth, boolean[] visited) {
//        List<Integer> nexts = adj.get(cur);
//        for (int i = 0; i < nexts.size(); i++) {
//            int next = nexts.get(i);
//            if (!visited[next]) {
//                visited[next] = true;
//                depth.put(next, depth.get(cur) + 1);
//                fillDepth(next, adj, depth, visited);
//            }
//        }
//    }
}
