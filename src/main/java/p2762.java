import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;

public class p2762 {
    // 첫 제출
//    public long continuousSubarrays(int[] nums) {
//        long ret = 0;
//        Map<Integer, Integer> mp = new HashMap<>();
//        int i = 0;
//        int j = 0;
//        while (j < nums.length) {
//            // j를 포험시킬지 확인한다.
//            // 루프 끝나기 전 기준으로 i ~ j 범위까지 범위에 포함
//            int a = mp.getOrDefault(nums[j] - 2, 0);
//            int b = mp.getOrDefault(nums[j] - 1, 0);
//            int c = mp.getOrDefault(nums[j], 0);
//            int d = mp.getOrDefault(nums[j] + 1, 0);
//            int e = mp.getOrDefault(nums[j] + 2, 0);
//            if (i == j || a + b + c == j - i || b + c + d == j - i || c + d + e == j - i) {
//                mp.put(nums[j], mp.getOrDefault(nums[j], 0) + 1);
//                ret += (j - i + 1);
//                j++;
//            } else {
//                mp.put(nums[i], mp.get(nums[i]) - 1);
//                i++;
//            }
//        }
//        return ret;
//    }

    public long continuousSubarrays(int[] nums) {
        long ret = 0;
        var maxQ = new ArrayDeque<Integer>();
        var minQ = new ArrayDeque<Integer>();
        int i = 0;
        for (int j = 0 ; j < nums.length; ++j) {
            while (!maxQ.isEmpty() && maxQ.peekLast() <= nums[j]) {
                maxQ.pollLast();
            }
            while (!minQ.isEmpty() && minQ.peekLast() >= nums[j]) {
                minQ.pollLast();
            }
            maxQ.addLast(nums[j]);
            minQ.addLast(nums[j]);

            while (minQ.peekFirst() < maxQ.peekFirst() - 2 ) {
                
                i++;
            }

            ret += (j - i + 1);
        }
        return ret;
    }
}
