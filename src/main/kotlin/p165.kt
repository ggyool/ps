package p165

import kotlin.math.max

class Solution {
    fun compareVersion(version1: String, version2: String): Int {
        var arr1 = version1.split(".")
        val arr2 = version2.split(".")
        val cnt = max(arr1.size, arr2.size)
        for (i in 0..<cnt) {
            val v1 = if (i < arr1.size) arr1[i].toInt() else {
                0
            }
            val v2 = if (i < arr2.size) arr2[i].toInt() else {
                0
            }
            if (v1 < v2) return -1
            else if (v1 > v2) return 1
        }
        return 0
    }
}