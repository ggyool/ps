package p3370

class Solution {
    fun smallestNumber(n: Int): Int {
        var tmp = 1
        while (tmp - 1 <  n) {
            tmp *= 2
        }
        return tmp - 1
    }
}