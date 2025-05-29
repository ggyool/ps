package p2901

class Solution {
    fun getWordsInLongestSubsequence(words: Array<String>, groups: IntArray): List<String> {
        val len = words.size
        val isAble = Array(len) {
            BooleanArray(len) { true }
        }
        for (i in 0..<len - 1) {
            for (j in i + 1..<len) {
                if (groups[i] == groups[j]) {
                    isAble[i][j] = false
                }
                if (words[i].length != words[j].length || hammingDistance(words[i], words[j]) != 1) {
                    isAble[i][j] = false
                }
            }
        }
        val prev = IntArray(len) { -1 }
        val dp = IntArray(len)
        dp[0] = 1
        for (i in 1..<len) {
            var maxValue = -1
            var maxIdx = -1
            for (j in 0..<i) {
                if (isAble[j][i] && maxValue < dp[j]) {
                    maxValue = dp[j]
                    maxIdx = j
                }
            }
            if (maxIdx != -1) {
                dp[i] = maxValue + 1
                prev[i] = maxIdx
            } else {
                dp[i] = 1
            }
        }
        var maxValue = -1
        var maxIdx = -1
        for (i in 0..<len) {
            if (maxValue < dp[i]) {
                maxValue = dp[i]
                maxIdx = i
            }
        }
        val lst = mutableListOf<String>()
        var i = maxIdx
        while (i != -1) {
            lst.add(words[i])
            i = prev[i]
        }
        return lst.reversed()
    }

    private fun hammingDistance(s1: String, s2: String): Int {
        var diff = 0
        for (i in s1.indices) {
            if (s1[i] != s2[i]) {
                diff++
            }
        }
        return diff
    }
}