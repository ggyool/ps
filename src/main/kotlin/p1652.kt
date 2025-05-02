package p1652

fun main() {

}

// 5 7 1 4

class Solution {
    fun decrypt(code: IntArray, k: Int): IntArray {
        val ret = IntArray(code.size)
        if (k == 0) return ret
        val len = code.size
        for (i in code.indices) {
            var sum = 0
            val mult = if (k < 0) {
                -1
            } else {
                1
            }
            val iter = if (k < 0) {
                -k
            } else {
                k
            }
            for (j in 1..iter) {
                sum += code[(i + (j * mult) + len) % len]
            }
            ret[i] = sum
        }
        return ret
    }
}