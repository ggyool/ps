package p1455;



class Solution {
    fun isPrefixOfWord(sentence: String, searchWord: String): Int {
        sentence.split(' ').forEachIndexed { index, word ->
            if (word.startsWith(searchWord)) {
                return index + 1
            }
        }
        return -1
    }
}

