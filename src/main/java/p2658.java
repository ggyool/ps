import java.util.ArrayDeque;
import java.util.Queue;

public class p2658 {

    static final int[] dy = {0, 1, 0, -1};
    static final int[] dx = {1, 0, -1, 0};

    public int findMaxFish(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        int ans = 0;
        boolean[][] visited = new boolean[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (!visited[i][j] && grid[i][j] > 0) {
                    visited[i][j] = true;
                    ans = Math.max(ans, bfs(i, j, grid, visited));
                }
            }
        }
        return ans;
    }

    private int bfs(int y, int x, int[][] grid, boolean[][] visited) {
        int r = grid.length;
        int c = grid[0].length;
        int ret = 0;
        Queue<Pos> q = new ArrayDeque<>();
        q.add(new Pos(y, x));
        while (!q.isEmpty()) {
            Pos cur = q.poll();
            ret += grid[cur.y][cur.x];
            for (int i = 0; i < 4; i++) {
                int ny = cur.y + dy[i];
                int nx = cur.x + dx[i];
                if (ny < 0 || nx < 0 || ny >= r || nx >= c) continue;
                if (!visited[ny][nx] && grid[ny][nx] != 0) {
                    visited[ny][nx] = true;
                    q.add(new Pos(ny, nx));
                }
            }
        }
        return ret;
    }

    class Pos {
        int y, x;

        public Pos(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}
