package p3011


fun main() {
    Solution().canSortArray(intArrayOf(8, 4, 2, 30, 15))
}

class Solution {
    fun canSortArray(nums: IntArray): Boolean {
        if (nums.size == 1) {
            return true
        }
        val cntArr = IntArray(nums.size)
        for (i in nums.indices) {
            val n = nums[i]
            val bin = n.toString(2)
            cntArr[i] = bin.count { it -> it == '1' }
        }

        var startIdx = 0
        var endIdx = 0
        val lst = mutableListOf<Int>()
        for (i in 1..<nums.size) {
            if (cntArr[i - 1] == cntArr[i]) {
                endIdx = i
            } else {
                    lst.addAll(nums.slice(startIdx..endIdx).sorted())
                startIdx = i
                endIdx = i
            }
        }
        lst.addAll(nums.slice(startIdx..endIdx).sorted())
        for (i in 1..<lst.size) {
            if (lst[i-1] > lst[i]) return false
        }

        return true
    }
}