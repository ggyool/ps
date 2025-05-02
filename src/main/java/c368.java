import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class c368 {

    // 이전 인덱스 기억하는 방법
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        int[] dp = new int[len];
        int[] prevIdx = new int[len];
        dp[0] = 1;
        prevIdx[0] = 0;
        int maxIdx = 0;
        int maxCnt = 0;
        for (int i=1; i<len; i++) {
            int num = nums[i];
            dp[i] = 1;
            prevIdx[i] = i;
            for (int j=0; j<i; j++) {
                if (num % nums[j] == 0 && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                    prevIdx[i] = j;
                }
            }
            if (dp[i] > maxCnt) {
                maxCnt = dp[i];
                maxIdx = i;
            }
        }
        List<Integer> ret = new ArrayList<>();
        int idx = maxIdx;
        while(idx != prevIdx[idx]) {
            ret.add(nums[idx]);
            idx = prevIdx[idx];
        }
        ret.add(nums[idx]);
        return ret;
    }
    
    // 첫 풀이
//    public List<Integer> largestDivisibleSubset(int[] nums) {
//        Arrays.sort(nums);
//        int len = nums.length;
//        int[] dp = new int[len];
//        dp[0] = 1;
//        int maxValue = 0;
//        int maxIdx = 0;
//        for (int i = 1; i < len; i++) {
//            int num = nums[i];
//            dp[i] = 1;
//            for (int j = 0; j < i; j++) {
//                if (num % nums[j] == 0) {
//                    dp[i] = Math.max(dp[i], dp[j] + 1);
//                }
//            }
//            if (dp[i] > maxValue) {
//                maxValue = dp[i];
//                maxIdx = i;
//            }
//        }
//        List<Integer> ret = new ArrayList<>();
//        ret.add(nums[maxIdx]);
//        int idx = maxIdx - 1;
//        int cnt = maxValue - 1;
//        int target = nums[maxIdx];
//        while (cnt > 0) {
//            if (target % nums[idx] == 0 && dp[idx] == cnt) {
//                ret.add(nums[idx]);
//                target = nums[idx];
//                cnt--;
//            }
//            idx--;
//        }
//        return ret;
//    }
}
