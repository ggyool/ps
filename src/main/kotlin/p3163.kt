package p3163

fun main() {


}

class Solution {
    fun compressedString(word: String): String {
        val sb = StringBuilder()
        var cnt = 1
        for (i in word.indices) {
            if (i == word.length - 1) {
                sb.append(cnt.toString())
                sb.append(word[i])
            } else if (word[i] == word[i+1]) {
                cnt++
                if (cnt == 10) {
                    cnt = 1
                    sb.append('9')
                    sb.append(word[i])
                }
            } else {
                sb.append(cnt.toString())
                sb.append(word[i])
                cnt = 1
            }
        }
        return sb.toString()
    }
}