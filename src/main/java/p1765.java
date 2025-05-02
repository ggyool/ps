import java.util.LinkedList;
import java.util.Queue;

public class p1765 {
    public int[][] highestPeak(int[][] isWater) {
        int[] dy = {0, 1, 0, -1};
        int[] dx = {1, 0, -1, 0};
        int r = isWater.length;
        int c = isWater[0].length;
        boolean[][] visited = new boolean[r][c];
        int[][] dist = new int[r][c];

        Queue<Pos> q = new LinkedList<>();
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (isWater[i][j] == 1) {
                    q.add(new Pos(i, j));
                    visited[i][j] = true;
                }
            }
        }
        while (!q.isEmpty()) {
            Pos cur = q.poll();
            int cy = cur.y;
            int cx = cur.x;
            for (int i = 0; i < 4; i++) {
                int ny = cy + dy[i];
                int nx = cx + dx[i];
                if (ny >= 0 && nx >= 0 && ny < r && nx < c && !visited[ny][nx]) {
                    visited[ny][nx] = true;
                    dist[ny][nx] = dist[cy][cx] + 1;
                    q.add(new Pos(ny, nx));
                }
            }
        }
        return dist;
    }

    class Pos {
        int y, x;

        public Pos(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}
