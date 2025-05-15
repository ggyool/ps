package p2900

class Solution {
    fun getLongestSubsequence(words: Array<String>, groups: IntArray): List<String> {
        var cur = -1
        val ans = mutableListOf<String>()
        for (i in words.indices) {
            if (cur != groups[i]) {
                cur = groups[i]
                ans.add(words[i])
            }
        }
        return ans
    }
}