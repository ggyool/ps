package p3349

class Solution {
    fun hasIncreasingSubarrays(nums: List<Int>, k: Int): Boolean {
        if (k == 1) {
            if (nums.size == 2) return true
            else return false
        }
        var inc = 1
        var cnt = 0
        for (i in 0 until nums.size - 1) {
            if (nums[i] < nums[i + 1]) {
                inc++
                if (inc == k) cnt++
            } else {
                inc = 1
            }
        }
        return cnt == 2
    }
}