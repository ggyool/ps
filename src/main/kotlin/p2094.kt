package p2094

class Solution {
    fun findEvenNumbers(digits: IntArray): IntArray {
        val lst = mutableListOf<Int>()
        val cnt = IntArray(10) { 0 }
        for (digit in digits) {
            cnt[digit]++
        }
        for (i in 1..9) {
            if (cnt[i] == 0) continue
            cnt[i]--
            for (j in 0..9) {
                if (cnt[j] == 0) continue
                cnt[j]--
                for (k in 0..9 step 2) {
                    if (cnt[k] == 0) continue
                    lst.add(i * 100 + j * 10 + k)
                }
                cnt[j]++
            }
            cnt[i]++
        }
        return lst.toIntArray()
    }
}