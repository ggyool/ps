public class p2965 {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid[0].length;
        boolean[] exists = new boolean[n * n + 1];
        int a = -1, b = -1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (exists[grid[i][j]]) {
                    a = grid[i][j];
                }
                exists[grid[i][j]] = true;
            }
        }
        for (int i = 1; i <= n * n; i++) {
            if (!exists[i]) {
                b = i;
            }
        }
        return new int[]{a, b};
    }
}
