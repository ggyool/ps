package p1578

import kotlin.math.max

class Solution {
    fun minCost(colors: String, neededTime: IntArray): Int {
        var ret = 0
        var sum = 0
        var big = 0
        var checkColor: Char = '-'
        for (i in colors.indices) {
            val color = colors[i]
            if (color == checkColor) {
                sum += neededTime[i]
                big = max(big, neededTime[i])
            } else {
                if (sum != big) {
                    ret += sum - big
                }
                sum = neededTime[i]
                big = neededTime[i]
                checkColor = color
            }
        }
        if (sum != big) {
            ret += sum - big
        }
        return ret
    }
}