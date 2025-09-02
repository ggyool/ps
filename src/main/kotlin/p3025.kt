package p3025

class Solution {
    fun numberOfPairs(points: Array<IntArray>): Int {
        points.sortWith { a, b ->
            if (a[0] != b[0]) {
                a[0].compareTo(b[0])
            } else {
                b[1].compareTo(a[1])
            }
        }
        var ret = 0
        for (i in 0..<points.size) {
            val x = points[i][0]
            val y = points[i][1]
            var tmp = -1
            for (j in i + 1..<points.size) {
                val tx = points[j][0]
                val ty = points[j][1]
                if (x == tx && y == ty) break
                if (y >= ty && tmp < ty) {
                    tmp = ty
                    ret++
                }
            }
        }
        return ret
    }
}