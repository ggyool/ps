package p2981

fun main() {
    Solution().maximumLength("cccerrrecdcdccedecdcccddeeeddcdcddedccdceeedccecde")

}

class Solution {
    fun maximumLength(s: String): Int {
        val mp = mutableMapOf<String, Int>()
        for (i in 0 until s.length) {
            val sb = StringBuilder()
            for (j in i  until s.length) {
                if (s[i] != s[j]) break
                sb.append(s[j])
                mp.compute(sb.toString()) { key, value  ->
                    if (value == null) 1
                    else value + 1
                }
            }
        }
        var ans = -1
        for ((key, value) in mp) {
            if (value >= 3 && ans < key.length) {
                ans = key.length
                println(key)
                println(value)
            }
        }
        return ans
    }
}
