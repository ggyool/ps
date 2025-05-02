package p2825

fun main() {
    println('c'.code.toChar())
}

class Solution {
    fun canMakeSubsequence(str1: String, str2: String): Boolean {
        var j = 0
        for (i in str1.indices) {
            if (j == str2.length) return true
            val c = str2[j]
            if (str1[i] == c || ((str1[i].code + 1 - 'a'.code) % 26 + 'a'.code).toChar() == c) {
                ++j
            }
        }
        return j == str2.length
    }
}