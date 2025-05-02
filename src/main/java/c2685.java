import java.util.*;

public class c2685 {
    public int countCompleteComponents(int n, int[][] edges) {
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
        int[] numbering = new int[n];
        Map<Integer, Integer> counting = new HashMap<>();
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (numbering[i] == 0) {
                cnt++;
                numbering[i] = cnt;
                counting.put(cnt, 1);
                dfs(i, adj, numbering, counting);
            }
        }
        Set<Integer> notComplete = new HashSet<>();
        for (int i = 0; i < n; i++) {
            int number = numbering[i];
            int count = counting.get(number);
            if (adj.get(i).size() != count - 1) {
                notComplete.add(number);
            }
        }
        return cnt - notComplete.size();
    }

    void dfs(int cur, List<List<Integer>> adj, int[] numbering, Map<Integer, Integer> counting) {
        List<Integer> nexts = adj.get(cur);
        for (int i = 0; i < nexts.size(); i++) {
            int next = nexts.get(i);
            if (numbering[next] == 0) {
                numbering[next] = numbering[cur];
                counting.put(numbering[cur], counting.get(numbering[cur]) + 1);
                dfs(next, adj, numbering, counting);
            }
        }
    }
}
