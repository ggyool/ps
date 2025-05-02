public class c3396 {

    // 첫 풀이
    public int minimumOperations(int[] nums) {
        int[] cnt = new int[101];
        for (int i = 0; i < nums.length; i++) {
            cnt[nums[i]]++;
        }
        int multipleCnt = 0;
        for (int i = 1; i <= 100; i++) {
            if (cnt[i] > 1) {
                multipleCnt++;
            }
        }
        int ret = 0;
        int startIdx = 0;
        while (multipleCnt > 0) {
            for (int i = 0; i < 3; i++) {
                if (startIdx + i >= nums.length) continue;
                int target = nums[startIdx + i];
                cnt[target]--;
                if (cnt[target] == 1) {
                    multipleCnt--;
                }
            }
            startIdx += 3;
            ret++;
        }
        return ret;
    }
}
