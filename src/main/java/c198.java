import java.util.Arrays;

public class c198 {
    public int rob(int[] nums) {
        int[] dp = new int[nums.length + 1];
        Arrays.fill(dp, -1);
        return solve(0, nums, dp);
    }

    private int solve(int idx, int[] nums, int[] dp) {
        if (nums.length <= idx) {
            return 0;
        }
        if (dp[idx] != -1) {
            return dp[idx];
        }
        dp[idx] = Math.max(
                nums[idx] + solve(idx + 2, nums, dp),
                solve(idx + 1, nums, dp)
        );
        return dp[idx];
    }
}
