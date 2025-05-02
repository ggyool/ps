import java.util.List;

public class c2874 {
    public long maximumTripletValue(int[] nums) {
        int len = nums.length;
        int diffMax = 0;
        int maxValue = 0;
        long ans = 0;
        for (int i = 0; i < len; i++) {
            ans = Math.max(ans, (long) diffMax * nums[i]);
            diffMax = Math.max(diffMax, maxValue - nums[i]);
            maxValue = Math.max(maxValue, nums[i]);
        }
        List<Integer> lst;
        return ans;
    }
}
