package p773

fun main() {
    val a = listOf(1, 2, 3)
    val b = listOf(1, 2, 3)

    val mp = HashSet<List<Int>>()
    mp.add(a)
    mp.add(b)
    println(mp.size)
}

class Solution {
    fun slidingPuzzle(board: Array<IntArray>): Int {
        val mp = HashMap<String, Int>()
        val goal = "123450"
        val sb = StringBuilder();

        for (i in 0 until 2) {
            for (j in 0 until 3) {
                sb.append(board[i][j])
            }
        }
        val firstBoard = sb.toString()
        mp[firstBoard] = 0
        val firstZeroIdx = firstBoard.indexOf('0')

        // board, zeroIdx
        val q = ArrayDeque<Pair<String, Int>>()
        q.add(Pair(firstBoard ,firstZeroIdx))

        val dy = intArrayOf(0, 1, 0, -1)
        val dx = intArrayOf(1, 0, -1, 0)
        while (!q.isEmpty()) {
            val cur = q.removeFirst()
            val curBoard = cur.first
            val curIdx = cur.second
            val curY: Int = curIdx / 3
            val curX = curIdx % 3
            val curDist = mp[curBoard]!!

            // 완성한 경우
            if (curBoard == goal) return curDist

            for (d in 0 until 4) {
                val nextY = curY + dy[d]
                val nextX = curX + dx[d]
                // 범위에서 벗어난 경우
                if (nextY < 0 || nextY > 1 || nextX < 0 || nextX > 2) continue

                val nextBoard = swap(curBoard, curY, curX, nextY, nextX)

                // 캐시에 있는 경우
                if (mp[nextBoard] != null) continue

                mp[nextBoard] = curDist + 1
                q.add(Pair(nextBoard, 3 * nextY + nextX))
            }
        }
        return -1
    }

    fun swap(board: String, y1: Int, x1: Int, y2: Int, x2: Int): String {
        val idx1 = y1 * 3 + x1
        val idx2 = y2 * 3 + x2
        val sb = StringBuilder()
        for (i in board.indices) {
            if (i == idx1) {
                sb.append(board[idx2])
            } else if (i == idx2) {
                sb.append(board[idx1])
            } else {
                sb.append(board[i])
            }
        }
        return sb.toString()
    }
}

//class Solution {
//    fun slidingPuzzle(board: Array<IntArray>): Int {
//        val mp = HashMap<List<List<Int>>, Int>()
//        val goal = listOf(
//            mutableListOf(1, 2, 3),
//            mutableListOf(4, 5, 0)
//        )
//
//        // board, zeroY, zeroX
//        val q = ArrayDeque<Triple<List<MutableList<Int>>, Int, Int>>()
//        for (i in 0 until 2) {
//            for (j in 0 until 3) {
//                if (board[i][j] == 0) {
//                    val lstBoard = toList(board)
//                    if (lstBoard.equals(goal)) return 0
//                    q.add(Triple(lstBoard, i, j))
//                    mp[lstBoard] = 0
//                    break
//                }
//            }
//        }
//
//        val dy = intArrayOf(0, 1, 0, -1)
//        val dx = intArrayOf(1, 0, -1, 0)
//        while (!q.isEmpty()) {
//            val cur = q.removeFirst()
//            val curBoard = cur.first
//            val curY = cur.second
//            val curX = cur.third
//            val curDist = mp[curBoard]!!
//
//            for (d in 0 until 4) {
//                val nextY = curY + dy[d]
//                val nextX = curX + dx[d]
//                if (nextY < 0 || nextY > 1 || nextX < 0 || nextX > 2) continue
//
//                val nextBoard = copyBoard(curBoard)
//                swap(nextBoard, curY, curX, nextY, nextX)
//
//                // 완성한 경우
//                if (nextBoard.equals(goal)) return curDist + 1
//
//                // 캐시에 있는 경우
//                if (mp[nextBoard] != null) continue
//                mp[nextBoard] = curDist + 1
//                q.add(Triple(nextBoard, nextY, nextX))
//            }
//        }
//
//        return -1
//    }
//
//    fun toList(board: Array<IntArray>): List<MutableList<Int>> {
//        return board.map { it.toMutableList() }
//    }
//
//    fun copyBoard(board: List<MutableList<Int>>): List<MutableList<Int>> {
//        return board.map { it.toMutableList() }
//    }
//
//    fun swap(board: List<MutableList<Int>>, y1: Int, x1: Int, y2: Int, x2: Int): List<List<Int>> {
//        val tmp = board[y1][x1]
//        board[y1][x1] = board[y2][x2]
//        board[y2][x2] = tmp
//        return board
//    }
//}