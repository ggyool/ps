public class p3105 {
    public int longestMonotonicSubarray(int[] nums) {
        int ans = 1;
        int inc = 0;
        int dec = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] < nums[i]) {
                if (inc == 0) inc = 1;
                inc++;
                dec = 0;
            } else if (nums[i - 1] > nums[i]) {
                if (dec == 0) dec = 1;
                dec++;
                inc = 0;
            } else {
                inc = 0;
                dec = 0;
            }
            ans = Math.max(ans, inc);
            ans = Math.max(ans, dec);
        }
        return ans;
    }
}
