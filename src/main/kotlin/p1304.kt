package p1304

class Solution {
    fun sumZero(n: Int): IntArray {
        val arr = IntArray(n)
        var sum = 0
        for (i in 0..n - 2) {
            arr[i] = i + 1
            sum += i + 1
        }
        arr[n-1] = -sum
        return arr
    }
}