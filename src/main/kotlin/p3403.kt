package p3403

class Solution {

    //  editorial 1번 풀이
    fun answerString(word: String, numFriends: Int): String {
        if (numFriends == 1) return word
        val n = word.length
        var res = ""
        for (i in 0 until n) {
            val end = minOf(i + n - numFriends + 1, n)
            val s = word.substring(i, end)
            if (res < s) {
                res = s
            }
        }
        return res
    }

    // 첫 풀이: 너무 복잡하게 품
//    fun answerString(word: String, numFriends: Int): String {
//        if (numFriends == 1) {
//            return word
//        }
//
//        var maxCode= 'a'.code - 1
//        for (c in word) {
//            maxCode = max(maxCode, c.code)
//        }
//        var lst = mutableListOf<Pair<Int, Int>>()
//        for (i in word.indices) {
//            if (word[i].code == maxCode) {
//                lst.add(Pair(i, i))
//            }
//        }
//        while (lst.size > 1) {
//            val remainLength = word.length - lst[0].second + lst[0].first + 1
//            if (remainLength <= numFriends - 1) break
//            var maxNextCode = 'a'.code - 1
//            val tmp = mutableListOf<Pair<Int, Int>>()
//            for (pair in lst) {
//                val nextIdx = pair.second + 1
//                if (nextIdx == word.length) continue
//                maxNextCode = max(maxNextCode, word[nextIdx].code)
//            }
//            for (pair in lst) {
//                val nextIdx = pair.second + 1
//                if (nextIdx == word.length) continue
//                if (maxNextCode == word[nextIdx].code) {
//                    tmp.add(Pair(pair.first, nextIdx))
//                }
//            }
//            lst = tmp
//        }
//        val frontPieces = Math.min(lst[0].first, numFriends - 1)
//        val backPieces = numFriends - frontPieces - 1
//        return word.substring(lst[0].first, word.length - backPieces)
//    }
}
