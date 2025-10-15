package p3350

import kotlin.math.max
import kotlin.math.min

class Solution {
    fun maxIncreasingSubarrays(nums: List<Int>): Int {
        var ret = 1
        var befInc = 0
        var inc = 1
        for (i in 0 until nums.size - 1) {
            if (nums[i] < nums[i + 1]) {
                inc++
                // 하나를 반반 쪼개거나
                ret = max(ret, inc / 2)
                // 연속된 두개의 증가를 사용하거나
                ret = max(ret, min(inc, befInc))
            } else {
                befInc = inc
                inc = 1
            }
        }
        return ret
    }
}