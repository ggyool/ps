public class p2017 {
    public long gridGame(int[][] grid) {
        int c = grid[0].length;
        long[][] psum = new long[2][c];
        psum[0][0] = grid[0][0];
        psum[1][0] = grid[1][0];
        for (int i = 0; i < 2; i++) {
            for (int j = 1; j < c; j++) {
                psum[i][j] = psum[i][j - 1] + grid[i][j];
            }
        }
        long ans = psum[0][c - 1] - psum[0][0];
        for (int j = 1; j < c; j++) {
            long cur = Math.max(psum[0][c - 1] - psum[0][j], psum[1][j - 1]);
            ans = Math.min(ans, cur);
        }
        return ans;
    }
}
