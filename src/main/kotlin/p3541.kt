package p3541

class Solution {
    fun maxFreqSum(s: String): Int {
        val mp = s.groupingBy {it}.eachCount()
        var a = 0
        var b = 0
        for ((c, v) in mp) {
            if (isVowel(c) && a < v) {
                a = v
            }
            if (!isVowel(c) && b < v) {
                b = v
            }
        }
        return a + b
    }

    fun isVowel(c: Char): Boolean {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'
    }
}