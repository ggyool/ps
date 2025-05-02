package p1975

import kotlin.math.abs

fun main() {

}

class Solution {
    fun maxMatrixSum(matrix: Array<IntArray>): Long {
        // 생각해보니 음수가 1개만 남도록 만들 수 있다.
        // 가장 절대값이 작은걸 음수로 남기면 될듯
        // 오.. 반례 0이있으면 음수 다 지우기 가능
        var negCount = 0
        var minAbsNum = Int.MAX_VALUE
        var absSum = 0L
        for (rows in matrix) {
            for (value in rows) {
                val absValue = abs(value)
                minAbsNum = minOf(minAbsNum, absValue)
                absSum += absValue
                if (value < 0) {
                    negCount++
                }
            }
        }
        if (negCount % 2 == 0) {
            return absSum
        }
        return absSum + -2 * minAbsNum
    }
}