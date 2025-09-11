package p2785

class Solution {
    fun sortVowels(s: String): String {
        val arr = CharArray(s.length)
        val list = mutableListOf<Char>()
        for (i in s.indices) {
            val c = s[i]
            if (isVowel(c)) {
                arr[i] = '-'
                list.add(c)
            } else {
                arr[i] = c
            }
        }
        list.sort()
        var j = 0
        for (i in arr.indices) {
            val c = arr[i]
            if (arr[i] == '-') {
                arr[i] = list[j++]
            }
        }
        return arr.concatToString()
    }

    fun isVowel(c: Char): Boolean {
        val lowerChar = c.lowercaseChar()
        return lowerChar == 'a' || lowerChar == 'e' || lowerChar == 'i' || lowerChar == 'o' || lowerChar == 'u'
    }
}