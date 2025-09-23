package p3005

import kotlin.math.max

class Solution {
    fun maxFrequencyElements(nums: IntArray): Int {
        var maxFreq = 0
        val freq = IntArray(101)
        for (num in nums) {
            freq[num]++
            maxFreq = max(freq[num], maxFreq)
        }

        var ret = 0
        for (num in 1..100) {
            if (maxFreq == freq[num]) {
                ret += freq[num]
            }
        }
        return ret
    }
}