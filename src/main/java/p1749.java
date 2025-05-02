public class p1749 {

    // 이게 된다니.. 더 절묘하다. 직관적으로 이해는 잘 안됨
    // 절대값 합의 최대화이므로 가능한듯
    // abs(minSum - maxSum) 이 같아서 maxSum - minSum
    public int maxAbsoluteSum(int[] nums) {
        int psum = 0;
        int minSum = 0;
        int maxSum = 0;
        for (int i=0; i<nums.length; i++) {
            psum += nums[i];
            minSum = Math.min(minSum, psum);
            maxSum = Math.max(maxSum, psum);
        }
        return maxSum - minSum;
    }

    // 솔루샨 풀이 보니 접근이 다르다. 절묘하게 맞아떨어진다.
    // 핵심 접근은
    // 양수일 때 psum[i] - minSum[i]이 최소값이고
    // 음수일 때는 psum[i] - maxSum[i]이 최대값이다.
//    public int maxAbsoluteSum(int[] nums) {
//        int psum = 0;
//        int minSum = 0;
//        int maxSum = 0;
//        int ans = 0;
//        for (int i=0; i<nums.length; i++) {
//            psum += nums[i];
//            minSum = Math.min(minSum, psum);
//            maxSum = Math.max(maxSum, psum);
//            if (psum >= 0) {
//                ans = Math.max(ans, psum - minSum);
//            }
//            if (psum <= 0) {
//                ans = Math.max(ans, Math.abs(psum - maxSum));
//            }
//        }
//        return ans;
//    }

    // 첫 풀이
//    public int maxAbsoluteSum(int[] nums) {
//        // i로 시작하는 가장 작은 음수와 가장 큰 음수?
//        int len = nums.length;
//        int[] minusMin = new int[len];
//        int[] plusMax = new int[len];
//        plusMax[len - 1] = Math.max(nums[len - 1], 0);
//        minusMin[len - 1] = Math.min(nums[len - 1], 0);
//        for (int i = len - 2; i >= 0; i--) {
//            plusMax[i] = Math.max(nums[i] + plusMax[i + 1], 0);
//            minusMin[i] = Math.min(nums[i] + minusMin[i + 1], 0);
//        }
//        int ans = 0;
//        for (int i = 0; i < len; i++) {
//            ans = Math.max(ans, plusMax[i]);
//            ans = Math.max(ans, -minusMin[i]);
//        }
//        return ans;
//    }
}
