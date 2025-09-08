package p1317

class Solution {
    fun getNoZeroIntegers(n: Int): IntArray {
        val arr = IntArray(2)
        for (a in 1..n/2) {
            val b = n - a
            if (!a.toString().contains("0") && !b.toString().contains("0")) {
                arr[0] = a
                arr[1] = b
                break
            }
        }
        return arr
    }
}