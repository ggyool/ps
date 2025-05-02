package p2577

import java.util.*

fun main() {
    Solution().minimumTime(
        arrayOf(
            intArrayOf(0,1,3,2),
            intArrayOf(5,1,2,5),
            intArrayOf(4,3,8,6),
        )
    )
}

class Solution {
    // 짝수턴에 도착한 칸은 짝수턴에만 올 수 있다
    fun minimumTime(grid: Array<IntArray>): Int {
        // 반례
        if (grid[0][1] > 1 && grid[1][0] > 1) return -1

        val dy = intArrayOf(0, 1, 0, - 1)
        val dx = intArrayOf(1, 0, -1, 0)
        val m = grid.size
        val n = grid[0].size
        val visited = Array(m) { BooleanArray(n) { false } }
        visited[0][0] = true
        val pq = PriorityQueue<Info>(compareBy { it.time })
        pq.add(Info(0, 0, 0))

        while (!pq.isEmpty()) {
            val cur = pq.poll()
            if (cur.y == m - 1 && cur.x == n - 1) return cur.time
            for (d in 0..3) {
                val ny = cur.y + dy[d]
                val nx = cur.x + dx[d]
                if (ny < 0 || ny >= m || nx < 0 || nx >= n || visited[ny][nx]) continue

                visited[ny][nx] = true
                // 지금 갈 수 있는 경우
                if (cur.time + 1 >= grid[ny][nx]) {
                    pq.add(Info(cur.time + 1, ny, nx))
                } else {
                    // 나중에 방문해야 하는 경우
                    if ((ny + nx) % 2 == 0) {
                        if (grid[ny][nx] % 2 == 0) {
                            pq.add(Info(grid[ny][nx], ny, nx))
                        } else {
                            pq.add(Info(grid[ny][nx] + 1, ny, nx))
                        }
                    } else {
                        if (grid[ny][nx] % 2 == 1) {
                            pq.add(Info(grid[ny][nx], ny, nx))
                        } else {
                            pq.add(Info(grid[ny][nx] + 1, ny, nx))
                        }
                    }
                }
            }
        }
        return -1
    }

    class Info(
        val time: Int,
        val y: Int,
        val x: Int,
    )
}
