public class p1267 {
    public int countServers(int[][] grid) {
        // 일단 row col 별 카운트
        // row를 순회하며 2개 이상있는 갯수 더하기
        // col을 순회하며 2개 이상있는 갯수 더하기
        // 모든 점 순회하며 겹치는 케이스 제외
        int r = grid.length;
        int c = grid[0].length;
        int[] rowCnt = new int[r];
        int[] colCnt = new int[c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (grid[i][j] == 1) {
                    rowCnt[i]++;
                    colCnt[j]++;
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < r; i++) {
            if (rowCnt[i] >= 2) {
                ans += rowCnt[i];
            }
        }
        for (int j = 0; j < c; j++) {
            if (colCnt[j] >= 2) {
                ans += colCnt[j];
            }
        }
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (grid[i][j] == 1 && rowCnt[i] >= 2 && colCnt[j] >= 2) {
                    ans--;
                }
            }
        }
        return ans;
    }
}
