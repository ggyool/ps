package p2275


fun main() {
    val ans = Solution().largestCombination(intArrayOf(16, 17, 71, 62, 12, 24, 14))
    println(ans)
}

class Solution {
    fun largestCombination(candidates: IntArray): Int {
        val cnt = IntArray(100)
        for (num in candidates) {
            var i = 0
            var tmp = num
            while (tmp > 0) {
                if (tmp % 2 == 1) cnt[i] += 1
                tmp /= 2
                i++
            }
        }
        return cnt.max()
    }
}
