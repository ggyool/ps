import java.util.HashMap;
import java.util.Map;

public class p1726 {
    public int tupleSameProduct(int[] nums) {
        Map<Integer, Integer> mp = new HashMap<>();
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                int key = nums[i] * nums[j];
                mp.put(key, mp.getOrDefault(key, 0) + 1);
            }
        }
        // 한 쌍에 8개의 경우의 수 인데 nC2개
        int ans = 0;
        for (Integer value : mp.values()) {
            if (value < 2) {
                continue;
            }
            ans += (8 * value * (value - 1) / 2);
        }
        return ans;
    }
}
