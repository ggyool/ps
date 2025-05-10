package p2918

class Solution {
    fun minSum(nums1: IntArray, nums2: IntArray): Long {
        val sum1 = nums1.sumOf { it.toLong() }
        val count1 = nums1.count { it == 0 }
        val sum2 = nums2.sumOf { it.toLong() }
        val count2 = nums2.count { it == 0 }

        val target = Math.max(sum1 + count1, sum2 + count2)
        if (sum1 < target && count1 == 0) return -1
        if (sum2 < target && count2 == 0) return -1
        return target
    }
}
