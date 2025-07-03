package p3304

class Solution {
    fun kthCharacter(k: Int): Char {
        val sb = StringBuilder("a")
        while (sb.length < k) {
            val len = sb.length
            for (i in 0..<len) {
                if (sb[i] == 'z') {
                    sb.append('a')
                } else {
                    sb.append((sb[i].code + 1).toChar())
                }
            }
        }
        return sb[k-1]
    }
}