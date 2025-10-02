package p2221

class Solution {
    fun triangularSum(nums: IntArray): Int {
        var lastIndex = nums.size - 2
        while (lastIndex >= 0) {
            for (i in 0..lastIndex) {
                nums[i] = (nums[i] + nums[i + 1]) % 10
            }
            lastIndex--
        }
        return nums[0]
    }
}