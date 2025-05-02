package p3243;

fun main() {

}

class Solution {
    fun shortestDistanceAfterQueries(n: Int, queries: Array<IntArray>): IntArray {
        val mp = mutableMapOf<Int, MutableSet<Int>>().apply {
            for (i in 0 until n) {
                val st = mutableSetOf<Int>()
                if (i != n - 1) st.add(i + 1)
                this[i] = st
            }
        }
        val ans = IntArray(queries.size)
        for (i in queries.indices) {
            val query = queries[i]
            val from = query[0]
            val to = query[1]
            mp[from]!!.add(to)
            ans[i] = bfs(mp, n)
        }
        return ans
    }

    private fun bfs(mp: MutableMap<Int, MutableSet<Int>>, n: Int): Int {
        val visited = BooleanArray(n)
        visited[0] = true
        val q = ArrayDeque<Int>()
        var ret = 0
        q.add(0)
        while (!q.isEmpty()) {
            val thisTurnSize = q.size
            for (i in 0 until thisTurnSize) {
                val cur = q.removeFirst()
                if (cur == n - 1) {
                    return ret
                }
                val nexts = mp[cur]!!
                for (next in nexts) {
                    if (visited[next]) continue
                    visited[next] = true
                    q.add(next)
                }
            }
            ++ret
        }
        return -1
    }
}