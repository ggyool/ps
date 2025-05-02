public class p1718 {
    public int[] constructDistancedSequence(int n) {
        int len = 2 * n - 1;
        int[] arr = new int[len];
        boolean[] visited = new boolean[n + 1];
        solve(0, n, arr, visited);
        return arr;
    }

    private boolean solve(int idx, int n, int[] arr, boolean[] visited) {
        if (idx == 2 * n - 1) {
            return true;
        }
        boolean ret = false;
        if (arr[idx] != 0) {
            ret |= solve(idx + 1, n, arr, visited);
            if (ret) return true;
            else return false;
        }
        for (int i = n; i >= 1; i--) {
            if (visited[i]) continue;
            if (i != 1) {
                if (idx + i >= 2 * n - 1) continue;
                if (arr[idx + i] != 0) continue;
            }
            arr[idx] = i;
            if (i != 1) arr[idx + i] = i;
            visited[i] = true;
            ret |= solve(idx + 1, n, arr, visited);
            if (ret) return true;
            arr[idx] = 0;
            if (i != 1) arr[idx + i] = 0;
            visited[i] = false;
        }
        return ret;
    }
}
