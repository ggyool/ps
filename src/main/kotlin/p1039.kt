package p1039

import kotlin.math.min

class Solution {
    fun minScoreTriangulation(values: IntArray): Int {
        val dp = Array(values.size) {
            IntArray(values.size) {
                -1
            }
        }

        // i,j 변 k점을 선택
        fun run(i: Int, j: Int): Int {
            if (j - i == 1) {
                return 0
            }
            if (dp[i][j] != -1) {
                return dp[i][j]
            }
            var ret = Int.MAX_VALUE
            for (k in i + 1 until j) {
                ret = min(ret, run(i, k) + run(k, j) + values[i] * values[j] * values[k])
            }
            dp[i][j] = ret
            return ret
        }
        return run(0, values.size - 1)
    }
}