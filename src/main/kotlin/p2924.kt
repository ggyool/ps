package p2924

fun main() {

}

class Solution {
    fun findChampion(n: Int, edges: Array<IntArray>): Int {
        val winList = HashMap<Int, MutableSet<Int>>().apply {
            for (i in 0 until n) {
                this[i] = mutableSetOf()
            }
        }
        val loseList = HashMap<Int, MutableSet<Int>>().apply {
            for (i in 0 until n) {
                this[i] = mutableSetOf()
            }
        }

        for (edge in edges) {
            winList[edge[0]]!!.add(edge[1])
            loseList[edge[1]]!!.add(edge[0])
        }
        var cnt = 0
        var ans = -1
        for (i in 0 until n) {
            if (winList[i]!!.size >= 0 && loseList[i]!!.size == 0) {
                ++cnt
                ans = i
            }
        }
        return if (cnt == 1) ans else -1
    }
}