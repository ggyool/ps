public class c2529 {
    public int maximumCount(int[] nums) {
        int posCnt = 0;
        int negCnt = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) negCnt++;
            if (nums[i] > 0) posCnt++;
        }
        return Math.max(negCnt, posCnt);
    }
}
