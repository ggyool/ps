package p2749

class Solution {
    fun makeTheIntegerZero(num1: Int, num2: Int): Int {
        // n1 - (2**a + n2) - (2**b + n2) - (2**c * n2) ... = 0
        // n1 - k*n2 = 2**a + 2**b + 2**c...
        // 즉 n1 - k*n2를 k개의 2의 거듭제곱의 합으로 나타낼 수 있는지
        for (k in 1..60) {
            val target = num1.toLong() - k * num2.toLong()
//            if (isAble(target, k)) {
//                return k
//            }
            if (k in target.countOneBits()..target) {
                return k
            }
        }
        return -1
    }

    // 9의 경우 나타낼 수 있는 2진수의 합이 (1001)
    // 최소 2개의 2진수의 합이 필요하고
    // 최대 9개 (2**0 9개) 가능
    fun isAble(target: Long, k: Int): Boolean{
        var minCnt = 0
        var tmp = target
        while (tmp > 0) {
            if (tmp % 2 == 1L) {
                minCnt++
            }
            tmp /= 2
        }
        return k in minCnt..target
    }
}