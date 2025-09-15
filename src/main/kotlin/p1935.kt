package p1935

class Solution {
    fun canBeTypedWords(text: String, brokenLetters: String): Int {
        val st = brokenLetters.toSet()
        val words = text.split(" ")
        var ret = 0
        for (word in words) {
            var temp = 1
            for (c in word) {
                if (st.contains(c)) {
                    temp = 0
                    break
                }
            }
            ret += temp
        }
        return ret
    }
}