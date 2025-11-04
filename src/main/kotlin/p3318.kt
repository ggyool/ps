package p3318

class Solution {
    fun findXSum(nums: IntArray, k: Int, x: Int): IntArray {
        val count = IntArray(51)
        for (i in 0..<k) {
            count[nums[i]]++
        }
        val list = mutableListOf<Int>()
        list.add(calcXSum(nums, 0, k - 1, count, x))
        for (right in k..<nums.size) {
            val befLeft = right - k
            count[nums[befLeft]]--
            count[nums[right]]++
            list.add(calcXSum(nums, befLeft + 1, right, count, x))
        }
        return list.toIntArray()
    }

    fun calcXSum(nums: IntArray, left: Int, right: Int, count: IntArray, x: Int): Int {
        val list = mutableListOf<Pair<Int, Int>>()
        for (i in count.indices) {
            if (count[i] != 0) {
                list.add(Pair(count[i], i))
            }
        }
        list.sortWith { a, b ->
            if (a.first == b.first) {
                b.second - a.second
            } else {
                b.first - a.first
            }
        }
        val remainNums = list.filterIndexed { idx, pair ->
            if (idx < x) true
            else false
        }
            .map { it.second }
            .toSet()

        var ret = 0
        for (i in left..right) {
            if (remainNums.contains(nums[i])) {
                ret += nums[i]
            }
        }
        return ret
    }
}