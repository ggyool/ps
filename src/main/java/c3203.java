public class c3203 {
    public int maximumLength(int[] nums, int k) {
        // 이전값, 합의 나머지
        int[][] dp = new int[k][k];
        int ret = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            for (int prev = 0; prev < k; prev++) {
                int next = num % k;
                int mod = (prev + num) % k;
                dp[next][mod] = Math.max(dp[next][mod], dp[prev][mod] + 1);
                ret = Math.max(ret, dp[next][mod]);
            }
        }
        return ret;
    }
}
