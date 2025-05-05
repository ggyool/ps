package p1920

class Solution {
    fun buildArray(nums: IntArray): IntArray {
        return IntArray(nums.size){
            nums[nums[it]]
        }
    }
}