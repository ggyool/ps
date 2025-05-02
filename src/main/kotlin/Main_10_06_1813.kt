fun main() {
    val s1 = "A A"
    val s2 = "A aA"
    println(Solution().areSentencesSimilar(s1, s2))
}

// 접근:
// 3가지 케이스가 있는 것 같다.
// 1. 짧은 문장이 접두사
// 2. 짧은 문장이 접미사
// 3. 짤은 문장을 쪼개면 접두 + 접미사
class Solution {
    fun areSentencesSimilar(sentence1: String, sentence2: String): Boolean {
        var short = sentence1
        var long = sentence2
        if (sentence1.length > sentence2.length) {
            short = sentence2
            long = sentence1
        }
        if (short == long) return true
        if (long.startsWith(short)) {
            val idx = long.indexOf(short) + short.length
            if (long[idx] == ' ') return true
        }
        if (long.endsWith(short)) {
            val idx = long.lastIndexOf(short) - 1
            if(long[idx] == ' ') return true
        }
        if (long.startsWith(short) || long.endsWith(short)) return false

        val blankIndices = mutableListOf<Int>()
        for (i in short.indices) {
            val c = short[i]
            if (c == ' ') {
                blankIndices.add(i)
            }
        }
        for (i in blankIndices) {
            val left = short.substring(0, i).trim()
            val right = short.substring(i + 1).trim()
            if (long.startsWith(left) && long.endsWith(right)) {
                val idx1 = long.indexOf(left) + left.length
                val idx2 = long.lastIndexOf(right) - 1
                return long[idx1] == ' ' && long[idx2] == ' '
            }
        }
        return false
    }
}

