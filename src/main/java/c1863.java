public class c1863 {
    // 첫 풀이
    public int subsetXORSum(int[] nums) {
        return pick(nums, 0, 0);
    }

    int pick(int[] nums, int idx, int tmp) {
        if (nums.length == idx) {
            return tmp;
        }
        return (pick(nums, idx + 1, tmp ^ nums[idx])) + pick(nums, idx + 1, tmp);
    }
}
