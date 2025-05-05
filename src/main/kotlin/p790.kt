package p790

class Solution {
    // 첫 풀이
    // 정해의 점화식은 dp[n] = 2 * dp[n-1] + dp[n-3] 이거임
    fun numTilings(n: Int): Int {
        if (n <= 2) return n

        val MOD = 1_000_000_007
        val dp = IntArray(n+1)
        val up = IntArray(n+1)
        val down = IntArray(n+1)
        dp[1] = 1
        dp[2] = 2
        up[2] = 1
        down[2] = 1
        for (i in 3 .. n) {
            // 세로로 하나
            dp[i] += dp[i-1]
            dp[i] %= MOD

            // 가로로 두개
            dp[i] += dp[i-2]
            dp[i] %= MOD

            // 아래 튀어나온 닫는 모양
            dp[i] += up[i-1]
            dp[i] %= MOD

            // 위 튀어나온 닫는 모양
            dp[i] += down[i-1]
            dp[i] %= MOD

            // 위 튀어나온 여는 모양
            up[i] += dp[i-2]
            up[i] %= MOD

            // 아래 티어나온 여는 모양
            down[i] += dp[i-2]
            down[i] %= MOD

            // 아래 가로로 하나
            down[i] += up[i-1]
            down[i] %= MOD

            // 위 가로로 하나
            up[i] += down[i-1]
            up[i] %= MOD
        }
        return dp[n]
    }
}