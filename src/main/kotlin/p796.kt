package p796

fun main() {

}

class Solution {
    fun rotateString(s: String, goal: String): Boolean {
        for (i in s.indices) {
            if (s.substring(i) + s.substring(0, i) == goal)
                return true
        }
        return false
    }
}