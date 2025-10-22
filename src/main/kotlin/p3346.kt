package p3346

import kotlin.math.max
import kotlin.math.min

class Solution {
    fun maxFrequency(nums: IntArray, k: Int, numOperations: Int): Int {
        nums.sort()
        var minV = Int.MAX_VALUE
        var maxV = 0
        val count = IntArray(100_001)
        for (num in nums) {
            count[num]++
            minV = min(minV, num)
            maxV = max(maxV, num)
        }
        val prefixCount = IntArray(100_001)
        for (i in 1 until 100_001) {
            prefixCount[i] = count[i] + prefixCount[i - 1]
        }

        var ret = 1
        for (num in minV..maxV) {
            val start = max(num - k, 0)
            val end = min(100_000, num + k)
            val rangeCount = prefixCount[end] - prefixCount[start] + count[start]
            val exactCount = count[num]
            ret = max(ret, exactCount + min(numOperations, rangeCount - exactCount))
        }
        return ret
    }
}