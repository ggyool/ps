public class c2560 {
    public int minCapability(int[] nums, int k) {
        int left = 1;
        int right = 0;
        for (int i = 0; i < nums.length; i++) {
            right = Math.max(right, nums[i]);
        }
        while (left < right) {
            int mid = (right - left) / 2 + left;
            if (isAble(nums, k, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return right;
    }

    // n이하의 값만 뽑아서 k개 이상 뽑는게 가능한지
    private boolean isAble(int[] nums, int k, int n) {
        int cnt = 0;
        int lastPick = -2;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= n && lastPick != i - 1) {
                cnt++;
                lastPick = i;
            }
        }
        return cnt >= k;
    }
}
