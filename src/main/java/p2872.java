import java.util.ArrayList;
import java.util.List;


public class p2872 {

    public static void main(String[] args) {
        int[][] edges = {
                {0, 2},
                {1, 2},
                {1, 3},
                {2, 4}
        };
        int[] values = {1, 8, 1, 4, 4};
        new p2872().maxKDivisibleComponents(5, edges, values, 6);
    }

    public int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {
        // 1. 탐색을 해서 각 노드가 루트일 때 합산을 구해놓는다.
        // 2. 배수를 활용하여 어쩌구 해야할듯
        // 3. 자식 뭉치가 k로 나눠서 떨어지면 분리
        Node[] nodes = new Node[n];
        for (int i = 0; i < n; i++) {
            nodes[i] = new Node(i, -1, new ArrayList<Integer>());
        }
        for (int i = 0; i < edges.length; i++) {
            nodes[edges[i][0]].edges.add(edges[i][1]);
            nodes[edges[i][1]].edges.add(edges[i][0]);
        }
        for (int i = 0; i < values.length; i++) {
            nodes[i].value = values[i];
        }

        boolean[] visited = new boolean[n];
        long[] sumArr = new long[n];

        visited[0] = true;
        sumDfs(0, visited, sumArr, nodes);


        visited = new boolean[n];
        visited[0] = true;
        return pieceDfs(0, visited, sumArr, nodes, k);
    }

    private long sumDfs(int idx, boolean[] visited, long[] sumArr, Node[] nodes) {
        Node cur = nodes[idx];
        sumArr[idx] = cur.value;
        for (int i = 0; i < cur.edges.size(); i++) {
            int next = cur.edges.get(i);
            if (visited[next] == false) {
                visited[next] = true;
                sumArr[idx] += sumDfs(next, visited, sumArr, nodes);
            }
        }
        return sumArr[idx];
    }

    private int pieceDfs(int idx, boolean[] visited, long[] sumArr, Node[] nodes, int k) {
        Node cur = nodes[idx];
        int ret = sumArr[idx] % k == 0 ? 1 : 0;
        for (int i = 0; i < cur.edges.size(); i++) {
            int next = cur.edges.get(i);
            if (visited[next] == false) {
                visited[next] = true;
                ret += pieceDfs(next, visited, sumArr, nodes, k);
            }
        }
        return ret;
    }

    private static class Node {
        int i;
        int value;
        List<Integer> edges;

        public Node(int i, int value, List<Integer> edges) {
            this.i = i;
            this.value = value;
            this.edges = edges;
        }
    }
}
