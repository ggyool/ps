public class c3191 {
    public int minOperations(int[] nums) {
        int cnt = 0;
        int len = nums.length;
        for (int i = 0; i < len - 2; i++) {
            if (nums[i] == 0) {
                nums[i] = 1;
                nums[i + 1] = 1 - nums[i + 1];
                nums[i + 2] = 1 - nums[i + 2];
                cnt++;
            }
        }
        if (nums[len - 2] + nums[len - 1] == 2) {
            return cnt;
        }
        return -1;
    }
}
