package p1903

class Solution {
    fun largestOddNumber(num: String): String {
        var lastOddIdx = -1
        for (i in num.indices) {
            val digit = num[num.length -i -1].digitToInt()
            if (digit % 2 == 1) {
                lastOddIdx = num.length -i -1
                break
            }
        }
        if (lastOddIdx == -1) {
            return ""
        }
        return num.substring(0, lastOddIdx + 1)
    }
}