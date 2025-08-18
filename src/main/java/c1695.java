import java.util.HashSet;
import java.util.Set;

public class c1695 {
    public int maximumUniqueSubarray(int[] nums) {
        int ans = 0;
        int sum = 0;
        Set<Integer> st = new HashSet<>();
        int i = 0;
        int j = 0;
        while (j < nums.length) {
            if (!st.contains(nums[j])) {
                sum += nums[j];
                ans = Math.max(ans, sum);
                st.add(nums[j++]);
            } else {
                sum -= nums[i];
                st.remove(nums[i++]);
            }
        }
        return ans;
    }
}
