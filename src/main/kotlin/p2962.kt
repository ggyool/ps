package p2962

class Solution {
    fun countSubarrays(nums: IntArray, k: Int): Long {
        var ans = 0L
        val maxVal = nums.max()
        var cnt = 0
        var j = 0
        for (i in nums.indices) {
            while (j < nums.size && cnt < k) {
                if (nums[j] == maxVal) {
                    cnt++;
                }
                j++
            }
            if (cnt >= k){
                ans += nums.size - j + 1
            }
            if (nums[i] == maxVal) {
                cnt--
            }
        }
        return ans
    }
}