public class p2460 {
    public int[] applyOperations(int[] nums) {
        int[] ans = new int[nums.length];
        int j = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                nums[i] = 2 * nums[i];
                nums[i + 1] = 0;
            }
            if (nums[i] != 0) {
                ans[j++] = nums[i];
            }
        }
        if (nums[nums.length - 1] != 0) {
            ans[j++] = nums[nums.length - 1];
        }
        return ans;
    }
}
