package p2348

class Solution {
    fun zeroFilledSubarray(nums: IntArray): Long {
        var cur = 0
        var ans = 0L
        for (num in nums) {
            if (num == 0) {
                cur++
                ans += cur
            } else {
                cur = 0
            }
        }
        return ans
    }
}