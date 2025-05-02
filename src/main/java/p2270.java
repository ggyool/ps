public class p2270 {
    public int waysToSplitArray(int[] nums) {
        int len = nums.length;
        long[] psum = new long[len];
        psum[0] = nums[0];
        long total = nums[0];
        for (int i = 1; i < len; i++) {
            psum[i] = psum[i - 1] + nums[i];
            total += nums[i];
        }
        int ans = 0;
        for (int i = 0; i < len - 1; i++) {
            if (psum[i] >= total - psum[i]) {
                ans++;
            }
        }
        return ans;
    }
}
