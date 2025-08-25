package p2264

class Solution {
    fun largestGoodInteger(num: String): String {
        var ans = ""
        var max = -1
        for (i in 1..num.length - 2) {
            if (num[i - 1] == num[i] && num[i] == num[i + 1]) {
                val tmp = "" + num[i - 1] + num[i] + num[i + 1]
                if (max < tmp.toInt()) {
                    max = tmp.toInt()
                    ans = tmp
                }
            }
        }
        return ans
    }
}