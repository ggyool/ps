package p2461

fun main() {

}

class Solution {
    fun maximumSubarraySum(nums: IntArray, k: Int): Long {
        var ans = 0L
        val mp = HashMap<Int, Int>()
        var sum = 0L
        for (i in 0 until k) {
            val num = nums[i]
            sum += num
            mp[num] = (mp[num] ?: 0) + 1
            if (mp.size == k) {
                ans = maxOf(ans, sum)
            }
        }
        val len = nums.size
        for (i in k..<len) {
            val oldNum = nums[i - k]
            sum -= oldNum
            if (mp[oldNum] == 1) {
                mp.remove(oldNum)
            } else {
                mp[oldNum] = mp[oldNum]!! - 1
            }
            val newNum = nums[i]
            sum += newNum
            mp[newNum] = (mp[newNum] ?: 0) + 1
            if (mp.size == k) {
                ans = maxOf(ans, sum)
            }
        }
        return ans
    }
}