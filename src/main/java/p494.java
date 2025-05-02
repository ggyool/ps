import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class p494 {

    public int findTargetSumWays(int[] nums, int target) {
        Map<Pair, Integer> cache = new HashMap<>();
        return dfs(0, nums, 0, target, cache);
    }

    private int dfs(int i, int[] nums, int sum, int target, Map<Pair, Integer> cache) {
        var key = new Pair(i, sum);
        var value = cache.get(key);
        if (value != null) {
            return value;
        }
        if (i == nums.length) {
            if (sum == target) {
                return 1;
            } else {
                return 0;
            }
        }
        int res = dfs(i + 1, nums, sum + nums[i], target, cache) + dfs(i + 1, nums, sum - nums[i], target, cache);
        cache.put(key, res);
        return res;
    }

    private record Pair(int i, int sum) {
    }
}
