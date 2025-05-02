public class p1752 {
    public boolean check(int[] nums) {
        int len = nums.length;
        int start = 0;
        for (int i = 1; i < len; i++) {
            if (nums[i - 1] > nums[i]) {
                start = i;
                break;
            }
        }

        for (int i = 1; i < len; i++) {
            if (nums[(i - 1 + start) % len] > nums[(i + start) % len]) {
                return false;
            }
        }
        return true;
    }
}
