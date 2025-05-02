package p2601


fun main() {
    Solution().primeSubOperation(intArrayOf(4,9,6,10))
}

class Solution {
    fun primeSubOperation(nums: IntArray): Boolean {
        val lst = nums.toMutableList()
        val isPrime = BooleanArray(1001) { true }
        isPrime[0] = false
        isPrime[1] = false
        var i = 2
        while (i * i <= 1000) {
            if (isPrime[i]) {
                for (j in i * i..1000 step i) {
                    isPrime[j] = false
                }
            }
            i++
        }

        for (i in lst.indices) {
            val bef = if (i == 0) {
                0
            } else {
                lst[i - 1]
            }
            // bef + 1 < target < lst[i]
            for (j in bef + 1..lst[i] - 1){
                if (isPrime[lst[i] - j]) {
                    lst[i] = j
                    break
                }
            }
        }

        if (lst.size == 1) return true
        for (i in 1 until lst.size) {
            if (lst[i - 1] >= lst[i]) return false
        }
        return true
    }
}