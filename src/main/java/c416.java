import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class c416 {

    // gpt dp 풀이
    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 != 0) return false;
        int target = sum / 2;

        boolean[] dp = new boolean[target + 1];
        dp[0] = true;

        for (int num : nums) {
            for (int i = target; i >= num; i--) {
                dp[i] = dp[i] || dp[i - num];
            }
        }
        return dp[target];
    }

    // dp로 풀어본 풀이
//    public boolean canPartition(int[] nums) {
//        int len = nums.length;
//        int sum = 0;
//        for (int i=0; i<len; i++) {
//            sum += nums[i];
//        }
//        if (sum%2==1) return false;
//        int target = sum / 2;
//        boolean[] dp = new boolean[target+1];
//        for (int i=0; i<len; i++) {
//            int num = nums[i];
//            for (int j=target; j>=num; j--) {
//                if (dp[j-num]) {
//                    dp[j] = true;
//                }
//            }
//            if (num<=target) dp[num] = true;
//        }
//        return dp[target];
//    }

    // 첫 풀이: n이 200이라 통과는 하지만 꽤 느림
//    public boolean canPartition(int[] nums) {
//        // 문제 조건이 다 사용해야하는구나
//        // 전체 합 구하고 짝수면 /2 값을 만들 수 있는지 체크
//        int len = nums.length;
//        int sum = 0;
//        for (int i = 0; i < len; i++) {
//            sum += nums[i];
//        }
//        if (sum % 2 == 1) return false;
//        int target = sum / 2;
//        Set<Integer> sumSet = new HashSet<>();
//        for (int i = 0; i < len; i++) {
//            Set<Integer> tmp = new HashSet<>();
//            tmp.add(nums[i]);
//            for (Integer num : sumSet) {
//                tmp.add(num + nums[i]);
//            }
//            sumSet.addAll(tmp);
//        }
//        return sumSet.contains(target);
//    }
}
