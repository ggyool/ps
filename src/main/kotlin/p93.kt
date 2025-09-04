package p93

class Solution {
    fun restoreIpAddresses(s: String): List<String> {
        val ret = mutableListOf<String>()
        val list = mutableListOf<String>()
        fun recur(idx: Int, s: String) {
            if (idx == s.length) {
                if (list.size == 4) {
                    ret.add(list.joinToString("."))
                }
                return
            }
            for (i in 1..3) {
                if (idx <= s.length - i) {
                    val slice = s.substring(idx, idx + i)
                    if (isValidSlice((slice))) {
                        list.add(slice)
                        recur(idx + i, s)
                        list.removeLast()
                    }
                }
            }
        }
        recur(0, s)
        return ret
    }

    fun isValidSlice(s: String): Boolean {
        if (s == "0") {
            return true
        }
        if (s.startsWith("0")) {
            return false
        }
        val n = s.toInt()
        if (n <= 255) {
            return true
        }
        return false
    }
}