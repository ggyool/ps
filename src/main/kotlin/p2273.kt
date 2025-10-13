package p2273

class Solution {
    fun removeAnagrams(words: Array<String>): List<String> {
        fun isAnagram(a: String, b: String): Boolean {
            val listA = a.toCharArray().sorted()
            val listB = b.toCharArray().sorted()
            return listA == listB
        }

        val ret = mutableListOf<String>()
        var i = 0
        for (j in i + 1 until words.size) {
            if (!isAnagram(words[i], words[j])) {
                ret.add(words[i])
                i = j
            }
        }
        ret.add(words[i])
        return ret
    }
}