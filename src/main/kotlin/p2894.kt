package p2894

class Solution {
    fun differenceOfSums(n: Int, m: Int): Int {
        var ret = 0
        for (i in 1..n) {
            if (i % m != 0){
                ret += i
            } else {
                ret -= i
            }
        }
        return ret
    }
}