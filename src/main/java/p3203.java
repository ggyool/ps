import java.util.*;

public class p3203 {

    public static void main(String[] args) {
        var sol = new p3203();
        int[][] edges1 = {
                {0, 1},
                {0, 2},
                {0, 3},
        };
        int[][] edges2 = {
                {0, 1}
        };
        System.out.println(sol.minimumDiameterAfterMerge(edges1, edges2));
    }

    public int minimumDiameterAfterMerge(int[][] edges1, int[][] edges2) {
        // 각 덩어리에서 지름을 구하고 / 2? 합산?
        Map<Integer, List<Integer>> adj1 = makeAdj(edges1);
        Map<Integer, List<Integer>> adj2 = makeAdj(edges2);

        int treeDistance1 = getTreeDistance(adj1);
        int treeDistance2 = getTreeDistance(adj2);
        int merge = (treeDistance1 / 2) + treeDistance1 % 2 + (treeDistance2 / 2) + treeDistance2 % 2 + 1;
        return Math.max(Math.max(treeDistance1, treeDistance2), merge);
    }

    private Map<Integer, List<Integer>> makeAdj(int[][] edges) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for (int i = 0; i < edges.length; i++) {
            var e = edges[i];
            var a = e[0];
            var b = e[1];
            if (!adj.containsKey(a)) {
                adj.put(a, new ArrayList<>());
            }
            if (!adj.containsKey(b)) {
                adj.put(b, new ArrayList<>());
            }
            adj.get(a).add(b);
            adj.get(b).add(a);
        }
        return adj;
    }

    private int getTreeDistance(Map<Integer, List<Integer>> adj) {
        if (adj.isEmpty()) return 0;
        int start = adj.keySet().stream().findAny().orElseThrow();
        var res = getMaxDistanceNode(start, adj);
        return getMaxDistanceNode(res[1], adj)[0];
    }

    // {dist, idx}
    private int[] getMaxDistanceNode(int start, Map<Integer, List<Integer>> adj) {
        Set<Integer> visited = new HashSet<>();
        visited.add(start);
        Queue<Integer> q = new ArrayDeque<>();
        q.add(start);
        int lastNode = start;
        int dist = -1;
        while (!q.isEmpty()) {
            int qLen = q.size();
            dist++;
            for (int i = 0; i < qLen; i++) {
                int cur = q.poll();
                lastNode = cur;
                List<Integer> nexts = adj.get(cur);
                for (Integer next : nexts) {
                    if (visited.contains(next)) continue;
                    visited.add(next);
                    q.add(next);
                }
            }
        }
        return new int[]{dist, lastNode};
    }
}
