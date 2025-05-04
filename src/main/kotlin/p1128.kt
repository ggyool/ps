package p1128

class Solution {
    fun numEquivDominoPairs(dominoes: Array<IntArray>): Int {
        var ans = 0
        val cnt = mutableMapOf<Pair, Int>()
        for (domino in dominoes) {
            val pair = if (domino[0] > domino[1]) {
                Pair(domino[1], domino[0])
            } else {
                Pair(domino[0], domino[1])
            }
            cnt.compute(pair) { key, oldValue ->
                oldValue?.let {
                    ans += it
                    it.inc()
                } ?: 1
            }
        }
        return ans
    }

    data class Pair(
        val a: Int,
        val b: Int,
    )
}