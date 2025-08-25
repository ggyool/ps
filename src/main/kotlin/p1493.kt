package p1493

import kotlin.math.max

class Solution {
    fun longestSubarray(nums: IntArray): Int {
        val list = mutableListOf<Int>()
        var seq = 0
        for (num in nums) {
            if (num == 1) {
                seq++
            } else {
                if (seq != 0) {
                    list.add(seq)
                    seq = 0
                }
                list.add(seq)
            }
        }
        if (seq != 0) {
            list.add(seq)
        }

        val allOne = list.all { it > 0 }
        val allZero = list.all { it == 0 }
        if (allZero) {
            return 0
        }
        if (allOne) {
            return list.sum() - 1
        }
        if (list.size < 3) {
            return list.sum()
        }
        var ans = 0
        for (i in 1..list.size - 2) {
            ans = max(ans, list[i - 1] + list[i] + list[i + 1])
        }
        return ans
    }
}