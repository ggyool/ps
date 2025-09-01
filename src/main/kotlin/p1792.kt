package p1792

import java.util.PriorityQueue

class Solution {
    fun maxAverageRatio(classes: Array<IntArray>, extraStudents: Int): Double {
        fun calcDiff(arr: IntArray): Double {
            return (arr[0] + 1).toDouble() / (arr[1] + 1) - arr[0].toDouble() / arr[1]
        }
        val pq = PriorityQueue<IntArray> { a, b ->
            val da = calcDiff(a)
            val db = calcDiff(b)
            if (da > db) {
                -1
            } else if (da < db) {
                1
            } else {
                0
            }
        }
        for (cls in classes) {
            pq.add(cls)
        }

        var extra = extraStudents
        while (extra > 0 && !pq.isEmpty()) {
            val cls = pq.poll()
            pq.add(intArrayOf(cls[0] + 1, cls[1] + 1))
            extra--
        }
        var sum = 0.0
        val cnt = pq.size
        while (!pq.isEmpty()) {
            val cls = pq.poll()
            sum += (cls[0].toDouble() / cls[1])
        }
        return sum / cnt
    }
}