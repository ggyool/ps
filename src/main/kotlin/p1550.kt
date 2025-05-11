package p1550

class Solution {
    fun threeConsecutiveOdds(arr: IntArray): Boolean {
        for (i in 1..<arr.size - 1) {
            if (arr[i - 1] % 2 == 1 && arr[i] % 2 == 1 && arr[i + 1] % 2 == 1) {
                return true
            }
        }
        return false
    }
}