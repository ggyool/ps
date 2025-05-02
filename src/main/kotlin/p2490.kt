package p2490

fun main() {

}

class Solution {
    fun isCircularSentence(sentence: String): Boolean {
        val lst = sentence.split(' ')
        if (lst.size == 1) {
            val word = lst[0]
            return word.first() == word.last()
        }
        for (i in 1..<lst.size) {
            if (lst[i - 1].last() != lst[i].first()) {
                return false
            }
        }
        return lst[lst.size - 1].last() == lst[0].first()
    }
}