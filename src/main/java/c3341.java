import java.util.PriorityQueue;

public class c3341 {

    public int minTimeToReach(int[][] moveTime) {
        int r = moveTime.length;
        int c = moveTime[0].length;
        int[] dy = {0, 1, 0, -1};
        int[] dx = {1, 0, -1, 0};
        PriorityQueue<Info> pq = new PriorityQueue<>((a, b) -> {
            return a.time - b.time;
        });
        pq.add(new Info(0, 0, 0));
        int[][] dist = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) dist[i][j] = -1;
        }
        dist[0][0] = 0;
        while (!pq.isEmpty()) {
            Info cur = pq.poll();
            for (int i = 0; i < 4; i++) {
                int ny = cur.y + dy[i];
                int nx = cur.x + dx[i];
                if (ny < 0 || nx < 0 || ny >= r || nx >= c) continue;
                int nTime = Math.max(cur.time + 1, moveTime[ny][nx] + 1);
                if (dist[ny][nx] != -1 && dist[ny][nx] <= nTime) continue;
                dist[ny][nx] = nTime;
                pq.add(new Info(nTime, ny, nx));
            }
        }
        return dist[r - 1][c - 1];
    }

    record Info(
            int time,
            int y,
            int x
    ) {
    }
}
