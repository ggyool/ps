package p3442

class Solution {
    fun maxDifference(s: String): Int {
        val cntMap = mutableMapOf<Char, Int>()
        for (c in s) {
            cntMap.compute(c) { k, v ->
                if (v == null) {
                    1
                } else {
                    v + 1
                }
            }
        }
        var maxOddCnt = 0
        var minEvenCnt = 101
        for ((k, v) in cntMap) {
            if (v % 2 == 1 && v > maxOddCnt) {
                maxOddCnt = v
            } else if ((v % 2 == 0 && v < minEvenCnt)) {
                minEvenCnt = v
            }
        }
        return maxOddCnt - minEvenCnt
    }
}