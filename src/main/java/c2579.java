public class c2579 {
    public long coloredCells(int n) {
        // if (n==1) {
        //     return 1;
        // }
        // long ans = 1;
        // int tmp = 4;
        // for (int i=1; i<n; i++) {
        //     ans += (i * 4);
        // }
        // return ans;

        // 1 + 2*4 + 3*4 + 4*4 + 5*4... 이런 규칙이 있음
        return 1L + 2L * n * (n-1);
    }
}
