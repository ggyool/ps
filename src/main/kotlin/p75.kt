package p75

class Solution {
    fun sortColors(nums: IntArray): Unit {
        var zero = 0
        var one = 0
        var two = 0
        for (num in nums) {
            if (num == 0) {
                zero++
            }
            if (num == 1) {
                one++
            }
            if (num == 2) {
                two++
            }
        }
        var i = 0
        while (zero > 0 || one > 0 || two > 0) {
            if (zero-- > 0) {
                nums[i] = 0
            } else if (one-- > 0) {
                nums[i] = 1
            } else if (two-- > 0) {
                nums[i] = 2
            }
            i++
        }
    }
}