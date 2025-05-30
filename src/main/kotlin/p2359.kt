package p2359

class Solution {
    fun closestMeetingNode(edges: IntArray, node1: Int, node2: Int): Int {
        val n = edges.size

        val dist1 = IntArray(n) { -1 }
        dist1[node1] = 0
        run(node1, dist1, edges)

        val dist2 = IntArray(n) { -1 }
        dist2[node2] = 0
        run(node2, dist2, edges)

        var ret = -1
        var maxDist = Int.MAX_VALUE
        for (i in 0..<n) {
            if (dist1[i] == -1 || dist2[i] == -1) continue
            val temp = Math.max(dist1[i], dist2[i])
            if (temp < maxDist) {
                maxDist = temp
                ret = i
            }
        }
        return ret
    }

    fun run(cur: Int, dist: IntArray, edges: IntArray) {
        val next = edges[cur]
        if (next == -1 || dist[next] != -1) {
            return
        }
        dist[next] = dist[cur] + 1
        run(next, dist, edges)
    }
}