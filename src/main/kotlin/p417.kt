package p417

import java.util.LinkedList

class Solution {
    fun pacificAtlantic(heights: Array<IntArray>): List<List<Int>> {
        val r = heights.size
        val c = heights[0].size

        fun notInRange(y: Int, x: Int): Boolean {
            return y < 0 || y >= r || x < 0 || x >= c
        }

        val isPacific = Array(r) { BooleanArray(c) }
        val isAtlantic = Array(r) { BooleanArray(c)}
        val pacificQueue = LinkedList<Pair<Int, Int>>()
        val atlanticQueue = LinkedList<Pair<Int, Int>>()
        for (i in 0 until r) {
            for (j in 0 until c) {
                if (i == 0 || j == 0) {
                    if (!isPacific[i][j]) {
                        pacificQueue.add(Pair(i, j))
                    }
                    isPacific[i][j] = true
                }
                if (i == r - 1 || j == c - 1) {
                    if (!isAtlantic[i][j]) {
                        atlanticQueue.add(Pair(i, j))
                    }
                    isAtlantic[i][j] = true
                }
            }
        }

        val dy = intArrayOf(0, 1, 0, -1)
        val dx = intArrayOf(1, 0, -1, 0)
        while (!pacificQueue.isEmpty()) {
            val pos = pacificQueue.poll()
            val y = pos.first
            val x = pos.second
            for (i in 0 until 4) {
                val ny = y + dy[i]
                val nx = x + dx[i]
                if (notInRange(ny, nx) || isPacific[ny][nx]) continue
                if (heights[y][x] <= heights[ny][nx]) {
                    isPacific[ny][nx] = true
                    pacificQueue.add(Pair(ny, nx))
                }
            }
        }

        while (!atlanticQueue.isEmpty()) {
            val pos = atlanticQueue.poll()
            val y = pos.first
            val x = pos.second
            for (i in 0 until 4) {
                val ny = y + dy[i]
                val nx = x + dx[i]
                if (notInRange(ny, nx) || isAtlantic[ny][nx]) continue
                if (heights[y][x] <= heights[ny][nx]) {
                    isAtlantic[ny][nx] = true
                    atlanticQueue.add(Pair(ny, nx))
                }
            }
        }
        val list = mutableListOf<List<Int>>()
        for (i in 0 until r) {
            for (j in 0 until c) {
                if (isPacific[i][j] && isAtlantic[i][j]) {
                    list.add(listOf(i, j))
                }
            }
        }
        return list
    }
}