package p838

fun main() {
    val res = Solution().pushDominoes(".L.R...LR..L..")
    println(res)    // LL.RR.LLRRLL..
}

// 힘으로 생각하여 중간에 만나는 경우를 쉽게 해결하는 풀이
class Solution {
    fun pushDominoes(dominoes: String): String {
        val len = dominoes.length
        val forces: IntArray = IntArray(len)

        // 오른 방향으로 넘어지는 힘
        var force = 0
        for (i in dominoes.indices) {
            val dir = dominoes[i]
            if (dir == 'R') {
                force = len
            } else if (dir == 'L') {
                force = 0
            } else {
                force = Math.max(--force, 0)
            }
            forces[i] += force
        }

        // 왼 방향으로 넘어지는 힘
        force = 0
        for (i in dominoes.indices.reversed()) {
            val dir = dominoes[i]
            if (dir == 'L') {
                force = len
            } else if (dir == 'R') {
                force = 0
            } else {
                force = Math.max(--force, 0)
            }
            forces[i] -= force
        }
        val sb = StringBuilder()
        for (f in forces) {
            if (f > 0) sb.append('R')
            else if (f < 0) sb.append('L')
            else sb.append('.')
        }
        return sb.toString()
    }
}

// L....L -> 다 L로 채우기
// L....R -> 안 채우기
// R....L -> 다 RL 섞어서 채우기
// R....R -> 다 R로 채우기
//class Solution {
//
//    fun pushDominoes(dominoes: String): String {
//        val ans = dominoes.toCharArray()
//        val lst = mutableListOf<Pair>()
//        lst.add(Pair(-1, 'L'))
//        for (i in dominoes.indices) {
//            if (dominoes[i] == 'L') {
//                lst.add(Pair(i, 'L'))
//            } else if (dominoes[i] == 'R') {
//                lst.add(Pair(i, 'R'))
//            }
//        }
//        lst.add(Pair(dominoes.length, 'R'))
//
//        for (i in lst.indices) {
//            if (i == lst.size - 1) continue
//            val curIdx = lst[i].idx
//            val curDir = lst[i].dir
//            val nextIdx = lst[i + 1].idx
//            val nextDir = lst[i + 1].dir
//
//            if (curDir == nextDir) {
//                for (j in curIdx + 1 until nextIdx) {
//                    ans[j] = curDir
//                }
//            } else if (curDir == 'R' && nextDir == 'L') {
//                for (j in curIdx + 1 until nextIdx) {
//                    val criteria = (curIdx + nextIdx) / 2
//                    if (j == criteria) {
//                        if ((curIdx + nextIdx) % 2 == 0) {
//                            ans[j] = '.'
//                        } else {
//                            ans[j] = 'R'
//                        }
//                    }
//                    else if (j < criteria) ans[j] = 'R'
//                    else ans[j] = 'L'
//                }
//            }
//        }
//        return String(ans)
//    }
//
//    data class Pair(
//        val idx: Int,
//        val dir: Char,
//    )
//}

// 처음에 구현으로 단순하게 풀었는데 빠르지 않음
// 답보니 신기한 풀이 2개가 있어서 하나씩 풀어봄
//class Solution {
//    fun pushDominoes(dominoes: String): String {
//        val lst = dominoes.toMutableList()
//        val q = ArrayDeque<Pair>()
//        for (i in lst.indices) {
//            val c = lst[i]
//            if (c == 'L' || c == 'R') {
//                q.addLast(Pair(i, c))
//            }
//        }
//        while (!q.isEmpty()) {
//            val s = q.size
//            val nextLeftSt = mutableSetOf<Int>()
//            val nextRightSt = mutableSetOf<Int>()
//            for (i in 0 until s) {
//                val pair = q.removeFirst()
//                var nextIdx = pair.idx
//                if (pair.dir == 'L') {
//                    nextIdx--
//                    if (nextIdx >= 0 && nextIdx < lst.size) {
//                        nextLeftSt.add(nextIdx)
//                    }
//                } else {
//                    nextIdx++
//                    if (nextIdx >= 0 && nextIdx < lst.size) {
//                        nextRightSt.add(nextIdx)
//                    }
//                }
//            }
//            for (i in nextLeftSt) {
//                if (nextRightSt.contains(i)) {
//                    nextRightSt.remove(i)
//                    continue
//                }
//                if (lst[i] != '.') continue
//                lst[i] = 'L'
//                q.addLast(Pair(i, 'L'))
//            }
//            for (i in nextRightSt) {
//                if (lst[i] != '.') continue
//                lst[i] = 'R'
//                q.addLast(Pair(i, 'R'))
//            }
//        }
//        return lst.joinToString("")
//    }
//
//    data class Pair(
//        val idx: Int,
//        val dir: Char,
//    )
//}