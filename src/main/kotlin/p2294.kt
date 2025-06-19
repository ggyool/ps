package p2294

class Solution {
    fun partitionArray(nums: IntArray, k: Int): Int {
        nums.sort()
        var ret = 0
        var small = -1
        for (i in nums.indices) {
            if (small == -1) {
                small = nums[i]
            } else {
                if (nums[i] - small > k) {
                    ret++
                    small = nums[i]
                }
            }
        }
        return ret + 1
    }
}