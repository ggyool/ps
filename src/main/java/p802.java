import java.util.ArrayList;
import java.util.List;

public class p802 {

    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        boolean[] isSafe = new boolean[n];
        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                if (recur(i, graph, visited, isSafe)) {
                    isSafe[i] = true;
                }
            }
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (isSafe[i]) {
                ans.add(i);
            }
        }
        return ans;
    }

    boolean recur(int cur, int[][] graph, boolean[] visited, boolean[] isSafe) {
        int[] nexts = graph[cur];
        boolean ret = true;
        for (int i = 0; i < nexts.length; i++) {
            int next = nexts[i];
            if (!visited[next]) {
                visited[next] = true;
                ret = recur(next, graph, visited, isSafe) && ret;
            } else {
                ret = ret && isSafe[next];
            }
        }
        if (ret) isSafe[cur] = true;
        return ret;
    }
}
