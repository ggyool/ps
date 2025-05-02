import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class c3394 {
    // editorial 기반 코드
    public boolean checkValidCuts(int n, int[][] rectangles) {
        return check(rectangles, 0) || check(rectangles, 1);
    }

    boolean check(int[][] rectangles, int dim) {
        Arrays.sort(rectangles, (a,b) -> Integer.compare(a[dim], b[dim]));
        int gapCnt = 0;
        int lastEnd = rectangles[0][dim + 2];
        for (int i=0; i<rectangles.length; i++) {
            int start = rectangles[i][dim];
            int end = rectangles[i][dim + 2];
            if (start >= lastEnd) {
                gapCnt++;
            }
            lastEnd = Math.max(lastEnd, end);
        }
        return gapCnt >= 2;
    }


    // 첫 풀이: 2n long(2n) 으로 editorial nlogn 코드보다 느림
//    public boolean checkValidCuts(int n, int[][] rectangles) {
//        List<int[]> xList = new ArrayList<>();
//        List<int[]> yList = new ArrayList<>();
//        for (int i = 0; i < rectangles.length; i++) {
//            int xStart = rectangles[i][0];
//            int yStart = rectangles[i][1];
//            int xEnd = rectangles[i][2];
//            int yEnd = rectangles[i][3];
//            xList.add(new int[]{xStart, 1});
//            xList.add(new int[]{xEnd, -1});
//            yList.add(new int[]{yStart, 1});
//            yList.add(new int[]{yEnd, -1});
//        }
//        Collections.sort(xList, (a, b) -> {
//            if (a[0] == b[0]) {
//                return Integer.compare(a[1], b[1]);
//            }
//            return Integer.compare(a[0], b[0]);
//        });
//        Collections.sort(yList, (a, b) -> {
//            if (a[0] == b[0]) {
//                return Integer.compare(a[1], b[1]);
//            }
//            return Integer.compare(a[0], b[0]);
//        });
//        return check(xList) || check(yList);
//    }
//
//    boolean check(List<int[]> lst) {
//        int cut = 0;
//        int tmp = 0;
//        for (int i = 0; i < lst.size(); i++) {
//            int[] arr = lst.get(i);
//            if (tmp == 0 && arr[1] == 1) {
//                cut++;
//            }
//            tmp += arr[1];
//        }
//        return cut >= 3;
//    }
}
