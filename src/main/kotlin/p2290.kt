package p2290

import java.util.*

fun main() {


}


class Solution {
    fun minimumObstacles(grid: Array<IntArray>): Int {
        val dy = intArrayOf(0, 1, 0, -1)
        val dx = intArrayOf(1, 0, -1, 0)
        val m = grid.size
        val n = grid[0].size
        val visited = Array(m) {
            BooleanArray(n) { false }
        }
        visited[0][0] = true
        val pq = PriorityQueue<Info>(compareBy { it.cost })
        pq.add(Info(0, 0, 0))

        while (!pq.isEmpty()) {
            val cur = pq.poll()

            for (d in 0 until 4) {
                val ny = cur.y + dy[d]
                val nx = cur.x + dx[d]
                if (ny < 0 || ny >= m || nx < 0 || nx >= n || visited[ny][nx]) {
                    continue
                }
                val nCost = cur.cost + grid[ny][nx]
                if (ny == m - 1 && nx == n - 1) {
                    return nCost
                }
                visited[ny][nx] = true
                pq.add(Info(nCost, ny, nx))
            }
        }
        return -1
    }

    class Info(
        val cost: Int,
        val y: Int,
        val x: Int,
    )
}