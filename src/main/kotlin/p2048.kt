package p2048

class Solution {
    fun nextBeautifulNumber(n: Int): Int {
        for (i in n + 1..1224444) {
            if (isBalanced((i))) {
                return i
            }
        }
        return -1
    }

    fun isBalanced(n: Int): Boolean {
        var tmp = n
        val count = IntArray(7)
        while (tmp > 0) {
            val digit = tmp % 10
            if (digit >= 7) return false
            count[digit]++
            tmp /= 10
        }
        for (i in 0..6) {
            if (count[i] != 0 && count[i] != i) {
                return false
            }
        }
        return true
    }
}