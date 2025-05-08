package p3342

import java.util.*

class Solution {
    fun minTimeToReach(moveTime: Array<IntArray>): Int {
        val dy = intArrayOf(0, 1, 0, -1)
        val dx = intArrayOf(1, 0, -1, 0)
        val r = moveTime.size
        val c = moveTime[0].size
        val dist = Array(r) { IntArray(c) { -1 } }
        val pq = PriorityQueue<Info>(compareBy { it.time })
        dist[0][0] = 0
        pq.add(Info(0, 0, 0, 2))
        while (!pq.isEmpty()) {
            val cur = pq.poll()
            for (i in 0 until 4) {
                val ny = cur.y + dy[i]
                val nx = cur.x + dx[i]
                if (ny < 0 || nx < 0 || ny >= r || nx >= c) continue
                var nTime = Math.max(cur.time, moveTime[ny][nx])
                if (cur.prevSecond == 2) nTime += 2;
                else nTime += 1
                if (dist[ny][nx] != -1 && dist[ny][nx] <= nTime) continue
                dist[ny][nx] = nTime
                pq.add(Info(nTime, ny, nx, 3 - cur.prevSecond))
            }
        }
        return dist[r - 1][c - 1]
    }

    data class Info(
        val time: Int,
        val y: Int,
        val x: Int,
        val prevSecond: Int
    )
}