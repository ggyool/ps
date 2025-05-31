package p909

import java.util.*
import kotlin.math.min

class Solution {
    fun snakesAndLadders(board: Array<IntArray>): Int {
        val lst = mutableListOf<Int>()
        lst.add(-1)
        val r = board.size
        val c = board[0].size
        var dir = 0 // right
        for (i in r - 1 downTo 0 step 1) {
            for (j in 0..<c) {
                if (dir == 0) {
                    lst.add(board[i][j])
                } else {
                    lst.add(board[i][c - 1 - j])
                }
            }
            dir = 1 - dir
        }
        val dist = IntArray(lst.size) { Int.MAX_VALUE }
        val visited = BooleanArray(lst.size) { false }
        return bfs(dist, visited, lst)
    }

    fun bfs(dist: IntArray, visited: BooleanArray, lst: MutableList<Int>): Int {
        val q = LinkedList<Info>()
        visited[1] = true
        dist[1] = 0
        q.add(Info(1, 0))
        while (!q.isEmpty()) {
            val cur = q.poll()
            val maxNext = min(cur.index + 6, lst.size - 1)
            for (i in cur.index + 1..maxNext) {
                if (visited[i]) continue
                visited[i] = true
                dist[i] = min(dist[i], cur.dist + 1)
                if (lst[i] != -1) {
                    dist[lst[i]] = min(dist[lst[i]], cur.dist + 1)
                    q.add(Info(lst[i], cur.dist + 1))
                } else {
                    dist[i] = min(dist[i], cur.dist + 1)
                    q.add(Info(i, cur.dist + 1))
                }
            }
        }
        if (dist[lst.size - 1] == Int.MAX_VALUE) return -1
        return dist[lst.size - 1]
    }

    data class Info(
        val index: Int,
        val dist: Int,
    )
}