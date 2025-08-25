package p1277

import kotlin.math.min

class Solution {
    fun countSquares(matrix: Array<IntArray>): Int {
        val r = matrix.size
        val c = matrix[0].size
        val dp = Array(r) {
            Array(c) { 0 }
        }
        for (i in 0..<r) {
            for (j in 0..<c) {
                if (i == 0 || j == 0) {
                    dp[i][j] = if (matrix[i][j] == 1) {
                        1
                    } else {
                        0
                    }
                } else if (matrix[i][j] == 1) {
                    dp[i][j] = min(dp[i - 1][j - 1], min(dp[i][j - 1], dp[i - 1][j])) + 1
                }
            }
        }
        var ret = 0
        for (i in 0..<r) {
            for (j in 0..<c) {
                ret += dp[i][j]
            }
        }
        return ret
    }
}