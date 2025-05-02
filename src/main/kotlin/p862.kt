package p862

fun main() {

}

class Solution {
    fun shortestSubarray(nums: IntArray, k: Int): Int {
        var left = 0
        var right = -1
        val len = nums.size
        var sum = 0L
        while (true) {
            if (right != len - 1 && sum < k) {
                ++right
                sum += nums[right]
            }
        }
    }
}