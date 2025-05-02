public class p3151 {
    public boolean isArraySpecial(int[] nums) {
        int cur = nums[0] % 2;
        for (int i = 1; i < nums.length; i++) {
            if (cur == 1 && nums[i] % 2 == 0) {
                cur = 1 - cur;
            } else if (cur == 0 && nums[i] % 2 == 1) {
                cur = 1 - cur;
            } else {
                return false;
            }
        }
        return true;
    }
}