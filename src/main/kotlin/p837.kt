package p837

fun main() {
    System.out.println(Solution().new21Game(21, 17, 10))
}

class Solution {
    fun new21Game(n: Int, k: Int, maxPts: Int): Double {
        val dp = DoubleArray(n + 1) {
            0.0
        }
        dp[0] = 1.0

        var slideSum = 0.0
        for (i in 1..n) {
            if (i - 1 >= 0 && i - 1 < k) {
                slideSum += dp[i - 1] / maxPts
            }
            if (i -1 - maxPts >= 0 && i-1-maxPts < k) {
                slideSum -= dp[i - 1 - maxPts] / maxPts
            }
            dp[i] = slideSum
        }

        var ret = 0.0
        for (i in k..n) {
            ret += dp[i]
        }
        return ret
    }
}