public class c213 {
    public int rob(int[] nums) {
        int[][] dp = new int[nums.length + 1][2];
        for (int i = 0; i < nums.length + 1; i++) {
            dp[i][0] = -1;
            dp[i][1] = -1;
        }
        return Math.max(
                nums[0] + solve(2, nums, dp, 1),
                solve(1, nums, dp, 0)
        );
    }

    private int solve(int idx, int[] nums, int[][] dp, int firstSelected) {
        if (firstSelected == 1) {
            if (nums.length - 1 <= idx) {
                return 0;
            }
        } else {
            if (nums.length <= idx) {
                return 0;
            }
        }

        if (dp[idx][firstSelected] != -1) {
            return dp[idx][firstSelected];
        }
        dp[idx][firstSelected] = Math.max(
                nums[idx] + solve(idx + 2, nums, dp, firstSelected),
                solve(idx + 1, nums, dp, firstSelected)
        );
        return dp[idx][firstSelected];
    }
}
