package p2914

import kotlin.math.min

fun main() {
    val ans = Solution().minChanges("11000111")
    println(ans)
}

class Solution {
    fun minChanges(s: String): Int {
        var ans = 0
        for (i in 1 ..< s.length step 2) {
            if (s[i] != s[i-1]) ans++
        }
        return ans
    }
}