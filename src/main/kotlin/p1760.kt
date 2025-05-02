package p1760

import kotlin.math.max

fun main() {
    val ans = Solution().minimumSize(intArrayOf(1), 1)
    println(ans)
}

class Solution {
    // 큰 숫자를 선택하면 당연히 가능하다. -> 탐색 범위를 왼쪽으로 줄인다.
    // 작은 숫자를 선택하면 불가능 하다. (Operation이 max를 넘으면 불가능) -> 탐색 범위를 오른쪽으로 줄인다.
    // 가능한 가장 작은 숫자를 찾는다.
    fun minimumSize(nums: IntArray, maxOperations: Int): Int {
        var ans = Int.MAX_VALUE
        val lst = nums.toList().sorted()
        var left = 1
        var right = lst.last()
        while (left <= right) {
            var mid = (left + right) / 2
            if (isAble(lst, mid, maxOperations)) {
                right = mid - 1
                ans = minOf(ans, mid)
            } else {
                left = mid + 1
            }
        }
        return ans
    }

    private fun isAble(lst: List<Int>, target: Int, maxOperations: Int): Boolean {
        var opCnt = 0
        for (i in lst.indices) {
            val ri = lst.size - i - 1
            val num = lst[ri]
            if (num <= target) break
            if (num % target == 0) {
                opCnt += (num / target -1)
            } else {
                opCnt += (num / target)
            }
        }
        return opCnt <= maxOperations
    }
}