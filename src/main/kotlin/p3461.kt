package p3461

class Solution {
    fun hasSameDigits(s: String): Boolean {
        var list = s.map { it.digitToInt() }.toMutableList()
        while (list.size >= 3) {
            val tempList = mutableListOf<Int>()
            for (i in 0..<list.size - 1) {
                tempList.add((list[i] + list[i + 1]) % 10)
            }
            list = tempList
        }
        return list[0] == list[1]
    }
}