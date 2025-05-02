import java.util.HashMap;
import java.util.Map;

public class c2537 {
    // 첫 풀이
    public long countGood(int[] nums, int k) {
        int len = nums.length;
        long ans = 0;
        Map<Integer, Long> mp = new HashMap<>();
        long cnt = 0;
        int j = 0;
        for (int i = 0; i < len; i++) {
            while (j < len && cnt < k) {
                long bef = mp.getOrDefault(nums[j], 0L);
                mp.put(nums[j], bef + 1);
                if (bef + 1 >= 2) {
                    cnt += bef;
                }
                j++;
            }

            if (cnt >= k) {
                ans += (len - j + 1);
            }

            long subCnt = mp.get(nums[i]);
            mp.put(nums[i], subCnt - 1);
            if (subCnt >= 2) {
                cnt -= (subCnt - 1);
            }
        }
        return ans;
    }
}
