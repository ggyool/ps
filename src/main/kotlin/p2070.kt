package p2070

import kotlin.math.max

fun main() {

//    val lst = listOf(3,4,6)
//    println(lst.binarySearch(1))
    val a = arrayOf(
        intArrayOf(1,2),
        intArrayOf(3,2),
        intArrayOf(2,4),
        intArrayOf(5,6),
        intArrayOf(3,5),
    )
    val b= intArrayOf(1,2,3,4,5,6)
    println(Solution().maximumBeauty(a,b))
}

class Solution {
    fun maximumBeauty(items: Array<IntArray>, queries: IntArray): IntArray {
        items.sortWith(compareBy({ it[0] }, { it[1] }))

        val lst = mutableListOf<IntArray>()
        var temp = 0
        for (i in items.indices) {
            val item = items[i]
            val price = item[0]
            val beauty = item[1]
            temp = max(temp, beauty)
            if (i == items.size - 1 || price < items[i + 1][0]) {
                lst.add(intArrayOf(price, temp))
            }
        }
        var ret = IntArray(queries.size)
        for (i in queries.indices) {
            val query = queries[i]
            val idx = lst.binarySearch { it[0].compareTo(query) }
            if (idx >= 0) {
                ret[i] = lst[idx][1]
            } else {
                val ti = (idx * -1) - 1
                if (ti == 0) {
                    ret[i] = 0
                } else {
                    ret[i] = lst[ti - 1][1]
                }
            }
        }
        return ret
    }
}