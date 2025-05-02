package p1861

fun main() {
    val box = arrayOf(
        charArrayOf('#','#','*','.','*','.'),
        charArrayOf('#','#','#','*','.','.'),
        charArrayOf('#','#','#','.','#','.')
    )
    Solution().rotateTheBox(box)
}

class Solution {
    fun rotateTheBox(box: Array<CharArray>): Array<CharArray> {
        // (i,j) -> (j, r -1 - i)
        val r = box.size
        val c = box[0].size
        val newBox = Array(c) {
            CharArray(r)
        }

        for( i in 0 until  r) {
            for( j in 0 until  c) {
                newBox[j][r - 1 - i] = box[i][j]
            }
        }
        val nr = newBox.size
        val nc = newBox[0].size

        for (i in nr - 1 downTo  0) {
            for (j in 0 until  nc) {
                if (newBox[i][j] == '#') {
                    move(i, j, newBox)
                }
            }
        }
        return newBox
    }

    private fun move(y: Int, x: Int, arr: Array<CharArray>) {
        val r = arr.size
        var targetY = y
        for (j in y + 1 until r) {
            if (arr[j][x] == '.') {
                targetY = j
            } else if (arr[j][x] == '#' || arr[j][x] == '*') {
                break
            }
        }
        arr[y][x] = '.'
        arr[targetY][x] = '#'
    }
}