package p36

class Solution {
    fun isValidSudoku(board: Array<CharArray>): Boolean {
        val row = Array(9) {
            BooleanArray(10)
        }
        val col = Array(9) {
            BooleanArray(10)
        }
        val square = Array(9) {
            BooleanArray(10)
        }

        fun toSquareIndex(y: Int, x: Int): Int {
            return 3 * (y / 3) + (x / 3)
        }

        for (i in 0..<9) {
            for (j in 0..<9) {
                if (board[i][j] == '.') continue
                val n = board[i][j].digitToInt()
                if (row[i][n]) return false
                if (col[j][n]) return false
                if (square[toSquareIndex(i, j)][n]) return false

                row[i][n] = true
                col[j][n] = true
                square[toSquareIndex(i, j)][n] = true
            }
        }
        return true
    }
}