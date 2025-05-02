import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class p827 {
    static final int[] dy = new int[]{0, 1, 0, -1};
    static final int[] dx = new int[]{1, 0, -1, 0};

    public int largestIsland(int[][] grid) {
        // 1. 땅덩어리 번호를 구해서 마킹
        // 2. 물 순회하며  연결 가능한지 체크
        int ans = 0;
        int r = grid.length;
        int c = grid[0].length;
        Map<Integer, Integer> groundSize = new HashMap<>();
        int groundNum = 1;
        int[][] ground = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (grid[i][j] == 1 && ground[i][j] == 0) {
                    ground[i][j] = groundNum;
                    int size = fillGround(i, j, grid, ground, groundNum);
                    ans = Math.max(ans, size);
                    groundSize.put(groundNum, size);
                    groundNum++;
                }
            }
        }
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (grid[i][j] == 0) {
                    int ifSumGround = 0;
                    Set<Integer> check = new HashSet<>();
                    for (int d = 0; d < 4; d++) {
                        int ny = i + dy[d];
                        int nx = j + dx[d];
                        if (ny < 0 || nx < 0 || ny >= r || nx >= c) continue;
                        if (grid[ny][nx] == 1 && !check.contains(ground[ny][nx])) {
                            check.add(ground[ny][nx]);
                            ifSumGround += groundSize.get(ground[ny][nx]);
                        }
                    }
                    ans = Math.max(ans, ifSumGround + 1);
                }
            }
        }
        return ans;
    }

    int fillGround(int y, int x, int[][] grid, int[][] ground, int groundNum) {
        int r = grid.length;
        int c = grid[0].length;
        int ret = 1;
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if (ny < 0 || nx < 0 || ny >= r || nx >= c) continue;
            if (grid[ny][nx] == 1 && ground[ny][nx] == 0) {
                ground[ny][nx] = groundNum;
                ret += fillGround(ny, nx, grid, ground, groundNum);
            }
        }
        return ret;
    }
}
