class p1295 {
    fun findNumbers(nums: IntArray): Int {
        return nums
            .map { countDigit(it) }
            .count { it % 2 == 0 }
    }

    private fun countDigit(num: Int): Int {
        var ret = 0
        var tmp = num
        while (tmp > 0) {
            tmp /= 10
            ret++
        }
        return ret
    }
}