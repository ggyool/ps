package p3446

class Solution {
    fun sortMatrix(grid: Array<IntArray>): Array<IntArray> {
        val n = grid.size

        val inRange: (Int, Int) -> Boolean = { y, x ->
            y in 0..<n && x in 0..<n
        }
        // left-bottom diagonal
        for (sy in 0..<n) {
            var i = sy
            var j = 0
            val list = mutableListOf<Int>()
            while (inRange(i, j)) {
                list.add(grid[i][j])
                i++
                j++
            }
            list.sortDescending()

            i = sy
            j = 0
            var idx = 0
            while (inRange(i, j)) {
                grid[i][j] = list[idx++]
                i++
                j++
            }
        }
        // right-top diagonal
        for (sx in 1..<n) {
            var i = 0
            var j = sx
            val list = mutableListOf<Int>()
            while (inRange(i, j)) {
                list.add(grid[i][j])
                i++
                j++
            }
            list.sort()

            i = 0
            j = sx
            var idx = 0
            while (inRange(i, j)) {
                grid[i][j] = list[idx++]
                i++
                j++
            }
        }
        return grid
    }
}