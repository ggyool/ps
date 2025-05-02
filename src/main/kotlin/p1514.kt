package p1514

import java.util.*

fun main() {

}

class Solution {
    fun maxProbability(n: Int, edges: Array<IntArray>, succProb: DoubleArray, start_node: Int, end_node: Int): Double {
        val mp = HashMap<Int, MutableList<Pair<Int, Double>>>().apply {
            for (i in 0 until n) this[i] = mutableListOf()
        }
        val maxDist = DoubleArray(n)
        maxDist[start_node] = 1.0

        val pq = PriorityQueue<Pair<Int, Double>>(compareByDescending { it.second })
        pq.add(Pair(start_node, 1.0))
        for (i in edges.indices) {
            val edge = edges[i]
            mp[edge[0]]!!.add(Pair(edge[1], succProb[i]))
            mp[edge[1]]!!.add(Pair(edge[0], succProb[i]))
        }


        while (pq.isNotEmpty()) {
            val (cur, curDist) = pq.poll()
            if (maxDist[cur] > curDist) continue

            for ((next, dist) in mp[cur]!!) {
                if (maxDist[next] < curDist * dist) {
                    maxDist[next] = curDist * dist
                    pq.add(Pair(next, curDist * dist))
                }
            }
        }
        return maxDist[end_node]
    }
}
