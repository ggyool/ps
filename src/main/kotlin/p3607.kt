package p3607

import java.util.TreeSet

class Solution {
    fun processQueries(c: Int, connections: Array<IntArray>, queries: Array<IntArray>): IntArray {
        val adj = Array(c + 1) {
            mutableListOf<Int>()
        }
        for (con in connections) {
            val a = con[0]
            val b = con[1]
            adj[a].add(b)
            adj[b].add(a)
        }

        val groupNums = IntArray(c + 1)
        val treeSets = mutableListOf<TreeSet<Int>>()
        val visited = BooleanArray(c + 1)
        var groupNum = 0

        fun dfs (cur: Int) {
            val nexts = adj[cur]
            for (next in nexts) {
                if (!visited[next]) {
                    visited[next] = true
                    treeSets[groupNum].add(next)
                    groupNums[next] = groupNum
                    dfs(next)
                }
            }
        }

        for (i in 1..c) {
            if (!visited[i]){
                visited[i] = true
                groupNums[i] = groupNum
                val tree = TreeSet<Int>()
                tree.add(i)
                treeSets.add(tree)
                dfs(i)
                groupNum++
            }
        }
        val list = mutableListOf<Int>()
        for (query in queries) {
            val op = query[0]
            val node = query[1]
            val group = groupNums[node]
            val tree = treeSets[group]
            if (op == 1) {
                if (tree.contains(node)) {
                    list.add(node)
                } else {
                    list.add(tree.firstOrNull() ?: -1)
                }
            } else {
                tree.remove(node)
            }
        }
        return list.toIntArray()
    }
}