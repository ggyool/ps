package p3000

class Solution {
    fun areaOfMaxDiagonal(dimensions: Array<IntArray>): Int {
        var maxDiagonal = 0
        var maxArea = 0
        for (dimension in dimensions) {
            val w = dimension[0]
            val h = dimension[1]
            val area = w * h
            val diagonal = w * w + h * h
            if (diagonal > maxDiagonal) {
                maxDiagonal = diagonal
                maxArea = area
            } else if (diagonal == maxDiagonal && area > maxArea) {
                maxArea = area
            }
        }
        return maxArea
    }
}