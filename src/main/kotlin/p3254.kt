package p3254

fun main() {

}

class Solution {
    fun resultsArray(nums: IntArray, k: Int): IntArray {
        if (k == 1) {
            return nums
        }
        val n = nums.size
        val ret = IntArray(n - k + 1) { -1 }

        var left = 0
        var right = 0
        while (right < n - 1) {
            if (nums[right] + 1 == nums[right + 1]) {
                right++
                if (right - left + 1 == k) {
                    ret[right - k + 1] = nums[right]
                    left++
                }
            } else {
                right++
                left = right
            }
        }
        return ret
    }
}