public class c2873 {

    // 세번째 값을 기준으로 순회하는 답도 있음
    // i를 2부터 시작했지만 0부터 시작해도 ans에 0과 음수가 들어가서 문제 없이 동작
    public long maximumTripletValue(int[] nums) {
        int len = nums.length;
        long ans = 0;
        int diffMax = Math.max(nums[0]-nums[1], 0);
        int maxValue = Math.max(nums[0], nums[1]);
        for (int i=2; i<len; i++) {
            ans = Math.max(ans, (long)diffMax * nums[i]);
            diffMax = Math.max(diffMax, maxValue - nums[i]);
            maxValue = Math.max(maxValue, nums[i]);
        }
        return ans;
    }

    // 첫 풀이: 두번쨰 값 기준으로 순회하는 풀이
//    public long maximumTripletValue(int[] nums) {
//        int len = nums.length;
//
//        int[] rightMax = new int[len];
//        rightMax[len - 1] = nums[len - 1];
//        for (int i = len - 2; i >= 0; i--) {
//            rightMax[i] = Math.max(nums[i], rightMax[i + 1]);
//        }
//        long ans = 0;
//        int leftMax = nums[0];
//        for (int i = 1; i < len - 1; i++) {
//            ans = Math.max(ans, (leftMax - nums[i]) * (long) rightMax[i + 1]);
//            leftMax = Math.max(leftMax, nums[i]);
//        }
//        return ans;
//    }
}
