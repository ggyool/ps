package p3289

class Solution {
    fun getSneakyNumbers(nums: IntArray): IntArray {
        val list = mutableListOf<Int>()
        val checked = BooleanArray(101)
        for (num in nums) {
            if (!checked[num]) {
                checked[num] = true
            } else {
                list.add(num)
            }
        }
        return list.toIntArray()
    }
}