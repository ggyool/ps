package p3354

class Solution {
    fun countValidSelections(nums: IntArray): Int {
        var ret = 0
        val sum = nums.sum()
        var leftSum = 0
        for (num in nums) {
            if (num == 0) {
                val rightSum = sum - leftSum
                if (leftSum == rightSum) {
                    ret += 2
                } else if (leftSum == rightSum + 1) {
                    ret++
                } else if (rightSum == leftSum + 1) {
                    ret++
                }
            } else {
                leftSum += num
            }
        }
        return ret
    }
}