public class p2161 {
    public int[] pivotArray(int[] nums, int pivot) {
        int[] ans = new int[nums.length];
        int sameCnt = 0;
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < pivot) {
                ans[j++] = nums[i];
            } else if (nums[i] == pivot) {
                sameCnt++;
            }
        }
        for (int i = 0; i < sameCnt; i++) {
            ans[j++] = pivot;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > pivot) {
                ans[j++] = nums[i];
            }
        }
        return ans;
    }
}
