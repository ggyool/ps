package p2097

import java.util.*

fun main() {
    val ans = Solution().validArrangement(
        arrayOf(
            intArrayOf(8, 5),
            intArrayOf(8, 7),
            intArrayOf(0, 8),
            intArrayOf(0, 5),
            intArrayOf(7, 0),
            intArrayOf(5, 0),
            intArrayOf(0, 7),
            intArrayOf(8, 0),
            intArrayOf(7, 8),
        )
    )
    for (an in ans) {
        println("${an[0]} ${an[1]}")
    }
}

class Solution {
    fun validArrangement(pairs: Array<IntArray>): Array<IntArray> {
        val edges = mutableMapOf<Int, Stack<Int>>()
        val indCount = mutableMapOf<Int, Int>()
        for (pair in pairs) {
            val from = pair[0]
            val to = pair[1]
            indCount[from] = (indCount[from] ?: 0) - 1
            indCount[to] = (indCount[to] ?: 0) + 1
            if (edges[from] == null) {
                edges[from] = Stack<Int>()
            }
            edges[from]!!.add(to)
        }
        var start = pairs[0][0]
        for ((i, cnt) in indCount) {
            if (cnt < 0) start = i
        }
        val path = mutableListOf<Int>()
        dfs(start, edges, path)
        val lst = path.reversed()
        val ans = Array(pairs.size) { intArrayOf(-1, -1) }
        for (i in 1 until lst.size) {
            ans[i - 1][0] = lst[i - 1]
            ans[i - 1][1] = lst[i]
        }
        return ans
    }

    private fun dfs(
        from: Int,
        edgesParam: MutableMap<Int, Stack<Int>>,
        path: MutableList<Int>
    ) {
        val edges = edgesParam[from] ?: Stack<Int>()
        while (edges.isNotEmpty()) {
            val to = edges.pop()
            dfs(to, edgesParam, path)
        }
        path.add(from)
    }
}