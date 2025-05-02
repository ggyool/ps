package p2563

class Solution {
    fun countFairPairs(nums: IntArray, lower: Int, upper: Int): Long {
        var ret = 0L
        val lst = nums.toList().sorted()
        for (i in lst.indices) {
            if (i == lst.size - 1) continue
            val num = lst[i]
            val lowerBound = lst.lowerBound(lower - num, i + 1)
            val upperBound = lst.upperBound(upper - num, i + 1)
            ret += (upperBound - lowerBound)
        }
        return ret
    }

    fun List<Int>.lowerBound(target: Int, startIdx: Int = 0, endIdx: Int = this.size): Int {
        var left = startIdx
        var right = endIdx
        while (left < right) {
            val mid = left + (right - left) / 2
            if (this[mid] < target) {
                left = mid + 1
            } else {
                right = mid
            }
        }
        return right
    }

    fun List<Int>.upperBound(target: Int, startIdx: Int = 0, endIdx: Int = this.size): Int {
        var left = startIdx
        var right = endIdx
        while (left < right) {
            val mid = left + (right - left) / 2
            if (this[mid] <= target) {
                left = mid + 1
            } else {
                right = mid
            }
        }
        return right
    }
}