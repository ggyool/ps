package p2138

class Solution {

    fun divideString(s: String, k: Int, fill: Char): Array<String> {
        val arr = Array((s.length - 1) / k + 1) {
            StringBuilder()
        }
        for (i in s.indices) {
            arr[i / k].append(s[i])
        }
        while (arr.last().length < k) {
            arr.last().append(fill)
        }
        return arr.map { it.toString() }.toTypedArray()
    }

//    fun divideString(s: String, k: Int, fill: Char): Array<String> {
//        val chunked = s.chunked(k).toMutableList()
//        while (chunked.last().length < k) {
//            chunked[chunked.size - 1] = chunked.last() + fill
//        }
//        return chunked.toTypedArray()
//    }
}