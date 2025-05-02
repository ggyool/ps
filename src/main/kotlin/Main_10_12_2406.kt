package Main_10_12_2406

import kotlin.math.max

// ok
fun main() {

    val intervals = arrayOf(
        intArrayOf(5, 10),
        intArrayOf(6, 8),
        intArrayOf(1, 5),
        intArrayOf(2, 3),
        intArrayOf(1, 10),
    )
    val ans = Solution().minGroups(intervals)
    println(ans)
}

class Solution {
    fun minGroups(intervals: Array<IntArray>): Int {
        val leftList = intervals.map { it[0] }.sorted()
        val rightList = intervals.map { it[1] }.sorted()
        val n  = intervals.size
        var i = 0
        var j = 0
        var cnt = 0
        var ans = 0
        while (i < n) {
            val left = leftList[i]
            val right = rightList[j]
            if (left <= right) {
                cnt++
                i++
                ans = max(ans, cnt)
            } else {
                j++
                cnt--
            }
        }
        return ans
    }
}