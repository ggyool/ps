package programmers;

import java.util.Arrays;

public class 완전범죄 {
    public int solution(int[][] info, int n, int m) {
        final int INF = 10000;
        int len = info.length;
        // i까지 훔치고 b의 값이 j일때 A의 적 최소값
        int[][] dp = new int[len][130];
        for (int i = 0; i < len; i++) {
            Arrays.fill(dp[i], INF);
        }
        dp[0][0] = info[0][0];
        dp[0][info[0][1]] = 0;
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < m; j++) {
                // a름 훔치는 경우
                dp[i][j] = Math.min(dp[i][j], dp[i - 1][j] + info[i][0]);
                // b를 훔치는 경우
                dp[i][j + info[i][1]] = Math.min(dp[i][j + info[i][1]], dp[i - 1][j]);
            }
        }
        int ret = INF;
        for (int i = 0; i < m; i++) {
            ret = Math.min(ret, dp[len - 1][i]);
        }
        if (ret >= n) return -1;
        return ret;
    }
}
