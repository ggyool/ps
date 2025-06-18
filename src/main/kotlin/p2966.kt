package p2966

class Solution {
    fun divideArray(nums: IntArray, k: Int): Array<IntArray> {
        nums.sort()

        val ans = Array(nums.size / 3) {
            IntArray(3)
        }
        for (i in nums.indices) {
            val group = i / 3
            val idx = i % 3
            ans[group][idx] = nums[i]
        }

        for (arr in ans) {
            if (arr.last() - arr.first() > k) {
                return emptyArray()
            }
        }
        return ans
    }
}