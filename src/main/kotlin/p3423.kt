package p3423

import kotlin.math.abs
import kotlin.math.max

class Solution {
    fun maxAdjacentDistance(nums: IntArray): Int {
        var ret = abs(nums.last() - nums.first())
        for (i in 1..<nums.size) {
            ret = max(ret, abs(nums[i] - nums[i-1]))
        }
        return ret
    }
}