package p2257

fun main() {

}

class Solution {

    fun countUnguarded(m: Int, n: Int, guards: Array<IntArray>, walls: Array<IntArray>): Int {
        val arr = Array(m) {
            IntArray(n) { EMPTY }
        }
        for (guard in guards) {
            arr[guard[0]][guard[1]] = GUARD
        }
        for (wall in walls) {
            arr[wall[0]][wall[1]] = WALL
        }
        for (i in 0 until m) {
            for (j in 0 until n) {
                if (check(i, j, arr, GUARD)) {
                    go(i, j, arr);
                }
            }
        }
        var ans = 0
        for (i in 0 until m) {
            for (j in 0 until n) {
                if (arr[i][j] == EMPTY) {
                    ++ans
                }
            }
        }
        return ans
    }

    private fun go(y: Int, x: Int, arr: Array<IntArray>) {
        val r = arr.size
        val c = arr[0].size
        // 오른쪽 체크
        for (j in x + 1 until c) {
            if (check(y, j, arr, GUARD) || check(y, j, arr, WALL) || check(y, j, arr, LEFT) || check(y, j, arr, RIGHT))
                break
            arr[y][j] = arr[y][j] or RIGHT
        }
        // 왼쪽 체크
        for (j in x - 1 downTo 0) {
            if (check(y, j, arr, GUARD) || check(y, j, arr, WALL) || check(y, j, arr, LEFT) || check(y, j, arr, RIGHT))
                break
            arr[y][j] = arr[y][j] or LEFT
        }
        // 아래 체크
        for (i in y + 1 until r) {
            if (check(i, x, arr, GUARD) || check(i, x, arr, WALL) || check(i, x, arr, UP) || check(i, x, arr, DOWN))
                break
            arr[i][x] = arr[i][x] or DOWN
        }
        // 위 체크
        for (i in y - 1 downTo  0) {
            if (check(i, x, arr, GUARD) || check(i, x, arr, WALL) || check(i, x, arr, UP) || check(i, x, arr, DOWN))
                break
            arr[i][x] = arr[i][x] or UP
        }
    }

    private fun check(y: Int, x: Int, arr: Array<IntArray>, type: Int): Boolean {
        return arr[y][x] and type > 0
    }

    companion object {
        const val EMPTY = 0
        const val RIGHT = 1
        const val DOWN = 2
        const val LEFT = 4
        const val UP = 8
        const val GUARD = 16
        const val WALL = 32
    }
}