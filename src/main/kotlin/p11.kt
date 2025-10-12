package p11

import kotlin.math.max
import kotlin.math.min

class Solution {
    fun maxArea(height: IntArray): Int {
        var i = 0
        var j = height.size - 1
        var ret = 0
        while (i < j) {
            ret = max(ret , min(height[i], height[j]) * (j - i))
            if (height[i] < height[j]) {
                i++
            } else {
                j--
            }
        }
        return ret
    }
}