package p3372

class Solution {
    fun maxTargetNodes(edges1: Array<IntArray>, edges2: Array<IntArray>, k: Int): IntArray {
        val adj1 = List(edges1.size + 1) { mutableListOf<Int>() }
        val adj2 = List(edges2.size + 1) { mutableListOf<Int>() }
        for (edge in edges1) {
            adj1[edge[0]].add(edge[1])
            adj1[edge[1]].add(edge[0])
        }
        for (edge in edges2) {
            adj2[edge[0]].add(edge[1])
            adj2[edge[1]].add(edge[0])
        }
        val kCount = Array(adj1.size) { 0 }
        for (i in adj1.indices) {
            val dist = MutableList(adj1.size) { -1 }
            dist[i] = 0
            dfs(i, i, adj1, k, dist, kCount)
        }
        val kCount2 = Array(adj2.size) { 0 }
        for (i in adj2.indices) {
            val dist = MutableList(adj2.size) { -1 }
            dist[i] = 0
            // k -1
            dfs(i, i, adj2, k - 1, dist, kCount2)

        }
        var maxValue = 0
        for (i in adj2.indices) {
            maxValue = Math.max(maxValue, kCount2[i])
        }
        val ans = IntArray(adj1.size)
        for (i in adj1.indices) {
            ans[i] = kCount[i] + maxValue
        }
        return ans
    }

    fun dfs(
        start: Int,
        cur: Int,
        adj: List<MutableList<Int>>,
        k: Int,
        dist: MutableList<Int>,
        kCount: Array<Int>
    ) {
        if (dist[cur] <= k) {
            kCount[start] += 1
        }
        val edges = adj[cur]
        for (next in edges) {
            if (dist[next] == -1) {
                dist[next] = dist[cur] + 1
                if (dist[next] <= k) {
                    dfs(start, next, adj, k, dist, kCount)
                }
            }
        }
    }
}