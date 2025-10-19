package p1625

class Solution {

    val set = mutableSetOf<String>()

    fun findLexSmallestString(s: String, a: Int, b: Int): String {
        recur(s, a, b)
        return set.sorted().first()
    }

    fun recur(s: String, a: Int, b: Int) {
        val addString = add(s, a)
        if (!set.contains(addString)) {
            set.add(addString)
            recur(addString, a, b)
        }
        val rotateString = rotate(s, b)
        if (!set.contains(rotateString)) {
            set.add(rotateString)
            recur(rotateString, a, b)
        }
    }

    fun add(s: String, a: Int): String {
        val arr = s.toCharArray()
        for (i in 1 until s.length step 2) {
            arr[i] = '0' + ((arr[i] - '0' + a) % 10)
        }
        return String(arr)
    }

    fun rotate(s: String, b: Int): String {
        val len = s.length
        return s.slice(len - b..<len) + s.slice(0 until len - b)
    }
}