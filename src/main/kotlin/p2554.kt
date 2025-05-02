package p2554

fun main() {
    Solution().maxCount(intArrayOf(1, 5, 6), 5, 6)
}

class Solution {
    fun maxCount(banned: IntArray, n: Int, maxSum: Int): Int {
        val st = banned.toSet()
        var sum = 0
        var cnt = 0
        for (i in 1..n) {
            if (sum + i > maxSum) break
            if (!st.contains(i)) {
                sum += i
                ++cnt
            }
        }
        return cnt
    }
}