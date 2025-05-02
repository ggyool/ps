package p838

fun main() {
    val res = Solution().pushDominoes(".L.R...LR..L..")
    // LL.RR.LLRRLL..
    println(res)
}

// 처음에 구현으로 단순하게 풀었는데 빠르지 않음
// 답보니 신기한 풀이 2개가 있어서 하나씩 풀어봄
class Solution {
    fun pushDominoes(dominoes: String): String {
        val lst = dominoes.toMutableList()
        val q = ArrayDeque<Pair>()
        for (i in lst.indices) {
            val c = lst[i]
            if (c == 'L' || c == 'R') {
                q.addLast(Pair(i, c))
            }
        }
        while (!q.isEmpty()) {
            val s = q.size
            val nextLeftSt = mutableSetOf<Int>()
            val nextRightSt = mutableSetOf<Int>()
            for (i in 0 until s) {
                val pair = q.removeFirst()
                var nextIdx = pair.idx
                if (pair.dir == 'L') {
                    nextIdx--
                    if (nextIdx >= 0 && nextIdx < lst.size) {
                        nextLeftSt.add(nextIdx)
                    }
                } else {
                    nextIdx++
                    if (nextIdx >= 0 && nextIdx < lst.size) {
                        nextRightSt.add(nextIdx)
                    }
                }
            }
            for (i in nextLeftSt) {
                if (nextRightSt.contains(i)) {
                    nextRightSt.remove(i)
                    continue
                }
                if (lst[i] != '.') continue
                lst[i] = 'L'
                q.addLast(Pair(i, 'L'))
            }
            for (i in nextRightSt) {
                if (lst[i] != '.') continue
                lst[i] = 'R'
                q.addLast(Pair(i, 'R'))
            }
        }
        return lst.joinToString("")
    }

    data class Pair(
        val idx: Int,
        val dir: Char,
    )
}