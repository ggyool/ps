public class c2206 {
    public boolean divideArray(int[] nums) {
        int[] cnt = new int[501];
        for (int i = 0; i < nums.length; i++) {
            cnt[nums[i]]++;
        }
        for (int i = 1; i <= 500; i++) {
            if (cnt[i] % 2 == 1) {
                return false;
            }
        }
        return true;
    }
}
