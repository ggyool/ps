package p120

import kotlin.math.min

class Solution {

    fun minimumTotal(triangle: List<List<Int>>): Int {
        val blank = 1_000_000
        val h = triangle.size
        val w = triangle.last().size * 2 - 1
        val arr = Array(h) {
            IntArray(w) { blank }
        }
        var leftBlankSize = w / 2
        for (i in 0..<h) {
            var idx = 0
            for (j in leftBlankSize..<w step 2) {
                arr[i][j] = triangle[i][idx++]
                if (idx == triangle[i].size) break
            }
            leftBlankSize--
        }

        val dp = Array(h) {
            IntArray(w) { Int.MIN_VALUE }
        }

        fun go(y: Int, x: Int): Int {
            if (y >= h) return 0
            if (dp[y][x] != Int.MIN_VALUE) return dp[y][x]
            val left = go(y + 1, x - 1) + arr[y][x]
            val right = go(y + 1, x + 1) + arr[y][x]
            dp[y][x] = min(left, right)
            return dp[y][x]
        }
        return go(0, w / 2)
    }
}

fun main() {
    val list = listOf(
        listOf(2),
        listOf(3, 4),
        listOf(6, 5, 7),
        listOf(4, 1, 8, 3)
    )
    val abc = Solution().minimumTotal(list)
    println(abc)
}