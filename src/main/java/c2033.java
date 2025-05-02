import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class c2033 {
    // 중앙ㄱ밧 이용해야함
    public int minOperations(int[][] grid, int x) {
        int r = grid.length;
        int c = grid[0].length;
        List<Integer> lst = new ArrayList<>();
        int minValue = Integer.MAX_VALUE;
        int maxValue = 0;
        for (int i=0; i<r; i++) {
            for (int j=0; j<c; j++) {
                minValue = Math.min(minValue, grid[i][j]);
                maxValue = Math.max(maxValue, grid[i][j]);
                lst.add(grid[i][j]);
            }
        }
        for (int i=0; i<r; i++) {
            for (int j=0; j<c; j++) {
                if ((maxValue - grid[i][j])%x >0) {
                    return -1;
                }
            }
        }
        Collections.sort(lst);
        int median = (lst.size() - 1) / 2;
        return calcCount(grid, lst.get(median), x);
    }

    private int calcCount(int[][] grid, int target, int x) {
        int ret = 0;
        int r = grid.length;
        int c = grid[0].length;
        for (int i=0; i<r; i++) {
            for (int j=0; j<c; j++) {
                ret += abs(grid[i][j] - target) / x;
            }
        }
        return ret;
    }

    private int abs(int n) {
        if (n < 0) return -n;
        return n;
    }
}
