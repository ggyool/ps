import java.util.HashMap;
import java.util.Map;

public class c1124 {
    // 풀이 찾아봄. 접근이 좀 어렵다.
    public int longestWPI(int[] hours) {
        Map<Integer, Integer> mp = new HashMap<>();
        int ans = 0;
        int sum = 0;
        for (int i = 0; i < hours.length; i++) {
            int change = hours[i] > 8 ? 1 : -1;
            sum += change;
            if (sum > 0) {
                ans = Math.max(ans, i + 1);
            } else if (mp.containsKey(sum - 1)) {
                ans = Math.max(ans, i - mp.get(sum - 1));
            }
            mp.putIfAbsent(sum, i);
        }
        return ans;
    }
}
