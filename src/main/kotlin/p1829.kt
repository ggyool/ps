package p1829

import kotlin.math.pow

class Solution {
    fun getMaximumXor(nums: IntArray, maximumBit: Int): IntArray {
        val maxValue = (2.0.pow(maximumBit) - 1).toInt()
        val ret = IntArray(nums.size)
        var tmp = 0
        for (i in nums.indices) {
            tmp = tmp xor nums[i]
        }
        for (i in nums.indices) {
            ret[i] = maxValue xor tmp
            tmp = tmp xor nums[nums.size - i - 1]
        }
        return ret
    }
}