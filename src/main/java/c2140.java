import java.util.Arrays;

public class c2140 {
    public long mostPoints(int[][] questions) {
        long[] dp = new long[questions.length];
        Arrays.fill(dp, -1);
        return solve(0, questions, dp);
    }

    public long solve(int i, int[][] questions, long[] dp) {
        if (i >= questions.length) {
            return 0;
        }
        if (dp[i] != -1) {
            return dp[i];
        }
        int point = questions[i][0];
        int jump = questions[i][1];

        long a = point + solve(i + jump + 1, questions, dp);
        long b = solve(i + 1, questions, dp);

        dp[i] = Math.max(a, b);
        return dp[i];
    }
}
