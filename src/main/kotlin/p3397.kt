package p3397

import kotlin.math.max

class Solution {
    fun maxDistinctElements(nums: IntArray, k: Int): Int {
        val list = nums.sorted()
        var usedCount = 0
        var recentUsed = Int.MIN_VALUE
        for (num in list) {
            val testValue = max(recentUsed + 1, num - k)
            if (testValue >= num - k && testValue <= num + k) {
                usedCount++
                recentUsed = testValue
            }
        }
        return usedCount
    }
}