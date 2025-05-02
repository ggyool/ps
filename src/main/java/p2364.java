import java.util.HashMap;
import java.util.Map;

public class p2364 {
    // 첫 풀이
    public long countBadPairs(int[] nums) {
        // bad pair
        // nums[i] - i != nums[j] - j
        // 전체에서 good pair 를 뺀다.
        int len = nums.length;
        Map<Integer, Integer> count = new HashMap<>();
        for (int i = 0; i < len; i++) {
            int key = nums[i] - i;
            count.put(key, count.getOrDefault(key, 0) + 1);
        }
        long ans = (long) len * (len - 1) / 2;
        for (Integer value : count.values()) {
            if (value == 1) continue;
            ans -= ((long) value * (value - 1) / 2);
        }
        return ans;
    }

    // 다른 답 좋은 풀이
    // good - bad 아이디어는 같지만 반복중에 할 수 있었음..
//    public long countBadPairs(int[] nums) {
//        long ans = 0;
//        Map<Integer, Integer> count = new HashMap<>();
//        for (int i=0; i<nums.length; i++) {
//            int diff = nums[i] - i;
//            int value = count.getOrDefault(diff, 0);
//            ans += i;
//            ans -= value;
//            count.put(diff, value + 1);
//        }
//        return ans;
//    }
}
