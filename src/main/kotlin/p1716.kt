package p1716

class Solution {
    fun totalMoney(n: Int): Int {
        var ret = 0
        for (i in 0 until n) {
            ret += (i % 7) + (i / 7 + 1)
        }
        return ret
    }
}