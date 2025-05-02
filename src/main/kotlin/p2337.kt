package p2337

fun main() {
    val s = Solution().canChange("LR", "LR")
    println(s)
}

class Solution {
    fun canChange(start: String, target: String): Boolean {
        if (start.length != target.length) return false
        // target 을 순회
        // L을 i에서 찾았다면 start의 다음 문자가 L이어야 하고 i보다 크거나 같은 인덱스에서 찾아야 함
        // R을 i에서 찾았다면 start의 다음 문자가 R이어야 하고 i보다 작거나 같은 읻덱스에서 찾아야 함
        var j = 0
        for (i in target.indices) {
            val c= target[i]
            if (c == 'L' || c == 'R') {
                var found: Char? = null
                while (j < start.length) {
                    if (start[j] == 'L' || start[j] == 'R') {
                        found = start[j]
                        j++
                        break
                    }
                    j++
                }
                if (found == null || c != found) {
                    return false
                }
                if (c == 'L' && j - 1 < i) {
                    return false
                }
                if (c == 'R' && j - 1  > i) {
                    return false
                }
            }
        }
        while (j < start.length) {
            if (start[j] == 'L' || start[j] == 'R') {
                return false
            }
            j++
        }
        return true
    }
}