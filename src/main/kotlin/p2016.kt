package p2016

class Solution {
    fun maximumDifference(nums: IntArray): Int {
        var minV = nums[0]
        var ret = -1
        for (i in 1..< nums.size) {
            if (nums[i] > minV) {
                ret = maxOf(ret, nums[i] - minV)
            }
            minV = minOf(minV, nums[i])
        }
        return ret
    }
}