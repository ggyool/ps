package p821

import kotlin.math.abs
import kotlin.math.max

class Solution {
    fun largestTriangleArea(points: Array<IntArray>): Double {
        var ret = 0.0
        for (i in 0 until points.size - 2) {
            for (j in i + 1 until points.size - 1) {
                for (k in j + 1 until points.size) {
                    val x1 = points[i][0]
                    val y1 = points[i][1]
                    val x2 = points[j][0]
                    val y2 = points[j][1]
                    val x3 = points[k][0]
                    val y3 = points[k][1]
                    // 신발끈 공식
                    ret = max(ret, abs(x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2)) / 2.0)

                }
            }
        }
        return ret
    }
}

