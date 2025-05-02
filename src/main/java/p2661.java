import java.util.HashMap;
import java.util.Map;

public class p2661 {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        // mat를 순회하여 값이 어떤 좌표에 있는지 기록
        // arr에 순회하며 값의 좌표를 체크하고 row, column 카운트
        int r = mat.length;
        int c = mat[0].length;
        Map<Integer, Pos> mp = new HashMap<>();
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; ++j) {
                mp.put(mat[i][j], new Pos(i, j));
            }
        }
        int[] rowCnt = new int[r]; // rowCnt[i]가 c개 만큼 차면 한 줄 완성
        int[] colCnt = new int[c]; // colCnt[i]가 r개 만큼 차면 한 줄 완성
        for (int i = 0; i < arr.length; i++) {
            int n = arr[i];
            Pos pos = mp.get(n);
            rowCnt[pos.y]++;
            colCnt[pos.x]++;
            if (rowCnt[pos.y] == c) return i;
            if (colCnt[pos.x] == r) return i;
        }
        return -1;
    }

    class Pos {
        int y, x;

        public Pos(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}
