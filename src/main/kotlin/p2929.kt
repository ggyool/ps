package p2929

import kotlin.math.min

fun main() {
    println(Solution().distributeCandies(1, 3))
}

class Solution {
    fun distributeCandies(n: Int, limit: Int): Long {
        var ret = 0L
        val max = min(limit, n)
        for (i in 0..max) {
            val remain = n - i
            val a = min(remain, limit)
            val b = remain - a
            if (a >= b) {
                ret += (a-b) + 1
            }
        }
        return ret
    }
}