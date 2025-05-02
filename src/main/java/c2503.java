import java.util.*;

public class c2503 {
    final int[] dy = {0, 1, 0, -1};
    final int[] dx = {1, 0, -1, 0};

    public int[] maxPoints(int[][] grid, int[] queries) {
        // 작은 숫자 부터 bfs
        Set<Integer> st = new HashSet<>();
        for (int i = 0; i < queries.length; i++) {
            st.add(queries[i]);
        }
        List<Integer> lst = new ArrayList<>(st);
        Collections.sort(lst);
        int r = grid.length;
        int c = grid[0].length;
        Map<Integer, Integer> ansMap = new HashMap<>();
        boolean[][] visited = new boolean[r][c];
        Queue<Pos> q = new LinkedList<>();
        PriorityQueue<Pos> tq = new PriorityQueue<>((a,b) -> {
            return grid[a.y][a.x] - grid[b.y][b.x];
        });
        visited[0][0] = true;
        tq.add(new Pos(0, 0));
        int cnt = 0;
        for (int i = 0; i < lst.size(); i++) {
            int thresh = lst.get(i);
            copyQueue(q, tq, thresh, grid);
            while (!q.isEmpty()) {
                Pos cur = q.poll();
                cnt++;
                for (int d = 0; d < 4; d++) {
                    int ny = cur.y + dy[d];
                    int nx = cur.x + dx[d];
                    if (ny < 0 || nx < 0 || ny >= r || nx >= c) continue;
                    if (visited[ny][nx]) continue;
                    visited[ny][nx] = true;
                    if (grid[ny][nx] >= thresh) {
                        tq.add(new Pos(ny, nx));
                        continue;
                    }
                    q.add(new Pos(ny, nx));
                }
            }
            ansMap.put(thresh, cnt);
        }
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            ans[i] = ansMap.getOrDefault(queries[i], 0);
        }
        return ans;
    }

    private void copyQueue(Queue<Pos> q, Queue<Pos> tq, int thresh, int[][] grid) {
        while(!tq.isEmpty()) {
            Pos top = tq.peek();
            if (grid[top.y][top.x] < thresh) {
                q.add(tq.poll());
            } else {
                break;
            }
        }
    }

    // 첫 풀이: 느림
//    public int[] maxPoints(int[][] grid, int[] queries) {
//        // 작은 숫자 부터 bfs
//        Set<Integer> st = new HashSet<>();
//        for (int i = 0; i < queries.length; i++) {
//            st.add(queries[i]);
//        }
//        List<Integer> lst = new ArrayList<>(st);
//        Collections.sort(lst);
//        int r = grid.length;
//        int c = grid[0].length;
//        Map<Integer, Integer> ansMap = new HashMap<>();
//        boolean[][] visited = new boolean[r][c];
//        Queue<Pos> q = new LinkedList<>();
//        Queue<Pos> tq = new LinkedList<>();
//        visited[0][0] = true;
//        tq.add(new Pos(0, 0));
//        int cnt = 0;
//        for (int i = 0; i < lst.size(); i++) {
//            int thresh = lst.get(i);
//            copyQueue(q, tq, thresh, grid);
//            while (!q.isEmpty()) {
//                Pos cur = q.poll();
//                int cy = cur.y;
//                int cx = cur.x;
//                cnt++;
//                for (int d = 0; d < 4; d++) {
//                    int ny = cur.y + dy[d];
//                    int nx = cur.x + dx[d];
//                    if (ny < 0 || nx < 0 || ny >= r || nx >= c) continue;
//                    if (visited[ny][nx]) continue;
//                    visited[ny][nx] = true;
//                    if (grid[ny][nx] >= thresh) {
//                        tq.add(new Pos(ny, nx));
//                        continue;
//                    }
//                    q.add(new Pos(ny, nx));
//                }
//            }
//            ansMap.put(thresh, cnt);
//        }
//        int[] ans = new int[queries.length];
//        for (int i = 0; i < queries.length; i++) {
//            ans[i] = ansMap.getOrDefault(queries[i], 0);
//        }
//        return ans;
//    }
//
//    private void copyQueue(Queue<Pos> q, Queue<Pos> tq, int thresh, int[][] grid) {
//        int len = tq.size();
//        for (int i = 0; i < len; i++) {
//            Pos p = tq.poll();
//            if (grid[p.y][p.x] < thresh) {
//                q.add(p);
//            } else {
//                tq.add(p);
//            }
//        }
//    }

    record Pos(int y, int x) {
    }
}
