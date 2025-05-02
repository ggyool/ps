package Main_10_18_2044

fun main() {

}

//class Solution {
//    fun countMaxOrSubsets(nums: IntArray): Int {
//
//        // 2 1 4
//        val dp = IntArray()
//        var max = 0
//        for (n in nums) {
//            max = max or n
//        }
//    }
//
//
//}

//class Solution {
//    fun countMaxOrSubsets(nums: IntArray): Int {
//        var target = 0
//        for (n in nums) {
//            target = target or n
//        }
//        return solve(0, 0, target, nums.toList())
//    }
//
//    fun solve(idx: Int, bitValue: Int, target: Int, lst: List<Int>): Int {
//        if (idx >= lst.size) {
//            return if (bitValue == target) 1
//            else 0
//        }
//        return solve(idx + 1, bitValue or lst[idx], target, lst) + solve(idx + 1, bitValue, target, lst)
//    }
//
//}