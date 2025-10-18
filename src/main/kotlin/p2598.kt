package p2598

// editorial 풀이
class Solution {
    fun findSmallestInteger(nums: IntArray, value: Int): Int {
        val count = IntArray(value)
        for (num in nums) {
            val key = ((num % value) + value) % value
            count[key]++
        }
        var mex = 0
        while (count[mex % value] > 0) {
            count[mex % value]--
            mex++
        }
        return mex
    }
}

// 두번째 풀이
//class Solution {
//    fun findSmallestInteger(nums: IntArray, value: Int): Int {
//        val count = IntArray(value)
//        for (i in nums.indices) {
//            var num = nums[i]
//            if (num < 0) {
//                num *= -1
//                num = (value - (num % value)) % value
//            } else {
//                num %= value
//            }
//            count[num]++
//        }
//        val minCount = count.min()
//        if (count.all { it == minCount }) {
//            return value * (minCount)
//        }
//        for (i in 0 until value) {
//            if (count[i] == minCount) {
//                return i + (minCount * value)
//            }
//        }
//        return -1
//    }
//}

// 첫 풀이
//class Solution {
//    fun findSmallestInteger(nums: IntArray, value: Int): Int {
//        val map = mutableMapOf<Int, Int>()
//        for (i in nums.indices) {
//            var num = nums[i]
//            if (num < 0) {
//                num *= -1
//                num = (value - (num % value)) % value
//            } else {
//                num %= value
//            }
//            map[num] = (map[num] ?: 0) + 1
//        }
//        val list = mutableListOf<Int>()
//        for ((k,v) in map) {
//            for (i in 0 until v) {
//                list.add(k + value * i)
//            }
//        }
//        list.sort()
//        if (list[0] != 0) {
//            return 0
//        }
//        for (i in 0..<list.size - 1) {
//            if (list[i] == list[i+1] || list[i] == list[i+1] - 1) {
//                continue
//            } else {
//                return list[i] + 1
//            }
//        }
//        return list.last() + 1
//    }
//}