import java.util.PriorityQueue;

public class p1368 {
    // 좀 느린데 걍 둬야겠다.
    // 비슷하게 푼 풀이는 3차원 배열로 안하고 2차원으로 처리
    // DP 풀이도 있는데 복잡
    public int minCost(int[][] grid) {
        int[] dy = new int[]{0, 0, 0, 1, -1};
        int[] dx = new int[]{0, 1, -1, 0, 0};
        // bfs를 돌리는데 코스트가 낮은것부터 나오는 pq 사용
        int r = grid.length;
        int c = grid[0].length;
        int[][][] dist = new int[r][c][5];
        for (int i=0; i<r; i++) {
            for (int j=0; j<c; j++) {
                for (int k=1; k<5; k++) {
                    dist[i][j][k] = -1;
                }
            }
        }
        PriorityQueue<Info> pq = new PriorityQueue<>();
        pq.add(new Info(0, 0, grid[0][0], 0));
        dist[0][0][grid[0][0]] = 0;
        while(!pq.isEmpty()) {
            Info cur = pq.poll();
            int cy = cur.y;
            int cx = cur.x;
            int ccost = cur.cost;
            int cdir = cur.dir;
            if (cy==r-1 && cx==c-1) {
                return ccost;
            }
            // cost 없이 이동
            int ny = cy + dy[cdir];
            int nx = cx + dx[cdir];
            if (inRange(ny,nx,r,c) && (dist[ny][nx][grid[ny][nx]]==-1)) {
                dist[ny][nx][grid[ny][nx]] = ccost;
                pq.add(new Info(ny,nx,grid[ny][nx],ccost));
            }
            // 제자리에서 방향 변경
            for (int i=1; i<=3; i++) {
                int ndir = 1+(cdir-1+i)%4;
                if (dist[cy][cx][ndir]==-1) {
                    dist[cy][cx][ndir] = ccost + 1;
                    pq.add(new Info(cy,cx,ndir,ccost+1));
                }
            }
        }
        return -1;
    }

    boolean inRange(int y, int x, int r, int c) {
        return y>=0 && x>=0 && y<r && x<c;
    }

    class Info implements Comparable<Info> {
        int y, x, dir, cost;

        public Info(int y, int x, int dir, int cost) {
            this.y = y;
            this.x = x;
            this.dir = dir;
            this.cost = cost;
        }

        @Override
        public int compareTo(Info o) {
            return cost - o.cost;
        }
    }
}
