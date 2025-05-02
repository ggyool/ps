package p743

import java.util.*

class Solution {
    fun networkDelayTime(times: Array<IntArray>, n: Int, k: Int): Int {
        val minDist = IntArray(n + 1) { Int.MAX_VALUE }
        val pq = PriorityQueue<Edge>(compareBy { it.dist })
        val edges = Array(n + 1) { mutableListOf<Edge>() }
        for (time in times) {
            val from = time[0]
            val to = time[1]
            val dist = time[2]
            edges[from].add(Edge(from, to, dist))
            if (from == k) pq.add(Edge(from, to, dist))
        }
        minDist[k] = 0
        while (pq.isNotEmpty()) {
            val cur = pq.poll()
            val from = cur.from
            val to = cur.to
            val dist = cur.dist
            if (minDist[from] + dist < minDist[to]) {
                minDist[to] = minDist[from] + dist
                edges[to].forEach {
                    pq.add(it)
                }
            }
        }
        var ans = 0
        for (i in 1..n) {
            if (i == k) continue
            ans = maxOf(ans, minDist[i])
        }
        if (ans == Int.MAX_VALUE) return -1
        return ans
    }

    inner class Edge(val from: Int, val to: Int, val dist: Int)
}