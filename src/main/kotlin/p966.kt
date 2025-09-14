package p966

class Solution {
    fun spellchecker(wordlist: Array<String>, queries: Array<String>): Array<String> {
        val correctSet = mutableSetOf<String>()
        val capitalizationMap = mutableMapOf<String, String>()
        val ignoreVowelMap = mutableMapOf<String, String>()
        for (word in wordlist) {
            correctSet.add(word)
            val lowercaseWord = word.lowercase()
            if (!capitalizationMap.containsKey(lowercaseWord)) {
                capitalizationMap.put(lowercaseWord, word)
            }
            val convertedWord = convertIgnoreVowel(word)
            if (!ignoreVowelMap.contains(convertedWord)) {
                ignoreVowelMap.put(convertedWord, word)
            }
        }

        val ret = Array<String>(queries.size) { "" }
        for (i in queries.indices) {
            val query = queries[i]
            if (correctSet.contains(query)) {
                ret[i] = query
                continue
            }
            val lowercaseQuery = query.lowercase()
            if (capitalizationMap.containsKey(lowercaseQuery)) {
                ret[i] = capitalizationMap[lowercaseQuery]!!
                continue
            }
            val key = convertIgnoreVowel(query)
            if (ignoreVowelMap.containsKey(key)) {
                ret[i] = ignoreVowelMap[key]!!
                continue
            }
        }
        return ret
    }

    fun convertIgnoreVowel(s: String): String {
        val sb = StringBuilder()
        for (c in s) {
            if (isVowel(c)) {
                sb.append('-')
            } else {
                sb.append(c.lowercaseChar())
            }
        }
        return sb.toString()
    }

    fun isVowel(c: Char): Boolean {
        val ch = c.lowercaseChar()
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'
    }
}