package p1061


class Solution {
    fun smallestEquivalentString(s1: String, s2: String, baseStr: String): String {
        val isConnected = Array(26) {
            BooleanArray(26)
        }
        for (i in 0..<26) {
            isConnected[i][i] = true
        }
        for (i in s1.indices) {
            val aIdx = s1[i] - 'a'
            val bIdx = s2[i] - 'a'
            isConnected[aIdx][bIdx] = true
            isConnected[bIdx][aIdx] = true
        }
        val lexiSmall = IntArray(26) { Int.MAX_VALUE }
        for (i in 0..25) {
            val visited = BooleanArray(26)
            visited[i] = true
            lexiSmall[i] = solve(i, isConnected, visited)
        }
        val sb = StringBuilder()
        for (c in baseStr) {
            val idx = c - 'a'
            sb.append((lexiSmall[idx] + 'a'.code).toChar())
        }
        return sb.toString()
    }

    private fun solve(idx: Int, isConnected: Array<BooleanArray>, visited: BooleanArray): Int {
        var ret = idx
        for (i in 0..25) {
            if (!visited[i] && isConnected[idx][i]) {
                visited[i] = true
                ret = minOf(ret, solve(i, isConnected, visited))
            }
        }
        return ret
    }
}