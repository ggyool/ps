package p3516

import kotlin.math.abs

class Solution {
    fun findClosest(x: Int, y: Int, z: Int): Int {
        val diffX = abs(z - x)
        val diffY = abs(z - y)
        if (diffX == diffY) {
            return 0
        } else if (diffX < diffY) {
            return 1
        } else {
            return 2
        }
    }
}