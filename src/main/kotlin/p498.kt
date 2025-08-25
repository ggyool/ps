package p498

class Solution {
    fun findDiagonalOrder(mat: Array<IntArray>): IntArray {
        val r = mat.size
        val c = mat[0].size
        if (r == 1 && c == 1) {
            return intArrayOf(mat[0][0])
        }
        if (r == 1 && c != 1) {
            return mat[0]
        }
        if (r != 1 && c == 1) {
            return mat.map { it[0] }.toIntArray()
        }
        fun isRightDownEdge(y: Int, x: Int): Boolean {
            return y == r - 1 && x == c - 1
        }

        fun isLeftDownEdge(y: Int, x: Int): Boolean {
            return y == r - 1 && x == 0
        }

        fun isRightUpEdge(y: Int, x: Int): Boolean {
            return y == 0 && x == c - 1
        }

        fun isHorizontalEdge(y: Int, x: Int): Boolean {
            return y == 0 || y == r - 1
        }

        fun isVerticalEdge(y: Int, x: Int): Boolean {
            return x == 0 || x == c - 1
        }

        val list = mutableListOf<Int>()

        // 0: right upper / 1: left down
        var dir = 0
        val dy = intArrayOf(-1, 1)
        val dx = intArrayOf(1, -1)
        var y = 1
        var x = -1
        while (!isRightDownEdge(y, x)) {
            y += dy[dir]
            x += dx[dir]
            list.add(mat[y][x])
            if (isRightUpEdge(y, x)) {
                y++
                list.add(mat[y][x])
                dir = 1 - dir
            } else if (isLeftDownEdge(y, x)) {
                x++
                list.add(mat[y][x])
                dir = 1 - dir
            } else if (isHorizontalEdge(y, x)) {
                x++
                list.add(mat[y][x])
                dir = 1 - dir
            } else if (isVerticalEdge(y, x)) {
                y++
                list.add(mat[y][x])
                dir = 1 - dir
            }
        }
        return list.toIntArray()
    }
}